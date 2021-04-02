# 4. The Least Common Multiple

## Problem Description

**Task.** Given two integers _a_ and _b_, find their least common multiple.

**Input Format.** The two integers _a_, _b_ are given in the same line separated by space.

**Constraints.** 1 ≤ _a_, _b_ ≤ 2 · 10<sup>9</sup>.

**Output Format.** Output the least common multiple of _a_ and _b_

**Sample 1.**

```text
Input
    6 8
Output
    24
```

**Sample 2.**

```text
Input
    28851538 1183019
Output
    1933053046
```

## Solution

**Approach 1: Iterative (Naive)**

```java
private static long leastCommonMultipleNaive(int a,int b){
        for(long l=1;l<=(long)a*b;++l)
        if(l%a==0&&l%b==0){
        return l;
        }

        return(long)a*b;
        }
```

**Approach 2: Recursive (Fast)**

```java
private static int calcGreatestCommonDivisorFast(int a,int b){
        if(a==0){
        return b;
        }

        return calcGreatestCommonDivisorFast(b%a,a);
        }

private static long leastCommonMultipleFast(int a,int b){
        long gcd=calcGreatestCommonDivisorFast(a,b);

        return(a/gcd)*b;
        }
```

## Test

Compile with `javac LCM.java` and run with `java LCM`.

```java
import java.util.*;

public class LCM {

    private static long lcmFast(int a, int b) {
        /* see previous code */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(leastCommonMultipleFast(a, b));
    }
}

```