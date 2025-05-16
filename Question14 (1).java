import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question14 {

    public static String isPrimeHappy(int n) {
        if (n <= 1) {
            return "0 Because there are no primes less than " + n + ".";
        }

        List<Integer> primes = new ArrayList<>();
        long sumOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primes.add(i);
                sumOfPrimes += i;
            }
        }

        if (primes.isEmpty()) {
            return "0 Because there are no primes less than " + n + ".";
        }

        if (sumOfPrimes % n == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("1 Because ");
            for (int i = 0; i < primes.size(); i++) {
                sb.append(primes.get(i));
                if (i < primes.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" are the primes less than " + n + ", their sum is " + sumOfPrimes + " and " + n + " evenly divides " + sumOfPrimes + ".");
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("0 Because ");
            for (int i = 0; i < primes.size(); i++) {
                sb.append(primes.get(i));
                if (i < primes.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" are the primes less than " + n + ", their sum is " + sumOfPrimes + " and " + n + " does not evenly divide " + sumOfPrimes + ".");
            return sb.toString();
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        String result = isPrimeHappy(n);
        System.out.println(result);
        scanner.close();
    }
}