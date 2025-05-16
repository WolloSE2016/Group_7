/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
 C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
import java.util.Scanner;

public class Question15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get array size from user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create array and get elements from user
        int[] array = new int[size];
        System.out.println("Enter " + size + " integers:");

        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Calculate and display the result
        int result = f(array);

        // Display the array
        System.out.print("Array: {");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");

        // Display the result
        System.out.println("Result (sum of odd numbers - sum of even numbers): " + result);

        scanner.close();
    }

    /**
     * Function that calculates the difference between the sum of odd numbers
     * and the sum of even numbers in the array.
     *
     * @param a the input array of integers
     * @return the difference between the sum of odd numbers and the sum of even numbers
     */
    public static int f(int[] a) {
        int sumOdd = 0;  // X: sum of odd numbers
        int sumEven = 0; // Y: sum of even numbers

        // Calculate sums
        for (int num : a) {
            if (num % 2 == 0) {
                // Even number
                sumEven += num;
            } else {
                // Odd number
                sumOdd += num;
            }
        }

        // Return X - Y
        return sumOdd - sumEven;
    }
}
