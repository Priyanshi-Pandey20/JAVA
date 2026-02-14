import java.util.*;

public class Arrays {
    public static void MergeTwoArray() { // merge two array without using extra space pblm 
        int[] s = { 2, 3, 0, 0 };
        int[] p = { 4, 5 };
        int m = 2;
        int n = p.length;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        for (; k >= 0; k--) {
            if (j < 0)
                break;
            if (i >= 0 && s[i] > p[j]) {
                s[k] = s[i];
                i--;
            } else {
                s[k] = p[j];
                j--;
            }
        }

        for (int num : s) {
            System.out.print(num + " ");

        }
    }

    public static void isEqual(int[] arr2, int[] arr3) { // check whether two arrays are equal or not pblm
        boolean isEqual = true;

        if (arr2.length != arr3.length) {
            isEqual = false;
        }
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr3.length; j++) {
                if (arr2[i] != arr3[j]) {
                    isEqual = false;
                    break;

                }
            }
        }

        System.out.println(isEqual);
    }

    public static void CommonElementInArray() {
        int[] d = { 3, 6, 0, 1, 4 }; // find common elements in two array
        int[] e = { 13, 6, 7, 9, 2 };
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < e.length; j++) {
                if (d[i] == e[j]) {
                    System.out.println(d[i]);
                    break;
                }

            }
        }
    }

    public static void UniqueElement() {
        int[] y = { 1, 2, 3, 2, 0 }; // search unique element in two array
        int[] z = { 5, 9, 3, 2, 0 };
        boolean found = false;
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < z.length; j++) {
                if (y[i] == z[j]) {
                    System.out.println(y[i]);
                    found = true;
                    break;
                }

                if (!found) {
                    System.out.println(z[j]);
                }

            }
        }
    }

    public static void CopyArrayToOther() {

        int[] o = { 1, 2, 3, 4, 5 }; // copy elements of one array into another
        int[] w = new int[5];

        for (int i = 0; i < o.length; i++) {
            w[i] = o[i];
        }

        for (int j = 0; j < w.length; j++) {
            System.out.print(w[j]);
        }
    }

    public static void CheckPrime() {
        int[] arr = { 1, 2, 3, 3, 4, 56, 67, 7, 8, 9 }; // print the prime no. 
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            for (int j = 2; j < n / 2; i++) {
                if (arr[i] % j == 0) {
                    System.out.println("not prime" + arr[i]);
                } else {
                    System.out.println("prime");
                }
            }

        }

    }

    public static void SortArrayInAsending(int[] arr1) { //sort 

        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] > arr1[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }

        }
        for (int j = 0; j < arr1.length; j++) {
            System.out.println(arr1[j]);
        }

    }

    public static void EvenOddSum(int[] arr) { // calculate even no. and odd no.sum
        int evensum = 0;
        int oddsum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evensum++;
            } else {

                oddsum++;
            }

        }
        System.out.println(evensum);
        System.out.println(oddsum);
    }

    public static void FindMaximum(int[] arr3) {// calculate the maximum element in array
        int max = arr3[0];
        for (int j = 1; j < arr3.length; j++) {
            if (arr3[j] > max) {
                max = arr3[j];

            }
        }
        System.out.println(max);
    }

    public static void TwoSum() { // two sum 
        int[] arr = { 1, 2, 3, 4, 5 }; //  2 sum pblm 
        int target = 5;
        boolean flag = false;
        int[] arr1 = { 0, 0, 0, 0, 0 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    arr1[0] = i;
                    arr1[1] = j;
                    flag = true;
                    System.out.println(arr1[0]);
                    System.out.println(arr1[1]);
                    break;
                }
            }
            if (flag == true) {

                break;
            }

        }
    }

    public static void SumOfTwoArray() { //  sum of two arrays 
        int[] x = { 1, 2, 3, 4, 5 };
        int[] y = { 1, 2, 3, 4, 5 };
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        for (int j = 0; j < y.length; j++) {

            sum = sum + y[j];

        }
        System.out.println(sum);
    }

    public static void SumOfDigits() { // sum of digits
        int a = 123;
        int original = a;
        int sum = 0;

        while (a > 0) {
            int digit = a % 10;
            sum = sum + digit;
            a = a / 10;

        }
        System.out.println(sum);
    }

    public static void KadanesAlgorithm(int[] nums) { // maximum subarray sum
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum = currSum + nums[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println("maximum subarray sum : " + maxSum);
    }

    public static void RearrangeArray(int[] arr) { // Move all negative numbers to beginning and positive to end
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int[] temp = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp[idx++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[idx++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
            System.out.print(arr[i] + " ");
        }
    }

    public static void Occurences(int[] arr) { // Count the number of occurrences of an element
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            boolean alreadyCounted = false;

            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    alreadyCounted = true;
                    break;
                }
            }
            if (alreadyCounted) {
                continue;
            }

            for (int j = i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            System.out.println(arr[i] + " ocuured " + count + " times ");
        }
    }

    public static void FindDuplicates(int[] arr) {// find duplicate element 
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] == arr[j]) {
                    System.out.println("duplicate element is : " + arr[j]);
                    break;
                }
            }

        }
    }

    public static int FindMissingElement(int[] arr) { // find the missing element 
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] != arr[i] + 1) {
                return arr[i] + 1;
            }
        }
        return -1;
    }

    

    public static void main(String[] args) {

        UniqueElement();
    }

   
}
