import java.util.Random;

public class CoinTossSimulation {
    public static void main(String[] args) {
        Counter headCount = new Counter(); // Counter for heads
        Counter tailCount = new Counter(); // Counter for tails
        Random random = new Random(); // Random number generator

        // Simulate 100 coin tosses
        for (int i = 0; i < 100; i++) {
            if (random.nextBoolean()) { // 50% chance for heads or tails
                headCount.increment(); // Increment heads counter
            } else {
                tailCount.increment(); // Increment tails counter
            }
        }

        // Display results
        System.out.println("Heads count: " + headCount.getValue());
        System.out.println("Tails count: " + tailCount.getValue());
    }
}

// Counter class for counting heads and tails
class Counter {
    private int value; // Private instance variable

    // Constructor initializes counter to zero
    public Counter() {
        value = 0;
    }

    // Method to increment counter by 1
    public void increment() {
        value++;
    }

    // Method to get current counter value
    public int getValue() {
        return value;
    }
}
