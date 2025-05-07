class Employee { // single level Inheritance
    void work() {
        System.out.println("Employee is working");
    }
}

class Manager extends Employee {
    void attendMeeting() {
        System.out.println("Manager is attending a meeting");
    }
}

class Person { // mutlilevel
    void displayName() {
        System.out.println("tina");
    }
}

class Student extends Person {
    void displayClass() {
        System.out.println("Class : 12th");
    }
}

class Moniter extends Student {
    void checkdispline() {
        System.out.println("Moniter is checking discipline");
    }
}

class Device {
    void powerOn() {
        System.out.println("system is on");
    }
}

class Laptop extends Device {
    void boot() {
        System.out.println("Laptop is booting");
    }
}

class GamingLaptop extends Laptop {
    void startGame() {
        System.out.println("Game is starting");
    }
}

class Animal {
    void eat() {
        System.out.println("eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barkkk");
    }
}

class Puppy extends Dog {
    void cute() {
        System.out.println("cute");
    }
}

class cat extends Animal {
    void sound() {
        System.out.println("makes sound");
    }
}

class Add {// method overloading
    void sum(int a, int b) {
        System.out.println(a + b);
    }

    void sum(int a, int b, int c) {
        System.out.println(a + b + c);
    }
}

class Sum {
    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }

    void add(double a, double b) {
        System.out.println(a + b);
    }

}

class Shape {
    void area(double radius) {

        System.out.println(3.14 * radius * radius);
    }

    void area(int l, int b) {
        System.out.println(l * b);
    }

    void area(int s) {
        System.out.println(s * s);
    }

    void area(double base, double height) {
        System.out.println(0.5 * base * height);
    }

}

class Book {
    void display(String title, String author) {
        System.out.println(title);
        System.out.println(author);
    }

    void display(String title, String author, int price) {
        System.out.println(title);
        System.out.println(author);
        System.out.println(price);

    }
}

public class Inheritance {

    public static void main(String[] args) {

        Book obj = new Book();
        obj.display("JunglebBook", "JS thomson");
        obj.display("JunglebBook", "JS thomson", 50);

    }
}
