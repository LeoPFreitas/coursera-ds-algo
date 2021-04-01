import java.util.Scanner;

public class Fibonacci {
    private static long NaiveCalcFib(int n) {
        if (n <= 1)
            return n;

        return NaiveCalcFib(n - 1) + NaiveCalcFib(n - 2);
    }

    private static long calcFib(int n) {
        long previous = 0;
        long current = 1;

        if (n <= 1) {
            return current;
        }

        for (int i = 2; i <= n; i++) {
            long aux = current;
            current = current + previous;
            previous = aux;
        }

        return current;
    }

    private static long formulaCalcFib(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return Math.round(Math.pow(phi, n) / Math.sqrt(5));

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(NaiveCalcFib(n));
        System.out.println(calcFib(n));
        System.out.println(formulaCalcFib(n));
    }
}
