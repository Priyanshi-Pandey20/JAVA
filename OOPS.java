public class OOPS {
    public static void main(String [] args){
        // Pen p1 = new Pen(); //created a pen object
        // p1.setColor("Blue");
        // System.out.println(p1.color);
        // p1.setTip(5);
        // System.out.println(p1.tip);
        BankAccount myacc = new BankAccount();
        myacc.username = "priyanshi";
       myacc. setpassword("abcd");

    }
}

class BankAccount{
    public  String username;
    private String password;
    
    public void setpassword(String pwd){
        password = pwd;
    }


}
class Pen{
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }
    void setTip(int newTip){
        tip = newTip;


       

    }
}
