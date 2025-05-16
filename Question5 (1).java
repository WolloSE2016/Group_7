public class Question5{
    public static void main(String[] args) {
        // Example initialization (replace with your actual array initialization)
        double[] A = new double[20];
        for (int i = 0; i < 20; i++) {
            A[i] = Math.random() * 10 - 5;  // Example: random numbers between -5 and 5
        }

        double sum = 0;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                sum += A[i];
                count++;
            }
        }

        double average;
        if (count > 0) {
            average = sum / count;
            System.out.println("Average of non-zero numbers: " + average);
        } else {
            System.out.println("No non-zero numbers found in the array.");
        }
    }
}
