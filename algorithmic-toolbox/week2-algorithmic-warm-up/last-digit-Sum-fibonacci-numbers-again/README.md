# 7. Last Digit of the Sum of Fibonacci Numbers Again

## Problem Description

**Task.** Given two non-negative integers _m_ and _n_, where _m_ ≤ _n_, fnd the last digit of the sum _F_<sub>m</sub> + _F_<sub>m+1</sub> + · · · + _F_<sub>n</sub>.

**Input Format.** The input consists of two non-negative integers _m_ and _n_ separated by a space.

**Constraints.** 1 ≤ _m_ ≤ _n_ ≤ 10<sup>18</sup>.

**Output Format.** Output the last digit of _F_<sub>m</sub> + _F_<sub>m+1</sub> + · · · + _F_<sub>n</sub>.

**Sample 1.**

```text
Input
    3 7
Output
    1
```

**Sample 2.**

```text
Input
    10 10
Output
    5
```

**Sample 3.**

```text
Input
    10 200
Output
    2
```


## Solution

**Approach 1: Naive**


```java
private static long getFibonacciPartialSumNaive(long from, long to) {
    long sum = 0;

    long current = 0;
    long next  = 1;

    for (long i = 0; i <= to; ++i) {
        if (i >= from) {
            sum += current;
        }

        long newCurrent = next;
        next = next + current;
        current = newCurrent;
    }

    return sum % 10;
}
```
**Approach 2: Fast**


```java
private static long getFibonacciPartialSumFast(long from, long to) {
    long sum = 0;

    int m = (int) (from % 60);
    int n = (int) (to % 60);

    if (n < m)
    n += 60;

    long current = 0;
    long next = 1;

    for (int i = 0; i <= n; ++i) {
        if (i >= m) {
            sum += current;
        }

        long newCurrent = next;
        next = next + current;
        current = newCurrent;
    }

    return (int) (sum % 10);
}
```
## Test

Compile with `javac FibonacciPartialSum.java` and run with `java FibonacciPartialSum`.

```java
import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumFast(long from, long to) {
        /* see previous code */
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}
```