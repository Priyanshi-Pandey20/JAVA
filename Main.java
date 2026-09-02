// class Student{
//     int id;
//     String name;

//     Student(int id,String name){
//         this.id = id;
//         this.name = name;
//     }
// }

// class Employee{
//     int id;
//     String name;
//     int salary;

//     void display(){
//         System.out.println("Id:" + id + "\n" +"Name: " + name + " \n"+ "Salary: "+  salary);
//     }
// }

// class Rectangle{
//     int length;
//     int width;

//     int area(){
//         int area = length * width;
//        return area;
//     }
    
// }

// class StudentDetail{
//     int id;
//     String name;
//     int marks;

//     StudentDetail(int id,String name,int marks){
//         this.id = id;
//         this.name = name;
//         this.marks = marks;
//     }

//     void calculateMarks(){
//         if(marks > 40){
//             System.out.println("pass");
//         }
//         else{
//             System.out.print("Fail");
//         }
//     }

//     void display(){
//         System.out.println("Id:" + id + "\n" + "Name: " + name );
//     }

// }

// class Book {
//     int id ;
//     String name;
//     int price;

//     Book(int id,String name,int price){
//         this.id = id;
//         this.name = name;
//         this.price = price;
//     }

//     void display(){
//         System.out.println("ID: " + id + "\n" + "Name:" + name + "\n" + "Price: " + price);
//     }
// }




class Car{
    String brand;
    String model;
    double price;

    void display(){
        System.out.println("Brand: " + brand + "\n" + "Model : " + model +  "\n" + "Price: "+ price);
    }
}

// class BankAccount{
//     int account_number;
//     String name;
//     double balance;

//     BankAccount(){
//         this(123456,"Priya",500000);
//     }

//     BankAccount(int account_number,String name,double balance){
//         this.account_number = account_number;
//         this.name = name;
//         this.balance = balance;
//     }

//     void display(){
//         System.out.println("Account Number: " + account_number);
//         System.out.println(" Name: " + name);
//         System.out.println("Account Balance: " + balance);
//     }
// }


    class BankAccount1{
        private int balance;

        public void deposit(int amount){
            balance += amount;
        }

        public void withdraw(int amount){
            balance -= amount;
        }

        public int getBalance(){
            System.out.println("Your Account Balance is : ");
            return balance;
        }

    }

    class Student {
        private int marks;

        public void setMarks(int marks){
            if(marks < 0){
                System.out.println("Marks cannot be negative");
            }
            else{
                this.marks = marks;
            }
        }

        public int getMarks(){
            return marks;
        }
    }

    // class Employee{
    //     private double salary;

    //     public void setSalary(double salary){
    //         if(salary < 0){
    //             System.out.println("Salary must be greater than 0 ");
    //         }
    //         else{
    //             this.salary = salary;
    //         }
    //     }

    //     public double getSalary(){
    //         return salary;
    //     }
    // }


    class Person{
        private int age;

        public void setAge(int age){
            if(age >= 1 && age <= 100){
                System.out.println("Valid age" );
                this.age = age;
            }
            else{
                System.out.println("Not a valid age");
            }
        }

        public int getAge(){
          return age;
        }

    }

    class Bank {
        static String name = "Baroda Bank" ;
    }

    class Counter{
        static int counter = 0;

        public int increment(){
            counter++;
            return counter;
        }
    }

    class Utilty{
    
         static int square(int number){
            int ans = number * number;
            return ans;
        }
    }

    class Employee{
        static int id;

        public int generateId(){
            return id++;
        }

    }

    class BankAccount{
        final int number = 123456;

        void display(){
            System.out.println("Account number : "+ number);
        }
    }

    final class Base{
        final int age = 50;

        final public void display(){
            System.out.println("Age: " + age);
        }
    }



    

public class Main{
    public static void main(String[] args){
        // Student[] students = new Student[3]; // object array 
        // students[0] = new Student(1, "Priya");
        // students[1] = new Student(2, "Rahul");
        // students[2] = new Student(1, "Aman");

        // for( Student s :students ){
        //     System.out.print(s.id +" "+ s.name + "\n");
        // }

        // Employee emp = new Employee();
        // emp.id = 101;
        // emp.name = "Priya";
        // emp.salary = 5000;

        // emp.display();

        // Rectangle rec = new Rectangle();
        // rec.length = 30;
        // rec.width = 30;
        // System.out.println("Area = " + rec.area());

        // StudentDetail st = new StudentDetail(104, "Priya", 70);
        // st.display();
        // st.calculateMarks();

        // Book b = new Book(120, "Little Prince", 540);
        // b.display();

        // Car c = new Car();
        // c.display();

        // BankAccount bank = new BankAccount(123456, "Priya", 500000);
        // bank.display();

    //     BankAccount1 bank1 = new BankAccount1();
    //     bank1.deposit(500);
    //     bank1.withdraw(307);
    //    System.out.println(bank1.getBalance());

    //    Student s1 = new Student();
    //    s1.setMarks(-4);
    //    System.out.println("Marks : " + s1.getMarks());
    //    s1.setMarks(80);
    //     System.out.println("Marks : " + s1.getMarks());

    // Employee emp = new Employee();
    // emp.setSalary(-3);
    // System.out.println("Salary : "  + emp.getSalary());
    // emp.setSalary(500);
    // System.out.println("Salary : "  + emp.getSalary());

    // Person p = new Person();
    // p.setAge(-2);
    // System.out.println("Age: " + p.getAge());
    // p.setAge(40);
    // System.out.println("Age: " + p.getAge());

   
    //  Counter c = new Counter();
    //  System.out.println(c.increment());
    //  System.out.print(c.increment());

    // Utilty u = new Utilty();
    // System.out.println("Square of a number : " + u.square(2));
    // System.out.println("Square of a number : " + u.square(5));

    // Employee emp = new Employee();
    // Employee emp2 = new Employee();
    // Employee emp3 = new Employee();

    // System.out.println("ID: " + emp.generateId());
    // System.out.println("ID: " + emp2.generateId());
    // System.out.println("ID: " + emp3.generateId());

    // BankAccount b1 = new BankAccount();
    // b1.display();

    Base b = new Base();
     Base b1 = new Base();

    b.display();
    b1.display();






    



    }
}