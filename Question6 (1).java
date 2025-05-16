/*A constructor in Java is a special method used to initialize objects. It is called automatically when an object of a class is created. A constructor's primary purpose is to set up an object with default or user-defined values.

Key Characteristics of a Constructor:
Same Name as Class – The constructor must have the same name as the class.

No Return Type – Unlike regular methods, constructors do not have a return type (not even void).

Called Automatically – When an object is created, the constructor executes automatically.

Purpose of a Constructor in a Class:
Initialize Object Properties: It sets initial values for instance variables.

Code Simplification: Reduces redundant initialization logic in multiple places.

Ensures Object Consistency: Helps prevent uninitialized objects.

Example:*/
class Person {
    String name;
    int age;

    // Constructor
    public Person(String personName, int personAge) {
        name = personName;
        age = personAge;
    }

    // Method to display details
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        // Creating objects using the constructor
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 30);

        p1.displayInfo();
        p2.displayInfo();
    }
}

