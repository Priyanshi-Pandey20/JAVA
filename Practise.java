
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

class Student implements Comparable<Student> { //  sort acc. to age by making objects
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return age + " " + name;
    }

    public int compareTo(Student s) {
        return this.age - s.age;
    }
}


class Student1 {  //   student class
    int rollno;
    String name;
    int age;

    public Student1(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " " + age + " " + rollno;
    }

}

 class sortByname implements Comparator<Student1> {
    public int compare(Student1 s1, Student1 s2) {
        return s1.name.compareTo(s2.name);
    }
}
class sortByage implements Comparator<Student1> {
    public int compare(Student1 s1, Student1 s2) {
        return Integer.compare(s1.age,s2.age);
    }
}
class sortByroll implements Comparator<Student1> {
    public int compare(Student1 s1, Student1 s2) {
        return Integer.compare(s1.rollno,s2.rollno);
    }
}


public class Practise {
    public static void FindFirstDuplicate() {// find first duplicate pblm 
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

    public static void CountDuplicates() {// count the duplicates pblm 
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

    public static void FrequencyCount() { // count the character frequency in string pblm 
        String str = "programming";
        char[] ch = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char i : ch) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println(map);

    }

    public static void Count() { // count the string frequency in string pblm 
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

    public static void FirstNonReapting() { // print first non repeting no. pblm

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
        System.out.println();

         ArrayList<Student> list3 = new ArrayList<>();
        list3.add(new Student(12, "rahul"));
        list3.add(new Student(11, "rohit"));
        list3.add(new Student(3, "mohit"));

        Collections.sort(list3);
        for (Student s : list3) {
            System.out.println(s.toString());

        }


         ArrayList<Student1> list4 = new ArrayList<>();
        list4.add(new Student1(55, "Abhi", 12));
        list4.add(new Student1(40, "Rahul", 40));
        list4.add(new Student1(90, "Tina", 9));
        list4.add(new Student1(32, "Yash", 74));
        Collections.sort(list4, new sortByname());
        for(Student1 s : list4){
            System.out.println(s);
        }
        System.out.println();

        Collections. sort(list4,new sortByroll());
        for(Student1 s : list4){
            System.out.println(s);
        }
        System.out.println();

        Collections.sort(list4,new sortByage());
        for(Student1 s : list4){
            System.out.println(s);
        }



        





        

      
         


    }
}
