import java.util.*;
import java.util.Arrays;

public class GreedyAlogrithms {

  public static String getSmallestString(int n, int k) { // lexicographically smallest string
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

  public static void ActivitySelection(int[] start, int[] end) { // maximum activities selection problem
    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    maxAct = 1;
    ans.add(0);
    int lastEnd = end[0];

    for (int i = 1; i < end.length; i++) {
      if (start[i] >= lastEnd) {
        maxAct++;
        ans.add(i);
        lastEnd = end[i];
      }
    }
    System.out.println("max activity: " + maxAct);

    for (int i = 0; i < ans.size(); i++) {
      System.out.println("A" + ans.get(i) + " ");
    }
    System.out.println();

  }

  public static void ActivitySelectionNotSorted(int[] start, int[] end) { // maximum activities selection when ending is
                                                                          // // unsorted
    int activity[][] = new int[start.length][3];
    for (int i = 0; i < start.length; i++) {
      activity[i][0] = i;
      activity[i][1] = start[i];
      activity[i][2] = end[i];

    }

    Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));

    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    maxAct = 1;
    ans.add(activity[0][0]);
    int lastEnd = activity[0][2];

    for (int i = 1; i < end.length; i++) {
      if (activity[i][1] > lastEnd) {
        maxAct++;
        ans.add(activity[i][0]);
        lastEnd = activity[i][2];
      }
    }
    System.out.println("max activity: " + maxAct);

    for (int i = 0; i < ans.size(); i++) {
      System.out.println("A" + ans.get(i) + " ");
    }
    System.out.println();

  }

  public static void FractionalKnapsack(int[] val, int[] weight, int W) { // Fractional Knapsack problem
    double[][] ratio = new double[val.length][2];
    for (int i = 0; i < val.length; i++) {
      ratio[i][0] = i;
      ratio[i][1] = val[i] / (double) weight[i];
    }
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

    int capacity = W;
    int finalVal = 0;
    for (int i = ratio.length - 1; i >= 0; i--) {
      int idx = (int) ratio[i][0];
      if (capacity >= weight[idx]) {
        finalVal += val[idx];
        capacity -= weight[idx];
      } else {
        finalVal += (ratio[i][1] * capacity);
        capacity = 0;
        break;
      }
    }
    System.out.println(finalVal);
  }

  public static void MinAbsoluteDifferencePairs(int[] A, int[] B) { // O(nlogn) minimum absolute difference of pair
    Arrays.sort(A);
    Arrays.sort(B);

    int minDiff = 0;
    for (int i = 0; i < A.length; i++) {
      minDiff = Math.abs(A[i] - B[i]);
    }
    System.out.println("min absolute value : " + minDiff);
  }

  public static void ChainPairs(int[][] pairs) { // O(nlogn) max length of the chain
    Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

    int chainLen = 1;
    int chainEnd = pairs[0][1];

    for (int i = 1; i < pairs.length; i++) {
      if (pairs[i][0] >= chainEnd) {
        chainLen++;
        chainEnd = pairs[i][1];
      }
    }
    System.out.println("max length of chain : " + chainLen);

  }

  public static void IndianCoin(Integer[] coins, int amount) { // keeping adding coin
    Arrays.sort(coins, Comparator.reverseOrder());
    int countOfCoins = 0;

    ArrayList<Integer> ans = new ArrayList<>();

    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= amount) {
        while (coins[i] <= amount) {
          countOfCoins++;
          ans.add(coins[i]);
          amount -= coins[i];
        }
      }
    }
    System.out.println(countOfCoins);
    for (int i = 0; i < ans.size(); i++) {
      System.out.println(ans.get(i) + "");
    }
  }

  public static void main(String[] args) {
    Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
    int amount = 5590;
    IndianCoin(coins, amount);
  }
}
