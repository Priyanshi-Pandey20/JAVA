import java.util.*;
import java.util.Arrays;

class Recursion {

    public static int fact(int n) {  //  O(n) - time compelexicity ,space complexicity
                                    
        if (n == 0) { // factorial of a no.
            return 1;
        }

        return n * fact(n - 1);

    }

    public static int sum(int n) { // sum of no.     O(n)-time and space 
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);

    }

    public static int fibbonaci(int n) { // fibbonaci series   2^n - time and O(n) - space
        if (n == 0) {
            return 0;

        }
        if (n == 1) {
            return 1;

        }
        int fibb1 = fibbonaci(n - 1);
        int fibb2 = fibbonaci(n - 2);
        int fibb = fibb1 + fibb2;
        return fibb;

    }

    public static boolean isSorted(int arr[], int i) { ///check if array is sorted or not
        if (i == arr.length - 1)
            return true;
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);

    }

    public static int FirstOccurance(int[] arr1, int key, int i) { // find first occurance in array
        if (i == arr1.length - 1) {
            return -1;
        }
        if (arr1[i] == key) {
            return i;
        }
        return FirstOccurance(arr1, key, i + 1);

    }

    public static int Tiling(int n) { // tiling problem
        if (n == 0 || n == 1) {
            return 1;
        }
        int vertical = Tiling(n - 1);
        int horizontal = Tiling(n - 2);

        int total = vertical + horizontal;
        return total;
    }

    public static void RemoveDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {// remove duplicates
        if (idx == str.length()) {
            System.err.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            RemoveDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            RemoveDuplicates(str, idx, newStr.append(currChar), map);
        }
    }

    public static int friendsPairing(int n) { // friends pairing problem
        if (n == 1 || n == 2) {
            return n;
        }
        int frn1 = friendsPairing(n - 1);
        int frn2 = friendsPairing(n - 1) * friendsPairing(n - 2);

        int totalways = frn1 + frn2;
        return totalways;
    }

    public static int powerOf(int a, int n) { // power of x^n   //O(n) - time and space
        if (n == 0) {
            return 1;
        }
        return a * powerOf(a, n - 1);
    }

    public static void TowerOfHanoi(int n, char A, char B, char C) { // tower  of hanaoi
        if (n == 0) {
            return;
        }
        TowerOfHanoi(n - 1, A, C, B);
        System.out.println("Move disk" + n + "from" + A + "to" + B);
        TowerOfHanoi(n - 1, B, A, C);
        System.out.println("Move disk" + n + "from" + B + "to" + C);
    }

    public static void BinaryString(int n, int lastidx, String str) { // print binary string 
        if (n == 0) {
            System.out.println(str);
            return;
        }
        BinaryString(n - 1, 0, str + "0");
        if (lastidx == 0) {
            BinaryString(n - 1, 1, str + "1");
        }

    }

    public static int StringLength(String str1, int idx) {// print length of string
        if (idx == str1.length()) {
            return -1;
        }

        return 1 + StringLength(str1, idx + 1);
    }

    public static void main(String[] args) {

        System.out.println(fact(7));
        System.out.println(sum(10));
        System.out.println(fibbonaci(7));
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(isSorted(arr, 0));


        int[] arr1 = { 1, 2, 9, 0, 5, 8, 5, 4 };
        System.out.println(FirstOccurance(arr1, 2, 0));


        System.out.println(Tiling(4));
        String str = "aabbccdd";
        RemoveDuplicates(str, 0, new StringBuilder(""), new boolean[26]);


        System.out.println(friendsPairing(3));
        TowerOfHanoi(3, 'A', 'B', 'C');


        BinaryString(4, 0, "");
        String str1 = "xxywsed";
        System.out.println(StringLength(str, 0));

    }
}