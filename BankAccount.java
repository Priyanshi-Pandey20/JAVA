import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.io.File;
import java.io.IOException;

class Transcation { // transcation class 
    String type;
    double amount;

    Transcation(String type, double amount) { // transcation function 
        this.type = type;
        this.amount = amount;
    }

}

class Account {// account function 
    private String name;
    private int accountNumber;
    private double balance;

    public Account(String name, int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    ArrayList<Transcation> transcations = new ArrayList<>();

    public void deposit(double amount) { // deposit function 
        if (amount > 0) {
            balance += amount;
            transcations.add(new Transcation("Deposit", amount));
            System.out.println("Deposit successfully!");
        }
    }

    public void withdraw(double amount) { //withdraw function 
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transcations.add(new Transcation("withdrawal ", amount));
            System.out.println("withdrawal successfully!");

        } else {
            System.out.println("Insufficient amount");
        }

    }

    public void viewTranscation() {
        if (transcations.isEmpty()) {
            System.out.println("No transcation record");
        } else {
            System.out.print("Transcation history ");
            for (Transcation t : transcations) {
                System.out.println(t.amount);
            }
        }
    }

    public void saveAccount() {
        try {

          File file = new File("account.txt");
          if(file.createNewFile()){
            System.out.println("Fle 'account.txt' created");
          }

            FileWriter writer = new FileWriter(file,true);
            writer.write("Account Holder: " + name + "\n");
            writer.write("Account Number: " + accountNumber + "\n");
            writer.write("Balance: " + balance + "\n");
            writer.close();
            System.out.println("Account details saved to file.");
            System.out.println("-------------------------------------------");

        } catch (IOException e) {
            System.out.println("error is occured while writing in file");
            e.printStackTrace();
        }

    }

    public void saveTranscationHistory() { // save transcation history   
        try {
            FileWriter writer = new FileWriter("transaction_history.txt");
            for (Transcation t : transcations) {
                writer.write(t.type + ": " + t.amount + "\n");
            }
            writer.close();
            System.out.println("Transaction history saved to file.");
            System.out.println("--------------------------------------------");
        } catch (IOException e) {
            System.out.println("An error occurred while writing transaction history.");
            e.printStackTrace();
        }

    }

    public void checkBalance() {//check balance 
        System.out.println("Your account balance : " + balance);
    }

}

public class BankAccount {// Bank Account class 
    static Scanner sc = new Scanner(System.in);
    static Account account;

    public static void main(String[] args) {

        System.out.println("---Banking System---");
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        account = new Account(name, 47654, 0);
        System.out.println(" Account created successfully .Account number :");

        int choice;
        do {
            System.out.println("\n1. Deposit\n2.Withdraw\n3.CheckBalance\n4.View Transcations\n5.Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount : ");
                    long startdep = System.currentTimeMillis();
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    long enddep = System.currentTimeMillis();
                    System.out.println("Deposit time : " + (enddep - startdep) + " ms");

                    break;

                case 2:
                    System.out.print("Enter amount to withdraw : ");
                    long startwith = System.currentTimeMillis();
                    double with = sc.nextDouble();
                    account.withdraw(with);
                    long endwith = System.currentTimeMillis();
                    System.out.println("Withdrawal time : " + (endwith - startwith) + " ms");
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.viewTranscation();
                    break;


                case 5:
                    System.out.println("Thank you for using Bank app");
                    account.saveAccount();
                    account.saveTranscationHistory();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}
