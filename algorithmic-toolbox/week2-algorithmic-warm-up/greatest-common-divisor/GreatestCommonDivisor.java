import java.util.Scanner;

public class GreatestCommonDivisor {
    private static int calcGreatestCommonDivisorNaive(int a, int b) {
        int currentGcd = 1;

        for (int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > currentGcd) {
                    currentGcd = d;
                }
            }
        }

        return currentGcd;
    }

    private static int calcGreatestCommonDivisorFast(int a, int b) {
        if (a == 0) {
            return b;
        }

        return calcGreatestCommonDivisorFast(b % a, a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(calcGreatestCommonDivisorFast(a, b));
    }
}
