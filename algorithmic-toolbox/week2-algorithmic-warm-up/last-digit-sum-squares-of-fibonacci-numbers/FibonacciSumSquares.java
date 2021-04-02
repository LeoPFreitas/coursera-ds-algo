import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static int getFibonacciLastDigit(long n) {
        if (n <= 1)
            return (int) n;

        int prev = 0;
        int curr = 1;
        for (long i = 2; i <= n; i++) {
            int next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }
        return curr % 10;
    }

    private static int getFibonacciSumSquaresFast(long n) {
        int verticalSide = getFibonacciLastDigit(n % 60);
        int horizontalSide = getFibonacciLastDigit((n + 1) % 60);
        int sumSquares = verticalSide * horizontalSide;
        return sumSquares % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresFast(n);
        System.out.println(s);
    }
}

