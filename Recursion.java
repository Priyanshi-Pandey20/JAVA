import java.util.*;
class Recursion {

    public static int fact(int n) {
        if (n == 0) { // factorial of a no.
            return 1;
        }

        return n * fact(n - 1);

    }

    public static int sum(int n) { // sum of no.
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);

    }

    public static int fibbonaci(int n) { // fibbonaci series
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

    public static void RemoveDuplicates(String str, int idx,StringBuilder newStr,boolean map[]) {//remove duplicates
          if(idx==str.length()){
            System.err.println(newStr);
            return;
          }
          char currChar = str.charAt(idx);
          if(map[currChar-'a'] == true){
             RemoveDuplicates(str, idx+1, newStr, map);
          }
          else{
            map[currChar -'a']= true;
            RemoveDuplicates(str, idx, newStr.append(currChar), map);
          }
    }

    public static void main(String[] args) {

        System.out.println(fact(7));
        System.out.println(sum(10));
        System.out.println(fibbonaci(25));
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(isSorted(arr, 0));

        int[] arr1 = { 1, 2, 9, 0, 5, 8, 5, 4 };
        System.out.println(FirstOccurance(arr1, 2, 0));

        System.out.println(Tiling(4));
        String str = "aabbccdd";
        RemoveDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}