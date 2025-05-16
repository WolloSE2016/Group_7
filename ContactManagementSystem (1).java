import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ContactManagementSystem {
    private static final String DATA_FILE = "contacts.dat";

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();

        // Load existing contacts from file
        loadContactsFromFile(contactManager);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Contact Management System");

        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact");
            System.out.println("4. Update a contact");
            System.out.println("5. Delete a contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addContact(scanner, contactManager);
                    saveContactsToFile(contactManager);
                    break;
                case 2:
                    viewAllContacts(contactManager);
                    break;
                case 3:
                    searchContact(scanner, contactManager);
                    break;
                case 4:
                    updateContact(scanner, contactManager);
                    saveContactsToFile(contactManager);
                    break;
                case 5:
                    deleteContact(scanner, contactManager);
                    saveContactsToFile(contactManager);
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using Contact Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void loadContactsFromFile(ContactManager contactManager) {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("No existing contacts file found. Starting with empty contact list.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            List<Contact> contacts = (List<Contact>) ois.readObject();
            contactManager.setContacts(contacts);
            System.out.println("Loaded " + contacts.size() + " contacts from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading contacts from file: " + e.getMessage());
            System.out.println("Starting with empty contact list.");
        }
    }

    private static void saveContactsToFile(ContactManager contactManager) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(contactManager.getAllContacts());
            System.out.println("Contacts saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving contacts to file: " + e.getMessage());
        }
    }

    private static void addContact(Scanner scanner, ContactManager contactManager) {
        System.out.println("\n--- Add a New Contact ---");

        // Get and validate name
        String name = getValidInput(scanner, "Enter name: ", InputValidator::isValidName,
                "Name must contain only letters and spaces.");

        // Get and validate relation type
        String relationType = getValidInput(scanner, "Enter type of relation (Family, Friend, Colleague, etc.): ",
                InputValidator::isValidName,
                "Relation type must contain only letters and spaces.");

        // Get and validate email
        String email = getValidInput(scanner, "Enter email: ", InputValidator::isValidEmail,
                "Email must be in a valid format (e.g., user@example.com).");

        // Get and validate mobile number
        String mobileNumber = getValidInput(scanner, "Enter mobile number: ", InputValidator::isValidMobileNumber,
                "Mobile number must contain only digits.");

        // Get town
        System.out.print("Enter town: ");
        String town = scanner.nextLine();

        Contact newContact = new Contact(name, relationType, email, mobileNumber, town);
        contactManager.addContact(newContact);

        System.out.println("Contact added successfully!");
    }

    private static String getValidInput(Scanner scanner, String prompt, InputValidator validator, String errorMessage) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (validator.isValid(input)) {
                return input;
            } else {
                System.out.println(errorMessage);
            }
        }
    }

    private static void viewAllContacts(ContactManager contactManager) {
        System.out.println("\n--- All Contacts ---");
        List<Contact> contacts = contactManager.getAllContacts();

        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        displayContacts(contacts);
    }

    private static void displayContacts(List<Contact> contacts) {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-15s %-25s %-15s %-20s%n",
                "No.", "Name", "Relation", "Email", "Mobile", "Town");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.printf("%-5d %-20s %-15s %-25s %-15s %-20s%n",
                    (i + 1),
                    contact.getName(),
                    contact.getRelationType(),
                    contact.getEmail(),
                    contact.getMobileNumber(),
                    contact.getTown());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }

    private static void searchContact(Scanner scanner, ContactManager contactManager) {
        System.out.println("\n--- Search for a Contact ---");
        System.out.println("Search by:");
        System.out.println("1. Name");
        System.out.println("2. Relation Type");
        System.out.println("3. Town");
        System.out.println("4. Mobile Number");
        System.out.println("5. Email");
        System.out.print("Enter your choice: ");

        int searchChoice;
        try {
            searchChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        String searchTerm;
        List<Contact> results;

        switch (searchChoice) {
            case 1:
                System.out.print("Enter name to search: ");
                searchTerm = scanner.nextLine();
                results = contactManager.searchByField(searchTerm, ContactField.NAME);
                break;
            case 2:
                System.out.print("Enter relation type to search: ");
                searchTerm = scanner.nextLine();
                results = contactManager.searchByField(searchTerm, ContactField.RELATION);
                break;
            case 3:
                System.out.print("Enter town to search: ");
                searchTerm = scanner.nextLine();
                results = contactManager.searchByField(searchTerm, ContactField.TOWN);
                break;
            case 4:
                System.out.print("Enter mobile number to search: ");
                searchTerm = scanner.nextLine();
                results = contactManager.searchByField(searchTerm, ContactField.MOBILE);
                break;
            case 5:
                System.out.print("Enter email to search: ");
                searchTerm = scanner.nextLine();
                results = contactManager.searchByField(searchTerm, ContactField.EMAIL);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("No contacts found matching your search criteria.");
            return;
        }

        System.out.println("Search results:");
        displayContacts(results);
    }

    private static void updateContact(Scanner scanner, ContactManager contactManager) {
        System.out.println("\n--- Update a Contact ---");
        List<Contact> contacts = contactManager.getAllContacts();

        if (contacts.isEmpty()) {
            System.out.println("No contacts available to update.");
            return;
        }

        displayContacts(contacts);

        System.out.print("Enter the number of the contact to update: ");
        int contactIndex;
        try {
            contactIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (contactIndex < 0 || contactIndex >= contacts.size()) {
                System.out.println("Invalid contact number.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        Contact contactToUpdate = contacts.get(contactIndex);

        System.out.println("Updating contact: " + contactToUpdate.getName());
        System.out.println("Leave field empty to keep current value.");

        // Update name
        System.out.print("Enter new name [" + contactToUpdate.getName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            if (InputValidator.isValidName(name)) {
                contactToUpdate.setName(name);
            } else {
                System.out.println("Invalid name format. Name not updated.");
            }
        }

        // Update relation type
        System.out.print("Enter new relation type [" + contactToUpdate.getRelationType() + "]: ");
        String relationType = scanner.nextLine();
        if (!relationType.isEmpty()) {
            if (InputValidator.isValidName(relationType)) {
                contactToUpdate.setRelationType(relationType);
            } else {
                System.out.println("Invalid relation type format. Relation type not updated.");
            }
        }

        // Update email
        System.out.print("Enter new email [" + contactToUpdate.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            if (InputValidator.isValidEmail(email)) {
                contactToUpdate.setEmail(email);
            } else {
                System.out.println("Invalid email format. Email not updated.");
            }
        }

        // Update mobile number
        System.out.print("Enter new mobile number [" + contactToUpdate.getMobileNumber() + "]: ");
        String mobileNumber = scanner.nextLine();
        if (!mobileNumber.isEmpty()) {
            if (InputValidator.isValidMobileNumber(mobileNumber)) {
                contactToUpdate.setMobileNumber(mobileNumber);
            } else {
                System.out.println("Invalid mobile number format. Mobile number not updated.");
            }
        }

        // Update town
        System.out.print("Enter new town [" + contactToUpdate.getTown() + "]: ");
        String town = scanner.nextLine();
        if (!town.isEmpty()) {
            contactToUpdate.setTown(town);
        }

        System.out.println("Contact updated successfully!");
    }

    private static void deleteContact(Scanner scanner, ContactManager contactManager) {
        System.out.println("\n--- Delete a Contact ---");
        List<Contact> contacts = contactManager.getAllContacts();

        if (contacts.isEmpty()) {
            System.out.println("No contacts available to delete.");
            return;
        }

        displayContacts(contacts);

        System.out.print("Enter the number of the contact to delete: ");
        int contactIndex;
        try {
            contactIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (contactIndex < 0 || contactIndex >= contacts.size()) {
                System.out.println("Invalid contact number.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        Contact contactToDelete = contacts.get(contactIndex);
        System.out.print("Are you sure you want to delete " + contactToDelete.getName() + "? (y/n): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("y")) {
            contactManager.deleteContact(contactToDelete);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}

enum ContactField {
    NAME, RELATION, EMAIL, MOBILE, TOWN
}

class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String relationType;
    private String email;
    private String mobileNumber;
    private String town;

    public Contact(String name, String relationType, String email, String mobileNumber, String town) {
        this.name = name;
        this.relationType = relationType;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.town = town;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Relation: " + relationType +
                ", Email: " + email +
                ", Mobile: " + mobileNumber +
                ", Town: " + town;
    }
}

class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = new ArrayList<>(contacts);
    }

    public List<Contact> searchByField(String searchTerm, ContactField field) {
        List<Contact> results = new ArrayList<>();
        String lowerCaseSearchTerm = searchTerm.toLowerCase();

        for (Contact contact : contacts) {
            String fieldValue = "";

            switch (field) {
                case NAME:
                    fieldValue = contact.getName();
                    break;
                case RELATION:
                    fieldValue = contact.getRelationType();
                    break;
                case EMAIL:
                    fieldValue = contact.getEmail();
                    break;
                case MOBILE:
                    fieldValue = contact.getMobileNumber();
                    break;
                case TOWN:
                    fieldValue = contact.getTown();
                    break;
            }

            if (fieldValue.toLowerCase().contains(lowerCaseSearchTerm)) {
                results.add(contact);
            }
        }

        return results;
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }
}

interface InputValidator {
    boolean isValid(String input);

    static boolean isValidName(String name) {
        return name != null && !name.isEmpty() && name.matches("^[a-zA-Z\\s]+$");
    }

    static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        // Email validation pattern: username@domain.tld
        // Allows alphanumeric characters, plus some special characters in username
        // Requires @ symbol and domain with at least one period
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    static boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber != null && !mobileNumber.isEmpty() && mobileNumber.matches("^[0-9]+$");
    }
}
