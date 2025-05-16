import java.util.Scanner;

public class EmployeeReport {
    static class Employee {
        String lastName;
        String firstName;
        double hourlyWage;
        int yearsWithCompany;
    }

    public static void main(String[] args) {
        Employee[] employeeData = new Employee[100];
        Scanner scanner = new Scanner(System.in);

        // Accept user input for all 100 employees
        for (int i = 0; i < employeeData.length; i++) {
            System.out.println("\nEnter details for Employee #" + (i + 1) + ":");
            Employee emp = new Employee();

            System.out.print("First Name: ");
            emp.firstName = scanner.nextLine().trim();

            System.out.print("Last Name: ");
            emp.lastName = scanner.nextLine().trim();

            System.out.print("Hourly Wage: ");
            emp.hourlyWage = scanner.nextDouble();

            System.out.print("Years with Company: ");
            emp.yearsWithCompany = scanner.nextInt();

            scanner.nextLine(); // Clear the input buffer
            employeeData[i] = emp;
        }
        scanner.close();

        // Print employees with 20+ years
        System.out.println("\nEmployees with 20+ years of service:");
        System.out.println("-------------------------------------");
        for (Employee emp : employeeData) {
            if (emp.yearsWithCompany >= 20) {
                System.out.printf("Name: %s %s | Wage: $%.2f%n",
                        emp.firstName, emp.lastName, emp.hourlyWage);
            }
        }
    }
}