import java.util.Scanner;

public class Change {
    private static int getChange(int m) {

        int[] availableChangeCoins = new int[]{10, 5, 1};
        int countCoins = 0;

        for (int coin : availableChangeCoins) {
            if (m % coin == 0) {
                countCoins += m / coin;
                return countCoins;
            } else {
                countCoins += Math.floorDiv(m, coin);
                m = m % coin;
            }
        }
        return countCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

