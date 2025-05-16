
public class PairOfDice {

    private int die1;  // Value of the first die.
    private int die2;  // Value of the second die.

    /**
     * Constructor.  Creates a pair of dice and rolls them, so that they initially
     * show some random values.
     */
    public PairOfDice() {
        roll();  // Roll the dice to give them initial values.
    }

    /**
     * Constructor.  Creates a pair of dice and rolls them so that they
     * initially show the values given as parameters.
     * @param val1 The initial value of the first die.  Should be in the range 1..6.
     * @param val2 The initial value of the second die.  Should be in the range 1..6.
     * @throws IllegalArgumentException if the values are not in the range 1..6.
     */
    public PairOfDice(int val1, int val2) {
        if (val1 < 1 || val1 > 6 || val2 < 1 || val2 > 6) {
            throw new IllegalArgumentException("Illegal die values: " + val1 + ", " + val2);
        }
        die1 = val1;
        die2 = val2;
    }

    /**
     * Roll the dice by setting each of the dice to be a random number
     * between 1 and 6.
     */
    public void roll() {
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }

    /**
     * Get the value of the first die.
     * @return the value of the first die.
     */
    public int getDie1() {
        return die1;
    }

    /**
     * Get the value of the second die.
     * @return the value of the second die.
     */
    public int getDie2() {
        return die2;
    }

    /**
     * Get the sum of the two dice.
     * @return the sum of the two dice.
     */
    public int getTotal() {
        return die1 + die2;
    }


    /**
     * A main() routine to test the PairOfDice class.
     */
    public static void main(String[] args) {
        PairOfDice dice = new PairOfDice();
        int rollCount = 0;

        while (dice.getTotal() != 2) {
            dice.roll();
            rollCount++;
            System.out.println("Roll " + rollCount + ": Die 1 = " + dice.getDie1() + ", Die 2 = " + dice.getDie2() + ", Total = " + dice.getTotal());
        }

        System.out.println("It took " + rollCount + " rolls to get a total of 2.");
    }

}

