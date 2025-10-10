import java.util.*;

public class Practise1 {
    public static void main(Demo args[]) {

        Scanner scn = new Scanner(System.in); // take the input pblm 
        System.out.println("Enter your input : ");

        int n = scn.nextInt();

        if (n % 2 == 0) // Q1
            System.out.println("Even");
        else {
            System.out.println("Odd");
        }

        if (n > 0) { // Q2 check positive negative pblm
            System.out.println("Positive");
        } else if (n < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("zero");
        }
  
        int a = scn.nextInt(); // Q3 check the no.is greater or not 
        int b = scn.nextInt();
        if (a > b) {
            System.out.println("1st no. is greater than 2nd : " + a);
        } else {
            System.out.println("2nd no. is greater than 1st : " + b);
        }

        char c = scn.next().charAt(0); // Q4  // vowel consonent 
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("Vowel");
                break;
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                System.out.println("Vowel");
                break;
            default:
                System.out.println("Consonet");

                int m = scn.nextInt(); // Q5 print no. 
                for (int i = 0; i <= m; i++) {
                    System.out.println(i);
                }
                System.out.println();

                int p = scn.nextInt();
                int sum = 0; // Q6  print the sum of n no. 
                for (int i = 0; i <= p; i++) {
                    sum = sum + i;
                }
                System.out.println(sum);

                int f = scn.nextInt(); // Q7 print the table of given no. 
                for (int i = 1; i <= 10; i++) {
                    int table = i * f;
                    System.out.println(table);
                }

                int k = scn.nextInt(); // Q8 // check whether the given  no. is divisble or not 

                if (k % 5 == 0 && k % 11 == 0) {
                    System.out.println("It is divisible by 5 and 11");
                } else {
                    System.out.println("Not divisible");
                }

                int q = scn.nextInt(); // Q9 
                if (q % 3 == 0) {
                    System.out.println("It is divisible by 3");
                } else {
                    System.out.println("It is not divisible by 3");
                }

                int l = scn.nextInt(); // Q10
                int fact = 1;
                for (int i = 1; i <= l; i++) {
                    fact = fact * i;
                }
                System.out.println(fact);

                int y = scn.nextInt(); // Q11
                int i = 2;
                boolean isPrime = true;

                while (i < y) {
                    if (y % i == 0) {
                        isPrime = false;
                        break;
                    }
                    i++;
                }

                if (y <= 1) // Q12
                    isPrime = false;

                if (isPrime) {
                    System.out.println("Prime no.");
                } else {
                    System.out.println("Not a prime no.");
                }

                int w = scn.nextInt(); // Q13

                switch (w) {
                    case 1:
                        System.out.println("one");
                        break;
                    case 2:
                        System.out.println("two");
                        break;
                    case 3:
                        System.out.println("three");
                        break;
                    case 4:
                        System.out.println("four");
                        break;
                    case 5:
                        System.out.println("five");
                        break;
                    case 6:
                        System.out.println("six");
                        break;
                    case 7:
                        System.out.println("seven");
                        break;
                    case 8:
                        System.out.println("eight");
                        break;
                    case 9:
                        System.out.println("nine");
                        break;
                    case 10:
                        System.out.println("ten");
                        break;
                    default:
                        System.out.println("invalid input");

                }

        }
    }
}
