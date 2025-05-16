import java.util.Scanner;

public class SecondLargest {
    
    // Function to find the second largest element in the array
    public static int f(int[] a) {
        // Check if array has less than 2 elements
        if (a == null || a.length < 2) {
            return -1;
        }
        
        int largest = -1;
        int secondLargest = -1;
        
        // Find the largest and second largest elements
        for (int num : a) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }
        
        // If no second largest was found (all elements are the same)
        if (secondLargest == -1) {
            return -1;
        }
        
        return secondLargest;
    }
    
    // Main method to test the function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] array = new int[size];
        
        System.out.println("Enter " + size + " non-negative integers:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        
        int result = f(array);
        
        if (result == -1) {
            System.out.println("There is no second largest element in the array.");
        } else {
            System.out.println("The second largest element is: " + result);
        }
        
        scanner.close();
    }
}