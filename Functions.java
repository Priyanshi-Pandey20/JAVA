import java.util.*;

public class Functions {
    public static int sum(int a, int b) { // print the sum of digits

        int sum = a + b;
        System.out.println(sum);

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < sum; i++) {
            int c = sum % 10;
            if (largest < c) {
                largest = c;
            }
            sum = sum / 10;
        }

        return largest;

    }

    public static void print(int a) {
        a = 12;
        System.out.println(a);
    }

    static int a = 12;

    public static int SmallestNo(int[] arr) { // print smallest no in array 
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void printCopies(int[] arr1) { // copy one array to other
        int[] arr2 = new int[5];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }

        for (int j = 0; j < arr2.length; j++) {
            System.out.println(arr2[j]);
        }
    }

    public static void FindMissing(int[] arr3) {// print the missing term in array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] > largest) {
                largest = arr3[i];
            }
        }
        System.out.println(largest);

        int sum = 0;
        for (int j = 1; j <= largest; j++) {
            sum += j;
        }
        System.out.println(sum);
        int sum2 = 0;
        for (int k = 0; k < arr3.length; k++) {
            sum2 += arr3[k];
        }
        System.out.println(sum2);

        int output = sum - sum2;
        System.out.println(output);

    }

    public static void NaturalNo(int n) { // print natural no. 
        for (int i = 0; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void ReverseNaturalNo(int n) { // reverse natural no.
        for (int i = n; i >= 0; i--) {
            System.out.print(i);
        }
    }

    public static void PrintEvenNo(int n) { // print even no. 
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.println("even no." + i);
            }

        }
    }

    public static void SumOfNaturalNo(int n) { // print sum of natural no.
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;

        }
        System.out.println(sum);
    }

    public static void ProductOfNaturalNo(int n) { // print product of natural no.
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        System.out.println(product);
    }

    public static void printNumber(int n) { // print numbers 
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

    public static void SumOfDigits(int n) { // sum od digits 
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println(sum);
    }

    public static void CountAllDigits(int n) { // count all digits 
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;

        }
        System.out.println(count);
    }

    public static void PrintReverseNo(int n) { // print reverse no. 
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        System.out.println(rev);
    }

    public static void Palindrome(int n) {// palindrome
        int original = n;
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        if (original == rev) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }

    }

    public static void PrintPrimeNoAlternatively() { // print prime no alternatively  pblm 
        int count = 0;
        for (int n = 2; n <= 100; n++) {
            boolean isPrime = true;
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                count++;
                if (count % 2 != 0) {
                    System.out.println(n);
                }
            }

        }

    }

    public static void PrintPrimeNoInRange(int st, int end) { // print prime no in range 
        for (int n = st; n <= end; n++) {
            boolean isPrime = true;
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                System.out.println(n);
            }

        }
    }

    public static int Fibbonacci(int n) { // fibbonacci pblm
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fb1 = Fibbonacci(n - 1);
        int fb2 = Fibbonacci(n - 2);
        int fb = fb1 + fb2;
        return fb;
    }

    public static void SortString(String[] str) { // sort strings in ascending order 

        for (int i = 0; i < str.length - 1; i++) {
            for (int j = 0; j < str.length - i - 1; j++) {
                if ((int) str[j].charAt(0) > (int) str[j + 1].charAt(0)) {
                    String temp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = temp;
                }

            }
        }
        for (String c : str) {
            System.out.println(c);
        }

    }

    public static void ConvertStringToSmall(String[] str) { // convert string to small pblm  

        for (int i = 0; i < str.length; i++) {
            String small = "";
            for (int j = 0; j < str[i].length(); j++) {
                char ch = str[i].charAt(j);
                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch + 32);
                }
                small += ch;
            }
            str[i] = small;
        }
        for (String s : str) {
            System.out.println(s);
        }
    }
        public static void AlternatingPositiveNegative(int[] arr) { // alternating postive negative elements
        int n = arr.length;
        int[] temp = new int[n];
        int postIdx = 0;
        int negIdx = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                if (postIdx < n) {
                    temp[postIdx] = arr[i];
                    postIdx += 2;
                }
            } else {
                if (negIdx < n) {
                    temp[negIdx] = arr[i];
                    negIdx += 2;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(temp[i] + " ");
        }

    }


    

    public static void main(String[] args) {

        System.out.println(sum(202, 7));
        System.out.println(a); // Static Variable
        print(a); // Non static

        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(SmallestNo(arr));

        int[] arr1 = { 1, 2, 3, 4, 5 };

        printCopies(arr1);

        String[] str = { "B", "A", "C" };
        SortString(str);
        ConvertStringToSmall(str);

    }
}
