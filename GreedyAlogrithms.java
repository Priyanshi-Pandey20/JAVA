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

  public static void ActivitySelectionNotSorted(int[] start, int[] end) { // maximum activities selection when ending is // unsorted
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

  public static void FractionalKnapsack(int[] val,int[] weight,int W){ // Fractional Knapsack problem
     double[][] ratio = new double[val.length][2];
        for(int i = 0;i< val.length;i++){
          ratio[i][0] = i;
          ratio[i][1] = val[i]/(double)weight[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int capacity = W;
        int finalVal = 0;
        for(int i = ratio.length-1;i>=0;i--){
          int idx = (int) ratio[i][0];
          if(capacity >= weight[idx]){
            finalVal += val[idx];
            capacity -= weight[idx];
          }
          else{
            finalVal += (ratio[i][1] * capacity);
            capacity = 0;
            break;
          }
        }
        System.out.println(finalVal);
  }

  public static void main(String[] args) {
    int[] val ={60,100,120};
    int[] weight = {10,20,30};
    int W = 50;
    FractionalKnapsack(val, weight, W);

  }
}
