public class Counter {
    // Private instance variable to store the counter value
    private int value;

    // Constructor to initialize the counter at 0
    public Counter() {
        value = 0;
    }

    // Method to increment the counter value by 1
    public void increment() {
        value++;
    }

    // Method to return the current counter value
    public int getValue() {
        return value;
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        Counter counter = new Counter();  // Create an instance of Counter

        System.out.println("Initial Value: " + counter.getValue()); // Should print 0

        counter.increment(); // Increment counter
        counter.increment(); // Increment counter again

        System.out.println("Current Value after two increments: " + counter.getValue()); // Should print 2
    }
}
