import java.util.*;

public class Practise1 {
    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your input : ");

        int n = scn. nextInt();

        if(n%2==0)                        //Q1
        System.out.println("Even");
        else{
        System.out.println("Odd");
        }

        if(n>0){                           //Q2
        System.out.println("Positive");
        }
        else if(n<0){
        System.out.println("Negative");
        }
        else{
        System.out.println("zero");
        }

        int a = scn.nextInt();             //Q3
        int b = scn.nextInt();
        if(a>b){
        System.out.println("1st no. is greater than 2nd : " + a);
        }
        else{
        System.out.println("2nd no. is greater than 1st : "+ b);
        }

        char c = scn.next().charAt(0);      //Q4
        switch(c){
        case 'a' :
        case 'e' :
        case 'i' :
        case 'o' :
        case 'u' :
        System.out.println("Vowel");
        break;
        case 'A' :
        case 'E' :
        case 'I' :
        case 'O' :
        case 'U' :
        System.out.println("Vowel");
        break;
        default:System.out.println("Consonet");

        int m = scn.nextInt();             //Q5
        for(int i=0 ; i<=m;i++){
        System.out.println(i);
        }
        System.out.println();

        int p= scn.nextInt();
        int sum = 0;              //Q6
        for(int i=0 ; i<=p;i++){
        sum = sum +i;
        }
        System.out.println(sum);




        int f = scn .nextInt();            //Q7
        for(int i=1;i<=10;i++){
            int table = i*f;
            System.out.println(table);
        }
         
 
        int k = scn .nextInt();               //Q8
                                             
        if(k%5 == 0 && k%11 == 0){
            System.out.println("It is divisible by 5 and 11");
        }
        else{
            System.out.println("Not divisible");
        }
         

        int q = scn.nextInt();                     //Q9
        if(q%3 == 0){
            System.out.println("It is divisible by 3");
        }
        else{
            System.out.println("It is not divisible by 3");
        }

        
        int l = scn.nextInt();                        //Q10
        int fact = 1;
        for(int i = 1 ;i<=l;i++){
            fact =fact * i ;
        }
        System.out.println(fact);
                
      
        int y = scn.nextInt();             //Q11
        int i = 2;
        boolean isPrime = true;

        while(i< y){
            if(y%i==0){
                isPrime = false;
                break;
            }
            i++;
        }
         

        if(y<=1)                         //Q12
        isPrime = false;

        if(isPrime){
            System.out.println("Prime no.");
        }
        else{
            System.out.println("Not a prime no.");
        }

      }
     }
    }



