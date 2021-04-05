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

             while (pointer< segments.length && segments[pointer].start <= seg.end) {
                 pointer++;
             }

             selectedPoints.add(seg.end);
             segment = pointer;
        }

        return selectedPoints;
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
 
