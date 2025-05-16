public class Player {
    // Private instance variables
    private String name;
    private int score;

    // Constructor (Optional, to initialize values)
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for score
    public int getScore() {
        return score;
    }

    // Setter for score
    public void setScore(int score) {
        this.score = score;
    }

    // Method to display player details
    public void displayInfo() {
        System.out.println("Player Name: " + name + ", Score: " + score);
    }

    public static void main(String[] args) {
        // Create a Player object
        Player p1 = new Player("Alice", 50);

        // Display initial values
        p1.displayInfo();

        // Modify values using setter methods
        p1.setName("Bob");
        p1.setScore(75);

        // Display updated values
        p1.displayInfo();
    }
}

