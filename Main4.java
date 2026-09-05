class BankAccount{
    int accountNo;
    int balance;

    BankAccount(int accountNo, int balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    void withdrawal(int amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal money : " + balance);
        }
        else{
             System.out.println("Insufficient Balance");
        }
    }

    void checkBalance(){
        System.out.println("Balance : " + balance);
    }
}

class SavingAccount extends BankAccount{

    SavingAccount(int accountNo, int balance){
        super(accountNo, balance);
    }
    @Override
   public void withdrawal(int amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal money from saving acc: " + balance);
        }

    }
}

class CurrentAccount extends BankAccount{

    CurrentAccount(int accountNo, int balance){
         super(accountNo, balance);
    }

    @Override
    public void withdrawal(int amount){
         if(amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal money from saving acc: " + balance);
        }
    }
    
}




public class Main4 {

    public static void main(String[] args){
        SavingAccount s = new SavingAccount(101, 3000);
        s.withdrawal(2000);
        s.checkBalance();

        CurrentAccount c  = new CurrentAccount(102, 70000);
        s.withdrawal(4000);
        

    }
    
}
