import java.util.HashMap;
import java.util.Scanner;

public class Question16 {

    /**
     * Checks if an array is stepped.
     * An array is stepped if:
     * 1. It is in ascending order (a[n] <= a[n+1])
     * 2. There are 3 or more occurrences of each distinct value
     */
    public static int isStepped(int[] a) {
        // Check if array is empty or too small
        if (a == null || a.length < 3) {
            return 0; // Cannot have 3 occurrences of any value
        }

        // Check if array is in ascending order
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return 0; // Not in ascending order
            }
        }

        // Count occurrences of each distinct value
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int value : a) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }

        // Check if each distinct value appears at least 3 times
        for (int count : countMap.values()) {
            if (count < 3) {
                return 0; // A value appears less than 3 times
            }
        }

        // If we reach here, the array is stepped
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get array size from user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create and populate the array
        int[] array = new int[size];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Check if the array is stepped
        int result = isStepped(array);

        // Display the result
        System.out.println("The array is " + (result == 1 ? "stepped" : "not stepped"));

        System.out.println("Result: " + result);

        scanner.close();
    }
}