
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

public class Practise {
    public static void FindFirstDuplicate() {// find first duplicate
        int[] arr = { 1, 2, 2, 42, 4, 5, 3, 53, 45, 3, 5 };
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                System.out.println("first duplicate: " + arr[i]);
                break;
            }
            set.add(arr[i]);
        }
        System.out.println(set);
    }

    public static void CountDuplicates() {// count the duplicates
        int[] arr = { 1, 2, 2, 42, 4, 5, 3, 53, 45, 3, 5 };

        HashSet<Integer> set2 = new HashSet<>();
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
    }

    public static void FrequencyCount() { // count the character frequency in string
        String str = "programming";
        char[] ch = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char i : ch) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println(map);

    }

    public static void Count() { // count the string frequency in string
        String str = "programming is fun and fun is programming";
        String[] words = str.split(" ");
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (String word : wordCount.keySet()) {
            System.out.print(word + " -> " + wordCount.get(word));
        }

    }

    public static void FirstNonReapting() { // print first non repeating no.

        String str = "aaabcccddeef";
        char[] ch = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char i : map.keySet()) {
            if (map.get(i) == 1) {
                System.out.println(" first non repeating " + i);
                return;
            }
        }
        System.out.println("no one is repeating");

    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        long start = System.nanoTime();
        ll.add(5);
        System.out.println(ll.contains(5));
        long end = System.nanoTime();
        System.out.println(end - start);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "my");
        map.put(2, "name");
        map.put(3, "is");
        map.put(4,"Tiwari");

        Count();

        ArrayList<String> list = new ArrayList<>();
        list.add("Rahul");
        list.add("Rohit");
        list.add("Tina");
        list.add("Mohit");
        list.add("Sakshi");

        System.out.println(list);
        Iterator<String>it = list.iterator();
        while(it.hasNext()){
        String data = it.next();
        if(data.startsWith("T")){
        it.remove();
        }

        }
        System.out.println(list);

        ListIterator<String> itr = list.listIterator(); // It works only on list and
       
        while (it.hasNext()) {
        String data = it.next();
        System.out.println(data);
        }
        System.out.println();

        while (itr.hasPrevious()) {
        String prevData = itr.previous();
        System.out.println(prevData);
        }

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("kajal");
        list1.add("priyanshi");
        list1.add("Om");

        ListIterator<String> str = list1.listIterator();

        int index = list1.size() - 1;

        while (str.hasNext()) {
            String data = str.next();

            if (data.length() <= 3) {
                str.set("bye");

            }

        }
        System.out.println(list1);

        while (str.hasPrevious()) {
            String prevData = str.previous();

            if (index != 0) {
                str.set("hello");

            }
            index--;
        }
        System.out.println(list1);

        ArrayList<Integer>names = new ArrayList<>();
        names.add(1);
        names.add(10);
        names.add(0);
        names.add(12);
        names.add(12);
        names.add(21);
        Collections.shuffle(names);
        System.out.println(names);



        

      
         


    }
}
