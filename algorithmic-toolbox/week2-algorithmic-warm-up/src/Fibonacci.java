import java.util.Scanner;

public class Fibonacci {
    private static long NaiveCalcFib(int n) {
        if (n <= 1)
            return n;

        return NaiveCalcFib(n - 1) + NaiveCalcFib(n - 2);
    }

    private static long CalcFib(int n) {
        long first = 0;
        long second = 1;

        if (n <= 1) {
            return second;
        }

        for (int i = 2; i <= n; i++) {
            long aux = second;
            second = second + first;
            first = aux;
        }

        return second;
    }

    private static long formulaCalcFib(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return Math.round(Math.pow(phi, n) / Math.sqrt(5));

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(NaiveCalcFib(n));
        System.out.println(CalcFib(n));
        System.out.println(formulaCalcFib(n));
    }
}
