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



public class Main5 {
    public static void main(String[] args){

        Library library = new Library();
        Book b1 = new Book(101,"Java","James" );
        Book b2 = new Book(102,"DSA","George" );

        library.addBook(b1);
        library.addBook(b2);

        library.displayDetail();
        library.searchBook("Java");
        library.borrowBook("Java");
        library.displayDetail();
        library.returnBook("Java");
        library.displayDetail();
        

    }
}
