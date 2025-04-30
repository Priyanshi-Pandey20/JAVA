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

   public static void MaximumNoInArrayList() { // find max elements in list
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

   public static void ArrangeInAsending(ArrayList<Integer> list1) { //Arrange list in ascending and descending order

      Collections.sort(list1);
      System.out.println(list1);
      Collections.sort(list1, Collections.reverseOrder());
      System.out.println(list1);
   }

   public static void main(String[] args) {
      // ReverseArrayList();
      // MaximumNoInArrayList();
      // ArrayList<Integer> list = new ArrayList();
     
      // ArrayList<Integer> list1 = new ArrayList();
      // list1.add(1);
      // list1.add(9);
      // list1.add(3);
      // list1.add(8);
      // list1.add(0);
      // ArrangeInAsending(list1);

      ArrayList<ArrayList<Integer>>mainList = new ArrayList<>();
      ArrayList<Integer>list = new ArrayList<>();
      list.add(1);list.add(2);
      mainList.add(list);

      ArrayList<Integer>list2 = new ArrayList<>();
      list2.add(3);list2.add(4);
      mainList.add(list2);

      for(int i =0;i<mainList.size();i++){
         ArrayList<Integer> currList = mainList.get(i);
         for(int j =0;j<currList.size();j++){
            System.out.print(currList.get(j));
         }
         System.out.println();

   
      }

   }
}
