import java.util.ArrayList;

class Book{
    int id;
    String title;
    String author;
    boolean available ;

    Book(int id,String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }
}
class Member{
    int id;
    String name;

    Member(int id, String name){
        this.id = id;
        this.name = name;
    }
}

class Library{
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member>member = new ArrayList<>();

    void addBook(Book book){
        books.add(book);
    }

    void searchBook(String title){
        for(Book book:books){
            if(book.title.equalsIgnoreCase(title)){
            if(book.available){
                System.out.println("Book is available : " +book.title);
            }else{
                 System.out.println("Book is not available");
            }
        }
    }
       
    }

    void borrowBook(String title){
        for(Book book : books){
            if(book.title.equalsIgnoreCase(title)){
                if(book.available){
                    book.available = false;
                    System.out.println("Borrowed book : "+ book.title);
                    
                }
                else{
                    System.out.println("Book can't be borrowed");
                }
            }
            return;
        }
        System.out.println("Book not found");
    }

    void returnBook(String title){

        for(Book book:books){
            if(book.title.equalsIgnoreCase(title)){
                book.available = true;
                System.out.println("Returned book : "+ book.title);
            }
        }


    }

    void displayDetail(){
        System.out.println("Available Books: ");

        for(Book book :books){
            if(book.available){
                System.out.println(book.title + " "+ book.id);
            }
        }
    }
}

class Vehicle{
    String number;

    Vehicle(String number){
        this.number = number;
    }
}
class Car extends Vehicle{

    Car(String number){
        super(number);
    }
}
class Bike extends Vehicle{

    Bike(String number){
        super(number);
    }
}

class Truck extends Vehicle{
    Truck(String number){
        super(number);
    }
}

class ParkingSpot{
    int id;
    Vehicle vehicle;

    ParkingSpot(int id){
        this.id = id;
        this.vehicle = null;
    }

    boolean isAvailable(){
        return vehicle == null;
    }

    void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    void removeVehicle(){
        this.vehicle = null;
    }
}

class ParkingLot{
  ArrayList<ParkingSpot> spots = new ArrayList<>();

  void addSpot(ParkingSpot spot){
    spots.add(spot);
  }

  void parkVehicle(Vehicle vehicle){
    for(ParkingSpot spot: spots){
        if(spot.isAvailable()){
           spot.parkVehicle(vehicle);
           System.out.println(spot.id + " " + vehicle.number);
           return ;
        }

    }
    System.out.println("Spot is not available");
  }

  void removeVehicle(String number){
    for(ParkingSpot spot  :spots){
        if(!spot.isAvailable()){
            if(spot.vehicle.number.equals(number)){
                spot.removeVehicle();
                System.out.println("Spot id : " + spot.id);
                return;
            }
        }
    }
    System.out.println("Vehicle not found");
  }

  void display(){
    System.out.println("Parking lot");

    for(ParkingSpot spot : spots){
        if(spot.isAvailable()){
            System.out.println("Spot is Empty" );
        }
        else{
            System.out.println(spot.id + " " + spot.vehicle.number);
        }

    }

}
}

public class Main5 {
    public static void main(String[] args){

        // Library library = new Library();
        // Book b1 = new Book(101,"Java","James" );
        // Book b2 = new Book(102,"DSA","George" );

        // library.addBook(b1); 
        // library.addBook(b2);

        // library.displayDetail();
        // library.searchBook("Java");
        // library.borrowBook("Java");
        // library.displayDetail();
        // library.returnBook("Java");
        // library.displayDetail();

        ParkingLot lot = new ParkingLot();
        lot.addSpot(new ParkingSpot(1));
        lot.addSpot(new ParkingSpot(2));
        lot.addSpot(new ParkingSpot(3));

        Car c = new Car("ab123");
        Bike b = new Bike("cd456");
        Truck t = new Truck("ef789");

        lot.parkVehicle(c);
        lot.parkVehicle(b);
        lot.parkVehicle(t);

        lot.display();
        lot.removeVehicle("ab123");
        lot.display();
    


        

    }
}
