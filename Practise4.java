import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;
import java.util.stream.Collectors;

class Buffer {

    boolean hasData = false;

    public synchronized void produce() {
        System.out.println("producer : fetching the signal");
        try {
            Thread.sleep(2000);
            hasData = true;
            System.out.println("produced : giving out signal ");
            notify();
        } catch (Exception e) {
        }

    }

    public synchronized void consume() {
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
     
        list.add(4);
        list.add(3);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(0);
        list.add(2);
        list.add(25);

        Integer evenList = list.stream().sorted((a,b) -> a-b).skip(1).findFirst().orElse(Integer.MIN_VALUE);
        System.out.println(evenList);
      

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
