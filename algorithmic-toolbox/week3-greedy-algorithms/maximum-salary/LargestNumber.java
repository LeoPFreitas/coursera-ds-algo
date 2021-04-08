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

