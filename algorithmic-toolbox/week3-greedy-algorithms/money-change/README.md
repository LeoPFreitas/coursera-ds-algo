# Money Change

## Problem Description

**Task.** The goal in this problem is to find the minimum number of coins needed to change the input value
(an integer) into coins with denominations 1, 5, and 10.

**Input Format.** The input consists of a single integer _m_.

**Constraints.** 1 ≤ _m_ ≤ 10<sup>3</sup>.
**Output Format.** Output the minimum number of coins with denominations 1, 5, 10 that changes _m_.

**Sample 1.**

```text
Input:
    2
Output:
    2 = 1 + 1
```

**Sample 2.**

```text
Input:
    28
Output:
    6 = 10 + 10 + 5 + 1 + 1 + 1
```

## Solution

**Approach: Greedy Algorithm**


```java
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
```
## Test

Compile with `javac FibonacciPartialSum.java` and run with `java FibonacciPartialSum`.

```java
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        /* see previous code */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
```
