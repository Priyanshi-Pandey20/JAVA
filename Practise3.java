import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student> {
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

class Student1 {
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
        return Integer.compare(s1.age, s2.age);
    }
}

class sortByroll implements Comparator<Student1> {
    public int compare(Student1 s1, Student1 s2) {
        return Integer.compare(s1.rollno, s2.rollno);
    }
}

// MultiThreading
class downloadFile { // without multithreading
    public static void file(String file) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(file + " downloading..." + (i * 20) + "%");

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

        }
        System.out.println(file + " done");
    }
}

// class DownloadFile extends Thread { // with multithreading
// String file;

// DownloadFile(String file) {
// this.file = file;

// }

// public void run() {
// for (int i = 1; i <= 5; i++) {
// System.out.println(file + " downloading..." + (i * 20) + "%");

// try {
// Thread.sleep(2000);
// } catch (Exception e) {
// }

// }
// System.out.println(file + " done");

// }
// }

class MyRunnable implements Runnable { // with runnable
    String file;

    MyRunnable(String file) {
        this.file = file;

    }

    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(file + " downloading..." + (i * 20) + "%");

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

        }
        System.out.println(file + " done");

    }
}

class MyThread extends Thread {
    static int balance = 1000;
    int amount;

    MyThread(int amount) {
        this.amount = amount;
    }

    public void run() {
        synchronized (MyThread.class) {
            if (balance >= amount) {

                System.out.println(" is going to withdrawl " + amount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                balance -= amount;
                System.out.println("Remaining balance " + balance);
            } else {
                System.out.println("sorry not have enough balance to withdraw ");
            }
        }

    }

}

class NewThread extends Thread {
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(getName() + " is running ..." + getPriority());
            Thread.yield();

        }
    }
}
  

public class Practise3 {
   
    public static void main(String[] args) {
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
        for (Student1 s : list4) {
            System.out.println(s);
        }
        System.out.println();

        Collections.sort(list4, new sortByroll());
        for (Student1 s : list4) {
            System.out.println(s);
        }
        System.out.println();

        Collections.sort(list4, new sortByage());
        for (Student1 s : list4) {
            System.out.println(s);
        }


        NewThread t1 = new NewThread();
        NewThread t2 = new NewThread();

        t1.setName("A");
        t1.setName("B");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();










    }

}
