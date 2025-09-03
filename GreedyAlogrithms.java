import java.io.CharArrayWriter;
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

  public static void FractionalKnapsack(int[] val, int[] weight, int W) { // fractionalknapsack pblm 
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

  public static void ChainPairs(int[][] pairs) { // O(nlogn) max length of chair pblm 
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

  public static void IndianCoin(Integer[] coins, int amount) { //keeping adding coins pblm
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

  static class Job {// job sequencing problem 
    int deadline;
    int profit;
    int id;

    public Job(int i, int d, int p) {
      id = i;
      deadline = d;
      profit = p;
    }
  }

  public static void JobSequencing(int[][] jobsInfo) { // job sequencing

    ArrayList<Job> jobs = new ArrayList<>();

    for (int i = 0; i < jobsInfo.length; i++) {
      jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
    }

    Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);// to sort the object in desecending order 

    ArrayList<Integer> seq = new ArrayList<>();
    int time = 0;
    for (int i = 0; i < jobs.size(); i++) {
      Job curr = jobs.get(i);
      if (curr.deadline > time) {
        seq.add(curr.id);
        time++;
      }
    }
    System.out.println("max jobs: " + seq.size());
    for (int i = 0; i < seq.size(); i++) {
      System.out.print(seq.get(i) + " ");
    }

  }

  public static void ChocolaProblem(Integer[] costVer, Integer[] costHor) { // divide the choclate into min cost pblm 

    Arrays.sort(costVer, Collections.reverseOrder());
    Arrays.sort(costHor, Collections.reverseOrder());

    int h = 0, v = 0;
    int hp = 1, vp = 1;
    int cost = 0;

    while (h < costHor.length && v < costVer.length) {
      if (costVer[v] <= costHor[h]) {
        cost += (costHor[h] * vp);
        hp++;
        h++;
      } else {
        cost += (costVer[v] * hp);
        vp++;
        v++;
      }
    }
    while (h < costHor.length) {
      cost += (costHor[h] * vp);
      hp++;
      h++;
    }
    while (v < costVer.length) {
      cost += (costVer[v] * hp);
      vp++;
      v++;
    }
    System.out.println(cost);

  }

  public static int BalancedPartition(String str, int n) { // no.of partition possible in string
    if (n == 0) {
      return 0;
    }
    int r = 0, l = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (str.charAt(i) == 'R') {
        r++;
      } else if (str.charAt(i) == 'L') {
        l++;
      }
      if (l == r) {
        ans++;
      }
    }
    return ans;

  }

  public static int KthOddNo(int[] range, int K) { // find the kth odd no. in given range from backwards
    if (K <= 0) {
      return 0;
    }
    int L = range[0];
    int R = range[1];

    if ((R & 1) > 0) {
      int count = (int) Math.ceil((R - L + 1) / 2);
      if (K > count)
        return 0;

      else
        return (R - 2 * K + 2);

    } else {
      int count = (R - L + 1) / 2;
      if (K > count)
        return 0;

      else
        return (R - 2 * K + 1);

    }
  }
public static int ans = 10000000;
  public static void CalculateSubarraySum(int[] a , int n,int k,int index,int sum,int maxSum){// calculate the minimum of the maximum subarray sum
        if(k == 1){
          maxSum = Math.max(maxSum,sum);
          sum =0;
          for(int i = index;i<n;i++){
            sum += a[i];
          }
          maxSum = Math.max(maxSum,sum);
          ans = Math.min(ans,maxSum);
          return;
        }
        sum =0;
        for(int i = index;i<n;i++){
          sum +=a[i];
          maxSum = Math.max(maxSum,sum);
          CalculateSubarraySum(a,n,k-1,i+1,sum,maxSum);
        }
  }

   


  public static void main(String[] args) {

    int[] a = {1,2,3,4};
    int k = 3;
    int n =4;
    CalculateSubarraySum(a, n, k, 0, 0, 0);
    System.out.println(ans);
  }
}
