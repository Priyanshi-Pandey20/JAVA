import java.util.*;

public class Arrays {
    public static void main(String[] args) {
        // int[] numbers = new int[5]; // creates an array of size 5

        // // Assign values
        // numbers[0] = 10;
        // numbers[1] = 20;
        // numbers[2] = 30;
        // numbers[3] = 40;
        // numbers[4] = 50;

        // Print values
        // for (int i = 0; i < numbers.length; i++) {
        // System.out.println("Element at index " + i + ": " + numbers[i]);
        // }

        // int a = 123; // sum of digits
        // int original = a;
        // int sum = 0;

        // while (a > 0) {
        // int digit = a % 10;
        // sum = sum + digit;
        // a = a / 10;

        // }
        // System.out.println(sum);

        // Scanner scn = new Scanner(System.in);
        // System.out.println("Enter the size of array ");
        // int n = scn.nextInt();
        // int [] arr = new int[n];

       // calculate the maximum element in array

        // int max = arr[0];
        // System.out.println("Enter the elements of array");

        // for(int i = 0;i<n;i++){
        // arr[i] = scn.nextInt();
        // }

        // System.out.print("Your array max element is : ");
        // int i =0 ;
        // for(int j= 1;j<arr.length;j++){
        // if(arr[j]>max){
        // max= arr[j];

        // }
        
           // 2 sum 
        int[] arr = { 1, 2, 3, 4, 5 };
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

}
