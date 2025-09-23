import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;
import java.util.stream.Collectors;

class Buffer {

    boolean hasData = false;

    public synchronized void produce() { // producer class 
        System.out.println("producer : fetching the signal");
        try {
            Thread.sleep(2000);
            hasData = true;
            System.out.println("produced : giving out signal ");
            notify();
        } catch (Exception e) {
        }

    }

    public synchronized void consume() { // consumer class 
        while (!hasData) {
            try {
                System.out.println("consumer: is waiting ... ");
                wait();
            } catch (Exception e) {

            }
            System.out.println(" consumer : got the signal ! Proceeding ");

        }
    }
}

public class Practise4 {
    public static void main(String[] args) {
        // ArrayList<String> list = new ArrayList<>();
        // list.add("rahul");
        // list.add("rohit");
        // list.add("raj");

        // Collections.sort(list,(a,b) -> a.compareTo(b));
        // System.out.println(list);

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> evenList = list.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
        System.out.println(evenList);

        ArrayList<String> names = new ArrayList<>(); // add the names in list
        names.add("Ram");
        names.add("Shyam");
        names.add("Om");
        names.add("Sita");

        List<String> output = names.stream().filter(name -> name.length() > 3).map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(output);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        int sum = 0;
        Integer oddSum = list1.stream().filter(n -> n%2 !=0).reduce(0, Integer:: sum);
        System.out.println(oddSum);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Java");
        list2.add("Stream");
        list2.add("Api");

        List<Integer> lengths = list2.stream().map(String:: length).collect(Collectors.toList());
        System.out.println(lengths);

        ArrayList<Integer>list3 = new ArrayList<>();
        list3.add(1000);
        list3.add(1500);
        list3.add(1000);
        list3.add(2000);
        int sum1 = 0;
        Integer tt = list3.stream().filter(n -> n>1000).reduce(0, Integer :: sum);
        System.out.println(tt);


        ArrayList<String> list4 = new ArrayList<>();
        list4.add("apple");
        list4.add("banana");
        list4.add("apricot");
        list4.add("cherry");
        list4.add("Avacado");

        long ll = list4.stream().filter( s -> s.toLowerCase().startsWith("a")).map(String:: length).count();
        System.out.println(ll);

        ArrayList<String>list5 = new ArrayList<>();
        list5.add("John");
        list5.add("Ravi");
        list5.add("Abhishek");
        list5.add("Raj");
        String result =  list5.stream().filter(name-> name.length()>4).collect(Collectors.joining(","));
        System.out.println(result);

        ArrayList<Integer> list6 = new ArrayList<>();
        list6.add(10);
        list6.add(14);
        list6.add(22);
        list6.add(30);

        boolean hasDivBy7 =  list6.stream().anyMatch(n->n%7 == 0);
        System.out.println(hasDivBy7);

        ArrayList<Integer> list7 = new ArrayList<>();
        list7.add(1);
        list7.add(2);
        list7.add(3);
        list7.add(4);

        Integer ll1 = list7.stream().reduce(1, (a,b) ->a*b);
        System.out.println(ll1);

       




        // Buffer b = new Buffer();
        // Thread d1 = new Thread(() -> {
        // b.consume();

        // });

        // Thread d2 = new Thread(() -> {

        // b.produce();
        // });
        // d1.start();
        // d2.start();

        // Runnable r = new Runnable() {

        // public void run(){
        // System.out.println("Runnable using anonymus class");
        // }
        // };
        // r.run();
        // Runnable r1 =() -> System.out.println("Runnable using anonymus class");
        // r1.run();

    }
}
