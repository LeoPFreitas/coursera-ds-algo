# 5. Fibonacci Number Again

## Problem Description

**Task.** Given two integers _n_ and _m_, output _F_<sub>_n_</sub> mod _m_ (that is, the remainder of _F_<sub>_n_</sub> when divided by _m_).

**Input Format.** The input consists of two integers _n_ and _m_ given on the same line (separated by a space).

**Constraints.** 1 ≤ _n_ ≤ 10<sup>18</sup>, 2 ≤ _m_ ≤ 10<sup>3</sup>.

**Output Format.** Output _F_<sub>_n_</sub> mod _m_

**Sample 1.**

```text
Input
    239 1000
Output
    161
```

**Sample 2.**

```text
Input
    2816213588 239
Output
    151
```

## Solution

**Approach 1: Naive**


```java
private static long getFibonacciHugeNaive(long n, long m) {
    if (n <= 1) {
        return n;         
    }

    long previous = 0;
    long current = 1;

    for (long i = 0; i < n - 1; ++i) {
        long tempPrevious = previous;
        previous = current;
        current = tempPrevious + current;
    }

    return current % m;
}
```
**Approach 2: Fast**


```java
public static long pisano(long m) {
    long prev = 0;
    long curr = 1;
    long res = 0;

    for (int i = 0; i < m * m; i++) {
        long temp = 0;
        temp = curr;
        curr = (prev + curr) % m;
        prev = temp;

        if (prev == 0 && curr == 1) {
            res = i + 1;         
        }
    }
    
    return res;
}

public static long fibonacciHugeFast(long n, long m) {

    long pisanoPeriod = pisano(m);

    n = n % pisanoPeriod;

    long prev = 0;
    long curr = 1;

    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    }

    for (int i = 0; i < n - 1; i++) {
        long temp;
        temp = curr;
        curr = (prev + curr) % m;
        prev = temp;
    }
    return curr % m;
}
```
## Test

Compile with `javac FibonacciHuge.java` and run with `java FibonacciHuge`.

```java
import java.util.*;

public class FibonacciHuge {
    private static int pisano(long m) {
        /* see previous code */
    }

    private static int fibonacciHugeFast(long n, int m) {
        /* see previous code */
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(fibonacciHugeFast(n, m));
    }
}
```