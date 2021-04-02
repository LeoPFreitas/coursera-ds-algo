# 8. Last Digit of the Sum of Squares of Fibonacci Numbers

## Problem Description

**Task.** Compute the last digit of _F_<sub>0</sub><sup>2</sup> + _F_<sub>1</sub><sup>2</sup> + · · · + _F_<sub>n</sub><sup>2</sup>.

**Input Format.** Integer _n_

**Constraints.** 1 ≤ _n_ ≤ 10<sup>18</sup>.

**Output Format.** The last digit of _F_<sub>0</sub><sup>2</sup> + _F_<sub>1</sub><sup>2</sup> + · · · + _F_<sub>n</sub><sup>2</sup>.

**Sample 1.**

```text
Input
    7
Output
    3
```

**Sample 2.**

```text
Input
    73
Output
    1
```

**Sample 3.**

```text
Input
    1234567890
Output
    0
```


## Solution

**Approach 1: Naive**


```java
private static long getFibonacciSumSquaresNaive(long n) {
    if (n <= 1)
        return n;

    long previous = 0;
    long current  = 1;
    long sum      = 1;

    for (long i = 0; i < n - 1; ++i) {
        long tmpPrevious = previous;
        previous = current;
        current = tmpPrevious + current;
        sum += current * current;
    }

    return sum % 10;
}
```
**Approach 2: Fast**


```java
private static int getFibonacciLastDigit(long n) {
    if (n <= 1)
        return (int) n;

    int prev = 0;
    int curr = 1;
    for (long i = 2; i <= n; i++) {
        int next = (prev + curr) % 10;
        prev = curr;
        curr = next;
    }
    return curr % 10;
}

private static int getFibonacciSumSquaresFast(long n) {
    int verticalSide = getFibonacciLastDigit(n % 60);
    int horizontalSide = getFibonacciLastDigit((n + 1) % 60);
    int sumSquares = verticalSide * horizontalSide;
    return sumSquares % 10;
}
```
## Test

Compile with `javac FibonacciSumSquares.java` and run with `java FibonacciSumSquares`.

```java
import java.util.*;

public class FibonacciSumSquares {
    private static int getFibonacciLastDigit(long n) {
        /* see previous code */
    }

    private static int getFibonacciSumSquaresFast(long n) {
        /* see previous code */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresFast(n);
        System.out.println(s);
    }
}
```