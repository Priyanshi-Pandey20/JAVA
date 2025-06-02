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

    static class Pair { // Bottom View of Tree
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

        Collections.sort(freqList, (a, b) -> b.getValue() - a.getValue());
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

    public static void findUnionNIntersection(int[] arr1, int[] arr2) { // find union and intersection of 2 arrays

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);

        }
        for (int num : set) {
            System.out.println( " union of array is : " + num);
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

    public static void main(String[] args) {
        // String s = "aaaabbbcccdddddeee";
        // System.out.println(FrequencySort(s));

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println("Bottom View : " + printbottomView(root));

        int[] arr1 = { 7, 3, 9 };
        int[] arr2 = { 6, 3, 9, 2, 9, 4 };
        findUnionNIntersection(arr1, arr2);

    }

}
