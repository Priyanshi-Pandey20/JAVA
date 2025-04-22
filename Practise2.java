import java.util.*;

public class Practise2 {
    public static void SortArrayInAsending(int[] arr1){
      
               
        for (int i = 0; i < arr1.length ; i++) {
            for(int j=i+1;j<arr1.length;j++){
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
 public static void EvenOddSum(int[] arr){
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


    public static void isEqual(int[] arr2,int[] arr3){
          boolean isEqual = true;
        if(arr2.length!=arr3.length){
            isEqual = false;
        }
        for(int i =0;i<arr2.length;i++){
            for(int j = 0 ;j<arr3.length;j++){
                if(arr2[i]!=arr3[j]){
                  isEqual = false;
                  break;
                    
                }
            }
        }

      System.out.println(isEqual);
    }
    public static void main(Demo args[]) {
       
         int[] arr1 = {5,4,3,2,1,0};
          SortArrayInAsending(arr1);

          int[] arr2 = {1,2,3,4,5};
          int[] arr3 ={3,5,6,7,0};

          isEqual(arr2, arr3);
    
            
                
            }
        }
        
    
    

