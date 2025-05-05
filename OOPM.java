
    class Student{
        String firstname ;
        int rollnumber;
        int marks;
        void display(String firstname ,int rollnumber,int marks){
            System.out.println(firstname);
            System.out.println(marks);
            System.out.println(rollnumber);
        }

    }
    class Rectangle{
       int length = 2;
       int width = 4;
       void Area(){
        System.out.println(length*width);
       }
    }

    class Car{
        String model;
        String brand;
        int price;

        void Model( String model){
            System.out.println(model);
        }
        void Brand( String brand){
            System.out.println(brand);
        }
        void Price( int price){
            System.out.println(price);
        }


    }

    class BankAccount{
        int accountNumber = 123456;
        String accountHolder = "rita";
        int balance = 3000;

        void displaydetail(){
            System.out.println(accountHolder);
            System.out.println(accountNumber);
            System.out.println(balance);
        }

        void deposit (int amount){
             balance = balance + amount;
            System.out.println("Total amount after deposit :");
            System.out.println(balance);
        }
        void withdrawl(int amount){
          balance = balance - amount;
         System.out.println("Total balance afterwithdraw :");
         System.out.println(balance);
        }

    }

          class Circle{
            int radius;
            void Area(int radius){
                System.out.println(3.14*radius*radius);
            }
            void Circumference(int radius){
                System.out.println(2*3.14*radius*radius);
            }
          }
           
          class Book {
            String title;
            String author;
            int price;

            void Discount(int price){
              price = price -10%price;
              System.out.println(price);
            }
          }

        public class OOPM{

        
    public static void main(String[] args){
        Student obj = new Student();
        Student obj1 = new Student();
        Student obj2 = new Student();

        obj.display("rahul",123,80);
        obj1.display("tina",345,60 );
        obj2.display("rohit",987,50);
        
         
        Rectangle r = new Rectangle();
        r.Area();

        Car c = new Car();
        c .Model("BMW");
        c.Brand("Hero");
        c.Price(3);


        BankAccount ba = new BankAccount();
        ba.displaydetail();
        ba.deposit(1500);
        ba.withdrawl(50);
        
        Circle ci = new Circle();
        ci.Area(4);
        ci.Circumference(5);
        Book b = new Book();
        b.Discount(250);


    }
}
    
