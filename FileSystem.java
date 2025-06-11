import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileSystem {
    public static void main(String[] args) {
           try {
            File file = new File("nex.txt");
            if (file.createNewFile()) {
                System.out.println("File created : " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        try {
            File file = new File("nex.txt");
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello this is a test msg");
            writer.close();

            System.out.println("Sucessfully written to the file");
        } catch (Exception e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        try {
            File file = new File("example.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occured");
            e.printStackTrace();

        }

       
            File file = new File("example.txt");
            if(file.delete()){
                System.out.println("Deleted the file" + file.getName());
            }
            else{
                System.out.println("failed to delete the file");
            
        }
    }
}
