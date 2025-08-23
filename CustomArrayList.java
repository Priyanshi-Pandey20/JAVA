import java.util.*;

public class CustomArrayList {
   public static void ReverseArrayList() {
      ArrayList<Integer> list = new ArrayList();
      list.add(1);
      list.add(2);
      list.add(3);

      System.out.println(list.size());
      for (int i = list.size() - 1; i >= 0; i--) {
         System.out.println(list.get(i));
      }
   }

   public static void MaximumNoInArrayList() { // find max element in array
      ArrayList<Integer> list = new ArrayList();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(8);
      list.add(9);
      list.add(2);
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i) > max) {
            max = list.get(i);
         }
      }
      System.out.println(max);

   }

   public static void SwapTwoNo(ArrayList<Integer> list, int idx1, int idx2) { // swap two no.
      int temp = list.get(idx1);
      list.set(idx1, list.get(idx2));
      list.set(idx2, temp);
   }

   public static void ArrangeInAsending(ArrayList<Integer> list1) { // Arrange list in ascending and descending order

      Collections.sort(list1);
      System.out.println(list1);
      Collections.sort(list1, Collections.reverseOrder());
      System.out.println(list1);
   }

   public static int storeWater(ArrayList<Integer> height) { // O(n^2) brute force approach
      int maxWater = 0;
      for (int i = 0; i < height.size(); i++) {
         for (int j = i + 1; j < height.size(); j++) {
            int ht = Math.min(height.get(i), height.get(j));
            int width = j - i;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);
         }
      }
      return maxWater;
   }

   public static int StoreWater(ArrayList<Integer> height) { // store water optimal approach 
      int maxWater = 0;
      int lp = 0;
      int rp = height.size() - 1;
      while (lp < rp) {
         int ht = Math.min(height.get(lp), height.get(rp));
         int width = rp - lp;
         int currWater = ht * width;
         maxWater = Math.max(maxWater, currWater);

         if (height.get(lp) < height.get(rp)) {
            lp++;
         } else {
            rp--;
         }
      }
      return maxWater;
   }

   public static boolean TwoSum(ArrayList<Integer> list, int target) { // two sum for liner list 
      int lp = 0;
      int rp = list.size() - 1;
      while (lp != rp) {
         if (list.get(lp) + list.get(rp) == target) {
            return true;
         }
         if (list.get(lp) + list.get(rp) < target) {
            lp++;
         } else {
            rp--;
         }

      }
      return false;
   }

   public static boolean TwoSum2(ArrayList<Integer> list, int target) { // two sum for rotated list
      int bp = -1;
      int n = list.size();
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i) > list.get(i + 1)) {
            bp = i;
            break;
         }

      }
      int lp = bp + 1;
      int rp = bp;
      while (lp != rp) {
         if (list.get(lp) + list.get(rp) == target) {
            return true;
         }
         if (list.get(lp) + list.get(rp) < target) {
            lp = (lp + rp) % n;
         } else {
            rp = (n + rp - 1) % n;
         }
      }
      return false;
   }

   public static boolean MonotonicArrayList(ArrayList<Integer> list) { // monotonic array 
      for (int i = 0; i < list.size(); i++) {
         for (int j = i + 1; j < list.size(); j++) {
            while (i < j || list.get(i) == list.get(j)) {
               if (list.get(i) <= list.get(j) || list.get(i) >= list.get(j)) {
                  return true;
               }
            }
         }
      }
      return false;
   }

   public static ArrayList<Integer> BeautifulArrayList(int n) { // Beautiful Arraylist 
      ArrayList<Integer> ans = new ArrayList<>();
      divideConqure(1, 1, ans, n);
      return ans;
   }

   private static void divideConqure(int start, int increment, ArrayList<Integer> ans, int n) {
      if (start + increment > n) {
         ans.add(start);
         return;
      }
      divideConqure(start, 2 * increment, ans, n);
      divideConqure(start + increment, 2 * increment, ans, n);
   }

   public static void main(String[] args) {

      ArrayList<Integer> list = new ArrayList<>();

      list.add(1);
      list.add(2);
      list.add(4);
      list.add(5);
      // list.add(10);
      // System.out.println(TwoSum(list, 5));
      System.out.println(MonotonicArrayList(list));
      System.out.println(BeautifulArrayList(4));

   }
}
