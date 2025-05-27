
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class Practise {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        long start = System.nanoTime();
        ll.add(5);
        System.out.println(ll.contains(5));
        long end = System.nanoTime();
        System.out.println(end - start);

        int[] arr = { 1, 2, 2, 42, 4, 5, 3, 53, 45, 3, 5 }; // find first duplicate
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                System.out.println("first duplicate: " + arr[i]);
                break;
            }
            set.add(arr[i]);
        }
        System.out.println(set);

        HashSet<Integer> set2 = new HashSet<>(); // count the duplicates
        int count = 0;
        for (int i = 1; i < arr.length; i++) {

            if (set2.contains(arr[i])) {
                System.out.println(arr[i]);
                count++;

            }
            set2.add(arr[i]);
        }
        System.out.println(set2);
        System.out.println(count);
        System.out.println();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "my");
        map.put(2, "name");
        map.put(3, "is");
        map.put(4,"Tiwari");
       
       
    }
}
