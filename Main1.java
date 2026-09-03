import java.text.ListFormat.Style;

class Calculator{

    int add(int a, int b){
        return a + b;
    }

    int add(int a, int b, int c){
        return a + b + c;
    }

    double add(double a ,double b){
        return a + b;
    }
}

class Area {
    double circle(int radius){
        return 3.14 * radius * radius;
    }

    int rectangle(int length, int width){
        return length * width;
    }

    int square(int side){
        return side * side;
    }

}

class Printer{

    void print(int number){
        System.out.println(number);
    }
    void print(double number){
        System.out.println(number);
    }

}

// class Employee{

//     Employee(){
//         System.out.println("Constructor 1");
//     }
//     Employee(int number){
//         System.out.println(number);
//     }
//     Employee(double number1, double number2){
//         System.out.println(number1 +  " " + number2);
//     }

// }

// class Animal{
//     void eat(){
//         System.out.println("Eating");
//     }

// }
// class Dog extends Animal{
//     void bark(){
//         System.out.println("Barking");
//     }
// }

// class Cat extends Animal{
//     void sound(){
//         System.out.println("Meowwww");
//     }
// }

// class Vehicle{
//     void start(){
//         System.out.println("Starting....");
//     }
// }

// class Car extends  Vehicle{
//     void start(){
//         System.out.println("Car starting...");
//     }

//     void wheel(){
//         System.out.println("It has 4 wheels");
//     }
// }

// class Bike extends Vehicle{
//     void start(){
//         System.out.println("Bike Starting....");
//     }
    
// }

class Person{
    void display(){
        System.out.println("I am a person");
    }
}

class Student extends Person{
    void student(){
        System.out.println("I am a student");
    }
}

class CollegeStudent extends Student{
    void collegeStudent(){
        System.out.println("I am a college student");
    }
}

class Employee{
    int balance;
    int calculateSalary(int amount){
       balance += amount;
       return balance;
    }
}

class Developer extends Employee{
    @Override
    int calculateSalary(int amount){
        balance += amount;
        return balance;
    }
}

class Manager extends Employee{
    @Override
    int calculateSalary(int amount){
        balance += amount;
        return balance;
    }
}

class Animal{
    void sound(){
        System.out.println("Animal sound");
    }
}
 class Dog extends Animal{
    @Override
    void sound(){
        System.out.println("Dog sound");
    }
 }

interface Parent{
    void pay();
}
class UPIPayment implements Parent{
    @Override
    public void pay(){
        System.out.println("UPI Payment");
    } 
}
class CreditCard implements Parent{
    @Override
    public void  pay(){
        System.out.println("CreditCard payment");
    }
}

class Cash implements Parent{
    @Override
    public void pay(){
        System.out.println("Cash Payment");
    }
}

interface Vehicle{
    void start();
}

class Car implements Vehicle{
   @Override
   public void start(){
        System.out.println("Car starting....");
    }
}

class Bike implements Vehicle{
    public void start(){
        System.out.println("Bike starting....");
    }
}

class Truck implements Vehicle{
    @Override
    public void start(){
      System.out.println("Truck starting");
    }
}




public class Main1 {
    
 public static void main(String[] args){

//     Calculator c = new Calculator();
//     System.out.println(c.add(3, 5));
//     System.out.println(c.add(7, 9, 2));
//     System.out.println(c.add(5000, 40000));


//     Area a = new Area();
//    System.out.println( a.circle(20));
//    System.out.println( a.rectangle(12, 16));
//    System.out.println(a.square(6));

// Printer p = new Printer();
// p.print(3000000);
// p.print(233);

// Dog dog = new Dog();
// dog.eat();
// dog.bark();

// Cat cat = new Cat();
// cat.eat();
// cat.sound();

Developer d = new Developer();
d.balance = 300;
System.out.println(d.calculateSalary(400));

Manager m = new Manager();
m.balance = 400;
System.out.println(m.calculateSalary(900));

Animal a = new Dog();
a.sound();

UPIPayment upi = new UPIPayment();
upi.pay();

CreditCard cd = new CreditCard();
cd.pay();

Cash cash = new Cash();
cash.pay();

Vehicle c = new Car();
c.start();

Vehicle b = new Bike();
b.start();

Vehicle t = new Truck();
t.start();



}
    
}

