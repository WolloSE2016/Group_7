import java.util.Scanner;

public class PairedNArray {

    public static int isPairedN(int[] a, int n) {
        // Check if array length is at least 2 (need at least 2 elements to form a pair)
        if (a.length < 2) {
            return 0;
        }

        // Check if n is a valid index sum (must be between 1 and 2*(array length-1))
        if (n < 1 || n > 2 * (a.length - 1)) {
            return 0;
        }

        // Check for pairs that satisfy the condition
        for (int i = 0; i < a.length; i++) {
            // Only check indices j where i+j=n and j is valid
            int j = n - i;

            // Skip if j is out of bounds or j equals i (need distinct elements)
            if (j < 0 || j >= a.length || j == i) {
                continue;
            }

            // Check if the elements sum to n
            if (a[i] + a[j] == n) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();

        if (length <= 0) {
            System.out.println("Array length must be positive");
            return;
        }

        int[] a = new int[length];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < length; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();

        int result = isPairedN(a, n);
        System.out.println("Result: " + result);
        if( result==0){
            System.out.println("because there is no way to get the corresponding indexes to sum to the given number n: " );
        }

        scanner.close();
    }
}
