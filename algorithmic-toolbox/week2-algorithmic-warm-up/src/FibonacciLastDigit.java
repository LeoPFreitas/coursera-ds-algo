import java.util.Scanner;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    private static void calcFibRemainderSeries(int[] series) {
        series[0] = 0;
        series[1] = 1;

        for (int i = 2; i <= 59; i++)
            series[i] = (series[i - 1] + series[i - 2]) % 10;
    }


    private static long fibonacciLastDigitFast(int n) {
        int[] series = new int[60];
        calcFibRemainderSeries(series);

        int index = (int) (n % 60L);

        return series[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int c = getFibonacciLastDigitNaive(n);

//        System.out.println(c);
        System.out.println(fibonacciLastDigitFast(n));
    }
}

