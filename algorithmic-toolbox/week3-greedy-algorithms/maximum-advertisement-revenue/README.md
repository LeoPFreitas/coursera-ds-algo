# Maximum Advertisement Revenue

## Problem Introduction

**Task.** Given two sequences a<sub>1</sub> , a<sub>2</sub>, _. . ._ , a<sub>n</sub> (a<sub>i</sub> is the profit per
click of the i-thad) and b<sub>1</sub>, b<sub>2</sub>, _. . ._, b<sub>n</sub> (b<sub>i</sub> is the average number of
clicks per day of the i-th slot), we need to partition them into _n_ pairs (a<sub>i</sub> , b<sub>j</sub> ) such that
the sum of their products is maximized.

**Input Format.** The first line contains an integer _n_, the second one contains a sequence of integers a<sub>1</sub>,
a<sub>2</sub>, _. . ._ , a<sub>n</sub> , the third one contains a sequence of integers b<sub>1</sub> , b<sub>2</sub>, _.
. ._ , b<sub>n</sub>.

**Constraints.** 1 ≤ _n_ ≤ 10<sup>3</sup> ; −10<sup>5</sup> ≤ a<sub>i</sub> , b<sub>i</sub> ≤ 10<sup>5</sup> for all 1
≤ _i_ ≤ _n_.

**Output Format.** Output the maximum value of _sum_(_a_<sub>i</sub>_c_<sub>i</sub>), where _c_<sub>1</sub>, 
_c_<sub>2</sub>, _. . ._ , _c_<sub>n</sub> is a permutation of _b_<sub>1</sub>, _b_<sub>2</sub>, _. . ._ , 
_b_<sub>n</sub>.

```text
Input
    1
    23
    39
Output
    897
Explanation
    897 = 23 · 39
```

**Sample 2.**

```text
Input
    3
    1 3 -5
    -2 4 1
Output
    23
Explanation
    23 = 3 · 4 + 1 · 1 + (−5) · (−2)
```

## Solution

```java
import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] profitPerClick, int[] averageNumOfClicksPerDay) {
        Arrays.sort(profitPerClick);
        Arrays.sort(averageNumOfClicksPerDay);

        long result = 0;
        for (int i = 0; i < profitPerClick.length; i++) {
            result += (long) profitPerClick[i] * averageNumOfClicksPerDay[i];
        }
        return result;
    }
}



```

## Test

Compile with `javac FibonacciPartialSum.java` and run with `java FibonacciPartialSum`.

```java
import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] profitPerClick, int[] averageNumOfClicksPerDay) {
        /* see previous code */
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
```