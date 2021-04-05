import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] profitPerClick, int[] averageNumOfClicksPerDay) {
        // sort Arrays
        Arrays.sort(profitPerClick);
        Arrays.sort(averageNumOfClicksPerDay);

        long result = 0;
        for (int i = 0; i < profitPerClick.length; i++) {
            result += (long) profitPerClick[i] * averageNumOfClicksPerDay[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

