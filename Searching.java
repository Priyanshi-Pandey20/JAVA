 import java .util.*;
 import java .util.Arrays;
    public class Searching {
        public static int linearSearch(int[] numbers, int key) {   // O(n) - time complexicity
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == key) {
                    return i; 
                }
            }
            return -1; 
        }

    public static int BinarySearch(int[] arr,int key){  // O(log n) - time complexicity 
        int start = 0; 
        int end = arr.length-1;

        while (start<=end){
            int mid = (end + start)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] <key){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
     
    
    public static void main(String[] args) {
        int[] numbers = {10,20,30,40,50};
        int key = 30;

        int result = linearSearch(numbers, key);
      // int result = BinarySearch(numbers, key);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }

    

    }

    }

   