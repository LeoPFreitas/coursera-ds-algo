import java.util.Scanner;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmpPrevious = previous;
            previous = current;
            current = tmpPrevious + current;
            sum += current;

            System.out.print("" + sum + " ");
        }

        return sum % 10;
    }

    static int getFibonacciSumFast(long n) {

        // The first two Fibonacci numbers
        int f0 = 0;
        int f1 = 1;

        // Base case
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // Pisano period for % 10 is 60
            int rem = (int) (n % 60);

            // Checking the remainder
            if (rem == 0) {
                return 0;
            }

            // The loop will range from 2 to two terms after the remainder
            for (int i = 2; i < rem + 3; i++) {
                int f = (f0 + f1) % 60;
                f0 = f1;
                f1 = f;
            }

            return (f1 - 1) % 10;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}

