import java.util.Arrays;

public class Arrays2 {
    public static void CompareTwoArray() {
        int[] a = { 1, 2, 3, 4, 5 }; // compare two array
        int[] b = { 1, 2, 3, 4, 5 };

        System.out.println(Arrays.equals(a, b));
    }

    public static void MergeTwoArray() {  // merge two array
        int[] s = { 2, 3 }; 
        int[] p = { 5, 4 };
        int[] merge = new int[s.length + p.length];
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            merge[index++] = s[i];
        }

        for (int j = 0; j < s.length; j++) {
            merge[index++] = p[j];
        }

        for (int num : merge) {
            System.out.print(num + " ");

        }
    }

    public static void isEqual(int[] arr2, int[] arr3) {  // check whether two arrays are equal or not
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
        int[] d = { 3, 6, 0, 1, 4 }; //  find common elements in two array
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
        int[] y = { 1, 2, 3, 2, 0 }; //  search unique element in two array
        int[] z = { 5, 9, 4, 1, 0 };
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
        int[] arr = { 1, 2, 3, 3, 4, 56, 67, 7, 8, 9 }; // print the prime no.in array
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

    public static void SortArrayInAsending(int[] arr1) {  // Sort an array in ascending  order

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

    public static void EvenOddSum(int[] arr) { //calculate even no. and odd no. sum 
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

    public static void main(String[] args) {
       
      
        CommonElementInArray();
        UniqueElement();
        CopyArrayToOther();
        CheckPrime();
       
        int[] arr1 = {5,4,3,2,1,0};
        SortArrayInAsending(arr1);

        int[] arr2 = {1,2,3,4,5};
        int[] arr3 ={3,5,6,7,0};

        isEqual(arr2, arr3);
    
  
    }
}
