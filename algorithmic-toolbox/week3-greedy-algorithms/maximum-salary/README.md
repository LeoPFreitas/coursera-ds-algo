# 6. Maximum Salary

## Problem Description

**Task.** Compose the largest number out of a set of integers.

**Input Format.** The first line of the input contains an integer _n_. The second line contains integers _a_<sub>1</sub>
, _a_<sub>2</sub>, _. . ._ , _a_<sub>n</sub>.

**Constraints.**  1 ≤ _n_ ≤ 100; 1 ≤ _a_<sub>i</sub> ≤ 10<sup>3</sup> for all 1 ≤ _i_ ≤ _n_.

**Output Format.** Output the largest number that can be composed out of _a_<sub>1</sub>, _a_<sub>2</sub>, _. . ._ , _
a_<sub>n</sub>.

**Sample 1.**

```text
Input
    2
    21 2
Output:
    221
```

**Sample 2.**

```text
Input
    5
    9 4 6 1 9
Output:
    99641
```

**Sample 3.**

```text
Input
    3
    23 39 92
Output:
    923923
```

## Solution

```java
import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        List<String> strings = Arrays.asList(a);
        strings.sort((a1, b) -> {
            String ab = a1 + b;
            String ba = b + a1;

            return ba.compareTo(ab);
        });

        //write your code here
        StringBuilder result = new StringBuilder();
        for (String s : a) {
            result.append(s);
        }
        return result.toString();
    }
}

```

## Test

Compile with `javac LargestNumber.java` and run with `java LargestNumber`.

```java
import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        /* see previous code */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
```