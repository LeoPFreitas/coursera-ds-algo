# Maximum Value of the Loot

## Problem Introduction

**Task.** The goal of this code problem is to implement an algorithm for the fractional knapsack problem.

**Input Format.** The first line of the input contains the number _n_ of items and the capacity _W_ of a knapsack.
The next _n_ lines define the values and weights of the items. The i-th line contains integers _v<sub>i</sub>_ and 
_w<sub>i</sub>_—the value and the weight of i-th item, respectively.

**Constraints.** 1 ≤ _n_ ≤ 10<sup>3</sup> , 0 ≤ _W_ ≤ 2 · 10<sup>6</sup>; 0 ≤ _v<sub>i</sub>_ ≤ 2 · 10<sup>6</sup> , 
0 < 
_w<sub>i</sub>_ ≤ 2 · 10<sup>6</sup> for all 1 ≤ _i_ ≤ _n_. All the numbers are integers.

**Output Format.** Output the maximal value of fractions of items that fit into the knapsack. The absolute
value of the difference between the answer of your program and the optimal value should be at most
10<sup>-3</sup> . To ensure this, output your answer with at least four digits after the decimal point 
(otherwise your answer, while being computed correctly, can turn out to be wrong because of rounding issues).

**Sample 1.**
```text
Input:
    3 50
    60 20
    100 50
    120 30
Output:
    180.0000
```

**Sample 2.**
```text
Input:
    1 10
    500 30
Output:
    166.6667
```
## Solution

**Approach 1: Fractional Knapsack Algorithm**


```java
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
```

## Test

Compile with `javac FibonacciPartialSum.java` and run with `java FibonacciPartialSum`.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        /* see previous code */
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
        /* see previous code */
    }
}
```