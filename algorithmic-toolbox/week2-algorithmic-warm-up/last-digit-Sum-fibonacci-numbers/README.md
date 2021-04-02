# 6. Last Digit of the Sum of Fibonacci Numbers

## Problem Description

**Task.** Given an integer _n_, fnd the last digit of the sum _F_<sub>0</sub> + _F_<sub>1</sub> + · · · + _F_<sub>n</sub>.

**Input Format.** The input consists of a single integer _n_.

**Constraints.** 1 ≤ _n_ ≤ 10<sup>18</sup>.

**Output Format.** Output the last digit of _F_<sub>0</sub> + _F_<sub>1</sub> + · · · + _F_<sub>n</sub>.

**Sample 1.**

```text
Input
    3
Output
    4
```

**Sample 2.**

```text
Input
    100
Output
    5
```
## What To Do


Instead of computing this sum in a loop, try to come up with a formula for _F_<sub>0</sub> + _F_<sub>1</sub> + · · · + _F_<sub>n</sub>. For this, play with small values of n. Then, use a solution for the previous problem.

## Solution

**Approach 1: Naive**


```java
private static long getFibonacciSumNaive(long n) {
    if (n <= 1) {
        return n;
    }

    long previous = 0;
    long current = 1;
    long sum = 1;

    for (long i = 0; i < n - 1; ++i) {
        long tmpPrevious = previous;
        previous = current;
        current = tmpPrevious + current;
        sum += current;
    }

    return sum % 10;
}
```
**Approach 2: Fast**


```java
static int getFibonacciSumFast(long n) {

    // The first two Fibonacci numbers
    int f0 = 0;
    int f1 = 1;

    // Base case
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        // Pisano period for % 10 is 60
        int rem = (int) (n % 60);

        // Checking the remainder
        if (rem == 0) {
            return 0;
        }

        // The loop will range from 2 to two terms after the remainder
        for (int i = 2; i < rem + 3; i++) {
            int f = (f0 + f1) % 60;
            f0 = f1;
            f1 = f;
        }

        return (f1 - 1) % 10;
    }
}

```
## Test

Compile with `javac FibonacciSumLastDigit.java` and run with `java FibonacciSumLastDigit`.

```java
import java.util.*;

public class FibonacciSumLastDigit {
    private static int getFibonacciSumFast(long n) {
        /* see previous code */
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}
```