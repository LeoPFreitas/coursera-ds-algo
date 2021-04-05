# Car Fueling

## Problem Introduction

**Task.** You are going to travel to another city that is located d miles away from your home city. Your car can travel
at most m miles on a full tank, and you start with a full tank. Along your way, there are gas stations at distances stop
1 , stop 2 , _. . ._ , stop n from your home city. What is the minimum number of refills needed?

**Input Format.** The first line contains an integer _d_. The second line contains an integer _m_. The third line
specifies an integer _n_. Finally, the last line contains integers stop 1 , stop 2 , _. . ._ , stop _n_.

**Output Format.** Assuming that the distance between the cities is _d_ miles, a car can travel at most _m_ miles on a
full tank, and there are gas stations at distances stop 1 , stop 2 , _. . ._ , stop _n_ along the way, output the
minimum number of refills needed. Assume that the car starts with a full tank. If it is not possible to reach the
destination, output −1.

**Constraints.** 1 ≤ _d_ ≤ 10<sup>5</sup> * 1 ≤ _m_ ≤ 400 * 1 ≤ _n_ ≤ 300 * 0 < stop 1 < stop 2 < · · · < stop n < d.

**Sample 1.**

```text
Input:
    950
    400
    4
    200 375 550 750
Output:
    2
```

**Sample 2.**

```text
Input:
    10
    3
    4
    1259
Output:
    -1
```

## Solution

**Approach 1**

```java
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

```

## Test

Compile with `javac FibonacciPartialSum.java` and run with `java FibonacciPartialSum`.

```java
import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        /* see previous code */
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

```