class Employee{ // single level Inheritance
    void work(){
        System.out.println("Employee is working");
    }
}

class Manager extends Employee{
    void attendMeeting(){
        System.out.println("Manager is attending a meeting");
    }
}

class Person{  //mutlilevel inheritance
    void displayName(){
        System.out.println("tina");
    }
}

class Student extends Person{
    void displayClass(){
        System.out.println("Class : 12th");
    }
}

class Moniter extends Student{
    void checkdispline(){
        System.out.println("Moniter is checking discipline");
    }
}

class Shape{
    void draw(){
        System.out.println("Drawing a circle");
    }
}
class Circle extends Shape{
    void calculatearea(){
        System.out.println("Area of circle ");
    }
}

class Device{
    void powerOn(){
        System.out.println("system is on");
    }
}

class Laptop extends Device{
    void boot(){
        System.out.println("Laptop is booting");
    }
}
 class GamingLaptop extends Laptop {
    void startGame(){
        System.out.println("Game is starting");
    }
 }

 class Book{
    void read(){
        System.out.println("Reading a book");
    }
 }
 class Novel extends Book{
    void StoryLine(){
        System.out.println("The novel has intresting story");
    }
 }



public class Inheritance {

    public static void main(String[] args){
        // Manager m = new Manager();
        // m.work();
        // m.attendMeeting();

        // Moniter mon = new Moniter();
        // mon.displayName();
        // mon.displayClass();
        // mon.checkdispline();

        // Circle c = new Circle();
        // c.draw();
        // c.calculatearea();
         
        // GamingLaptop g = new GamingLaptop();
        // g.powerOn();
        // g.boot();
        // g.startGame();

        Novel  n = new Novel();
        n.read();
        n.StoryLine();

    }
}
