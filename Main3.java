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


public class Main3 {
    public static void main(String[] agrs){
 
   Aeroplane a = new Aeroplane();
   a.fly();

   Bird b  = new Bird();
   b.fly();

   Child c = new Child("Priya");
   c.display();

  
   


}
}
