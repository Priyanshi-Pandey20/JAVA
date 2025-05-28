import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Hashing {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

  
    public static int[] FindTheTargetSum(int[] arr, int target) { // find the target sum by adding the elements in array

        HashMap<Integer, Integer> m = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (m.containsKey(target - arr[i])) {
                return new int[] { m.get(target - arr[i]), i };

            } else {
                m.put(arr[i], i);
            }

        }
        return new int[] {};
    }
   





    public static void main(String[] args) {
      int[] arr = {2,7,11,15};
      int target = 9;
      int[] result = FindTheTargetSum(arr, target);
        System.out.println(Arrays.toString(result));
        
    }

}
