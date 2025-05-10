import java.util.*;
import java.util.Arrays;

public class GreedyAlogrithms {

  public static String getSmallestString(int n, int k) {// lexicographically smallest string
    char[] res = new char[n];
    Arrays.fill(res, 'a');
    k -= n;

    while (k > 0) {
      if (k >= 25) {
        System.out.println("before : " + res[n - 1]);
        res[n - 1] += 25;
        System.out.println("after : " + res[n - 1]);
        k -= 25;
      } else {
        res[n - 1] += k;
        k = 0;
      }
      n -= 1;
    }
    return String.valueOf(res);

  }

  public static void main(String[] args) {
    int n = 5, k = 73;
    System.out.println(getSmallestString(n, k));

  }
}
