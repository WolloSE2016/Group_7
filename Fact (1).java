import java.util.Scanner;

public class Fact {

    public static int sameNumberOfFactors(int n1, int n2) {
        // If either argument is negative, return -1
        if (n1 < 0 || n2 < 0) {
            return -1;
        }

        // Count the number of factors for n1 and n2
        int factorsN1 = countFactors(n1);
        int factorsN2 = countFactors(n2);

        // If the number of factors is the same, return 1
        if (factorsN1 == factorsN2) {
            return 1;
        } else {
            return 0;
        }
    }

    // Helper function to count the number of factors for a given number
    public static int countFactors(int n) {
        int count = 0;
        if (n == 0) {
            return 0; // 0 has no factors in this context
        }
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer (n1): ");
        int n1 = scanner.nextInt();

        System.out.print("Enter the second integer (n2): ");
        int n2 = scanner.nextInt();

        int result = sameNumberOfFactors(n1, n2);
        System.out.println("Result: " + result);

        scanner.close();
    }
}


