import java.util.*;

public class LeastCommonMultiple {
  private static long leastCommonMultipleNaive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0) {
        return l;
      }

    return (long) a * b;
  }

  private static int calcGreatestCommonDivisorFast(int a, int b) {
    if (a == 0) {
      return b;
    }

    return calcGreatestCommonDivisorFast(b % a, a);
  }

  private static long leastCommonMultipleFast(int a, int b) {
    long gcd = calcGreatestCommonDivisorFast(a, b);

    return (a / gcd) * b;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(leastCommonMultipleFast(a, b));
  }
}
