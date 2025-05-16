public class Question11 {
    static class Employee {
        String lastName;
        String firstName;
        double hourlyWage;
        int yearsWithCompany;
    }

    public static void main(String[] args) {
        // Initialize employeeData array with 100 elements (sample data added for demonstration)
        Employee[] employeeData = new Employee[100];

        // Sample employee 1 (qualifies)
        Employee emp1 = new Employee();
        emp1.firstName = "John";
        emp1.lastName = "Doe";
        emp1.hourlyWage = 25.75;
        emp1.yearsWithCompany = 22;
        employeeData[0] = emp1;

        // Sample employee 2 (does not qualify)
        Employee emp2 = new Employee();
        emp2.firstName = "Jane";
        emp2.lastName = "Smith";
        emp2.hourlyWage = 30.50;
        emp2.yearsWithCompany = 15;
        employeeData[1] = emp2;

        // Sample employee 3 (qualifies)
        Employee emp3 = new Employee();
        emp3.firstName = "Alice";
        emp3.lastName = "Johnson";
        emp3.hourlyWage = 28.90;
        emp3.yearsWithCompany = 30;
        employeeData[2] = emp3;

        // Loop through all employees and print qualifying ones
        for (Employee emp : employeeData) {
            if (emp != null && emp.yearsWithCompany >= 20) {
                System.out.printf("Name: %s %s, Hourly Wage: $%.2f%n",
                        emp.firstName, emp.lastName, emp.hourlyWage);
            }
        }
    }
}
