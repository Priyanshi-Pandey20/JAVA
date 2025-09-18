import java.util.*;

public class Hashing2 {
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

    static class Pair { // bottom view of tree 
        int level;
        int data;

        Pair(int level, int data) {
            this.level = level;
            this.data = data;
        }
    }

    public static void helper(Node root, int dist, int level, TreeMap<Integer, Pair> map) {
        if (root == null)
            return;

        if (!map.containsKey(dist) || map.get(dist).level <= level) {
            map.put(dist, new Pair(level, root.data));
        }
        helper(root.left, dist - 1, level + 1, map);
        helper(root.right, dist + 1, level + 1, map);
    }

    public static ArrayList<Integer> printbottomView(Node root) {
        TreeMap<Integer, Pair> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        helper(root, 0, 0, map);

        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            ans.add(entry.getValue().data);
        }
        return ans;
    }

    public static String FrequencySort(String s) { // on the basis of frequency sort the characters
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> freqList = new ArrayList<>(frequencyMap.entrySet());

        Collections.sort(freqList , (a, b) -> b.getValue() - a.getValue());
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freqList) {
            char ch = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static int[] TwoSum(int[] arr, int target) { // find the target sum by adding the elements in array

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

    public static void majorityElement(int[] arr) { // find all elements that appear more then n/3 times
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }

    }

    public static boolean isAnagrams(String s, String t) { // check anagram
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }

        }
        return map.isEmpty();
    }

    public static void findUnionNIntersection(int[] arr1, int[] arr2) { // find union and intersection of 2 arrays pblm

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);

        }
        for (int num : set) {
            System.out.println(" union of array is : " + num);
        }
        set.clear();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                System.out.println(arr2[i]);
                set.remove(arr2[i]);
            }
        }

    }   

    public static String getStart(HashMap<String, String> tickets) {  // find the path from source to destination pblm 
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }


    public static void largestSubarraySum(int[] arr){ // fint the largest subarray sum
         HashMap <Integer,Integer> map = new HashMap<>();

        int sum =0;
        int len =0;
        for(int  j =0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len, j-map.get(sum));
            }
            else{
                map.put(sum, j);
            }
        }
        System.out.println("length of largest subbarray sum : " + len);

    }

    public static void subarraySumEqualToK(int[]arr,int k){   // subarray sum equal to k
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum =0;
        int ans =0;

        for(int j =0;j<arr.length;j++){
            sum +=arr[j];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(ans);
    }

    


    

    public static void main(String[] args) {
        
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Banglore"); 
        tickets.put("Mumbai", " Delhi");
        tickets.put("Goa", " Chennai");
        tickets.put("Delhi", " Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print("->" + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();

       int[] arr = {10,2,-2,-20,10};
       int k = -10;
       subarraySumEqualToK(arr, k);
       

    }

}
