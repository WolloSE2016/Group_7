public class Qestion4 {
    public static int findLargest(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int largest = numbers[0]; // Assume first element is largest initially

        for (int num : numbers) {
            if (num > largest) {
                largest = num; // Update largest if a bigger number is found
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] sampleArray = {12, 45, 7, 89, 23, 90, 67};
        System.out.println("Largest value: " + findLargest(sampleArray));
    }
}

