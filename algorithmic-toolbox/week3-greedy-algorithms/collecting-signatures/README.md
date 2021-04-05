# Collecting Signatures

## Problem Description

**Task.** Given a set of _n_ segments {[_a_<sub>0</sub>, _b_<sub>0</sub>], [_a_<sub>1</sub>, _b_<sub>1</sub>], . . . , [_a_<sub>n-1</sub>, _b_<sub>n-1</sub>]} with integer coordinates on a line, find the minimum number _m_ of points such that each segment contains at least one point. That is, find a set of integers _X_ of the minimum size such that for any segment [_a_<sub>i</sub>, _b_<sub>i</sub>] there is a point _x_ ∈ _X_ such that _a_<sub>i</sub> ≤ _x_ ≤ _b_<sub>i</sub>.

**Input Format.** The frst line of the input contains the number _n_ of segments. Each of the following _n_ lines contains two integers _a_<sub>i</sub> and _b_<sub>i</sub> (separated by a space) defining the coordinates of endpoints of the _i_-th segment.

**Constraints.** 1 ≤ _n_ ≤ 100; 0 ≤ _a_<sub>i</sub> ≤ _b_<sub>i</sub> ≤ 10<sup>9</sup> for all 0 ≤ _i_ < _n_.

**Output Format.** Output the minimum number _m_ of points on the first line and the integer coordinates of _m_ points (separated by spaces) on the second line. You can output the points in any order. If there are many such sets of points, you can output any set. (It is not diffcult to see that there always exist a set of points of the minimum size such that all the coordinates of the points are integers.)

**Sample 1.**

```text
Input
    3
    1 3
    2 5
    3 6
Output:
    13
```

**Sample 2.**

```text
Input
    4
    4 7
    1 3
    2 5
    5 6
Output:
    2
    3 6
```
## Solution

```java
import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        Arrays.sort(segments, (o1, o2) -> o1.end - o2.end);

        int count = 0;
        List<Integer> selectedPoints = new ArrayList<>();
        int segment = 0;

        while (segment < segments.length) {
            Segment seg = segments[segment];
            int pointer = count;

            while (pointer <= segments.length && segments[pointer].start <= seg.end) {
                pointer++;
            }

            selectedPoints.add(seg.end);
            segment = pointer;
        }

        return selectedPoints;
    }
}
```

## Test

Compile with `javac FibonacciPartialSum.java` and run with `java FibonacciPartialSum`.

```java
import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        /* see previous code */
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}


```
