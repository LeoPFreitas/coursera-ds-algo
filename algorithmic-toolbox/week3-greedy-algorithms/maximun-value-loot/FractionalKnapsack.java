import java.util.ArrayList;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0D;
        int length = values.length;

        ArrayList<Item> array = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            Double delta = (double) values[i] / (double) weights[i];
            array.add(new Item(values[i], weights[i], delta));
        }

        array.sort((o1, o2) -> Double.compare(o1.getDelta(), o2.getDelta()));

        int aux = length - 1;
        while (capacity > 0 && aux >= 0) {
            Item item = array.get(aux);
            int weight = item.getWeight();
            if (capacity >= weight) {
                value += item.getValue();
                capacity -= weight;
                aux--;
            } else {
                value += (item.getDelta() * capacity);
                capacity -= capacity;
            }
        }

        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }

    static class Item {
        int value;
        int weight;
        Double delta;

        public Item(int value, int weight, Double delta) {
            this.value = value;
            this.weight = weight;
            this.delta = delta;
        }

        public int getValue() {
            return this.value;
        }

        public int getWeight() {
            return this.weight;
        }


        public Double getDelta() {
            return this.delta;
        }
    }
}