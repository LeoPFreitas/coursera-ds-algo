# 1. Fibonacci Number

## Problem Description

**Task.** Given an integer _n_, find the _n_-th Fibonacci number _F_<sub>n</sub>.

**Input Format.** The input consists of a single integer _n_.

**Constraints.** 0 ≤ _n_ ≤ 45

**Output Format.** Output _F_<sub>n</sub>

**Sample 1.**

```text
Input
    10
Output
    55
```

## Solution

**Approach 1: Recursive (Naive)**
```java
private static long calcFib(int n) {
    if (n <= 1)
        return n;

    return calcFib(n - 1) + calcFib(n - 2);
}
```

**Approach 2: Iterative (Fast)**
```java
private static long calcFib(int n) {
    long previous = 0;
    long current = 1;

    if (n <= 1) {
        return current;
    }

    for (int i = 2; i <= n; i++) {
        long aux = current;
        current = current + previous;
        previous = aux;
    }

    return current;
}
```

**Approach 3: Formula (Fast)**
```java
private static long calcFib(int n) {
    double phi = (1 + Math.sqrt(5)) / 2;
    return Math.round(Math.pow(phi, n) / Math.sqrt(5));

}   
```

## Test

Compile with `javac Fibonacci.java` and run with `java Fibonacci`.

```java
import java.util.Scanner;

public class Fibonacci {
    private static int calcFib(int n) {
        /* see previous code */
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calcFib(n));
    }
}

```