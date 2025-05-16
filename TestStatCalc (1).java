import java.util.Scanner;

class StatCalc {
    private int count;
    private double sum;
    private double squareSum;
    private double max;
    private double min;

    public void enter(double item) {
        count++;
        sum += item;
        squareSum += item * item;

        if (count == 1) {
            max = item;
            min = item;
        } else {
            max = Math.max(max, item);
            min = Math.min(min, item);
        }
    }

    public int getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getMean() {
        return sum / count;
    }

    public double getStandardDeviation() {
        double mean = getMean();
        return Math.sqrt(squareSum / count - mean * mean);
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }
}

public class TestStatCalc {
    public static void main(String[] args) {
        StatCalc calc = new StatCalc();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter non-zero numbers (0 to stop):");
        while (true) {
            double num = scanner.nextDouble();
            if (num == 0) break;
            calc.enter(num);
        }

        if (calc.getCount() == 0) {
            System.out.println("No numbers entered.");
        } else {
            System.out.println("Count: " + calc.getCount());
            System.out.println("Sum: " + calc.getSum());
            System.out.println("Mean: " + calc.getMean());
            System.out.println("Standard Deviation: " + calc.getStandardDeviation());
            System.out.println("Minimum: " + calc.getMin());
            System.out.println("Maximum: " + calc.getMax());
        }
        scanner.close();
    }
}
















