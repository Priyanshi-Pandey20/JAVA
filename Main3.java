import java.util.*;

abstract class Payment{
   abstract void pay();
}
class UPIPayment extends Payment{
    @Override
    public void pay(){
        System.out.println("UPI Payment....");
    }
}

class Cash extends Payment{
    @Override
    public void pay(){
        System.out.println("Cash Payment....");
    }
}

abstract class BankAccount{
     int balance;
     abstract void withdrawal(int amount);
}

class Saving extends BankAccount{
    @Override

    void withdrawal(int amount){
        balance += amount;
        System.out.println(balance);
    }
}
class Current extends BankAccount{
    @Override

    void withdrawal(int amount){
        balance-=amount;
        System.out.println(balance);
    }
}

interface Person{
    void display();
}
interface Human{
    void print();
}
class Personality implements Person,Human{
    @Override

   public void display(){
        System.out.println("Person");
    }

   public void print(){
    System.out.println("Human");

    }
}

interface Flyable{
    void fly();
}

class Bird implements Flyable{
    @Override
   public void fly(){
    System.out.println("Bird flys");
   }
}
class Aeroplane implements Flyable{
    @Override
    public void fly(){
        System.out.println("Aeroplane flys");
    }
}

class Parent{
    String name;
}

class Child extends Parent{
   String name;
    Child(String name){
        this.name = name;
        super.name = name;
    }
    void display(){
        System.out.println(super.name + " " + name);
    }
    
}

class Address{
    void display(){
        System.out.println("Address...");
    }
}

// class Student{
//     Address a = new Address();
//     void print(){
//         a.display();
//         System.out.println("Student address");
//     }
// }

class Product{
    String name;

    Product(String name){
        this.name = name;
    }
}

class Order{
    List<Product>products = new ArrayList<>();

    void addProduct(Product product){
        products.add(product);
    }

    void display(){
        for(Product p :products){
            System.out.println(p.name);
        }
    }
}

// class Student {
//     String name;
//     int marks;

//     Student(String name,int marks){
//         this.name = name;
//         this.marks = marks;
//     }
// }


// class Employee{
//     String name;
//     int id;

//     Employee(String name, int id){
//         this.id = id;
//         this.name = name;
//     }
// // }

// class Employee{
//     String name;
//     int id;

//     Employee(int id, String name){
//         this.id = id;
//         this.name = name;
//     }
// }

class Student{
    String name;
    int id;

    Student(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        Student s = (Student) obj;
        return this.id == s.id;
    }

    @Override
    public int hashCode(){
        return id;
    }

    void display(){
        System.out.println(id + " " + name);
    }

}

class Employee{
    int salary;
    String name;

    void display(){
        System.out.println("Empolyee name: " + name);
        System.out.println("Empolyee salary: " + salary);

    }
}

class Developer extends Employee{
      void display(){
        System.out.println("Developer name: " + name);
        System.out.println("Developer salary: " + salary);

    }

    void develop(){
        System.out.println("Writing code....");
    }

}
class Manager extends Employee{
        void display(){
        System.out.println("Manager name: " + name);
        System.out.println("Manager salary: " + salary);

    }
    void manage(){
        System.out.println("Managing task...");
    }
}

class Tester extends Employee{
      void display(){
        System.out.println("Tester name: " + name);
        System.out.println("Tester salary: " + salary);

    }
    void test(){
        System.out.println("Testing code....");
    }
}


public class Main3 {
    public static void main(String[] agrs){
 
    // ArrayList<Student> student = new ArrayList<>();

    // student.add(new Student("Priya", 90));
    // student.add(new Student("Rahul", 68));
    // student.add(new Student("Govind", 87));

    // Student hightest = student.get(0);

    // for (Student s : student){
    //     if(s.marks > hightest.marks){
    //         hightest = s;
    //     }
    // }

    // System.out.println(hightest.marks);
    // System.out.println(hightest.name);

    //  Order o = new Order();
    // o.addProduct(new Product("Laptop"));
    // o.addProduct(new Product("TV"));
    // o.addProduct(new Product("Washing Machine"));

    // o.display();


    // ArrayList<Employee> emp = new ArrayList<>();
    // emp.add(new Employee("Priya", 102));
    // emp.add(new Employee("Rohan", 103));
    // emp.add(new Employee("Diya", 104));

    // int searchId = 102;

    // for(Employee e : emp){
    //     if(e.id == searchId){
    //         System.out.println("Search id : "+ e.id);
    //         System.out.println("Search name : " + e.name);


    //     }
    // // }
    // HashMap<Integer,Employee> map = new HashMap<>();
    // map.put(101,new Employee(101,"Priya"));
    // map.put(102,new Employee( 102,"Priyanshi"));

    // Employee e = map.get(101);
    // System.out.println(e.name);

    HashSet<Student> s = new HashSet<>();
    s.add(new Student(101, "Priya"));
    s.add(new Student(102, "Rohan"));
    s.add(new Student(103, "Diya"));
    s.add(new Student(102, "Seema"));

    for(Student student : s){
        student.display();
    }

//     ArrayList<Employee> emp = new ArrayList<>();
//    emp.add(new Employee(70000));
//    emp.add(new Employee(42000));
//    emp.add(new Employee(790000));
//    Collections.sort(emp,(e1,e2)-> Integer.compare(e1.salary, e2.salary));

//    for(Employee e : emp){
//     System.out.println(e.salary);
//    }

Developer d = new Developer();
d.salary = 30000;
d.name = "Priya";
d.display();
d.develop();

Manager m = new Manager();
m.name = "Rohan";
m.salary = 90000;
m.display();
m.manage();

Tester t = new Tester();
t.name = "Hina";
t.salary = 28000;
t.display();

t.test();

    

    



    

    



  


   


}
}
