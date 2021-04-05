import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int currentRefill = 0, numRefill = 0;
        int[] points = new int[stops.length + 2];
        System.arraycopy(stops, 0, points, 1, stops.length);
        points[stops.length + 1] = dist;

        if (tank > dist) {
            return 0;
        }
        while (currentRefill < points.length) {
            int lastRefill = currentRefill;

            while (currentRefill < points.length - 1 && points[currentRefill + 1] - points[lastRefill] <= tank) {
                currentRefill += 1;
            }
            if (currentRefill == lastRefill) {
                return -1;
            }

            if (currentRefill == points.length - 1) {
                break;
            }

            if (currentRefill < points.length) {
                numRefill++;
            }
        }
        return numRefill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
