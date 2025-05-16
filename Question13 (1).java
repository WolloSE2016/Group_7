public class Question13{

    public static int closestFibonacci(int n) {
        if (n < 1) {
            return 0;
        }

        int a = 1;
        int b = 1;
        int nextFib = 1;

        while (nextFib <= n) {
            a = b;
            b = nextFib;
            nextFib = a + b;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(closestFibonacci(12));  // Output: 8
        System.out.println(closestFibonacci(33));  // Output: 21
        System.out.println(closestFibonacci(34));  // Output: 34
        System.out.println(closestFibonacci(0));   // Output: 0
        System.out.println(closestFibonacci(1));   // Output: 1
        System.out.println(closestFibonacci(2));   // Output: 1
    }
}

