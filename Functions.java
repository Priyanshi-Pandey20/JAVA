
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

    public static int SmallestNo(int[] arr) { // print smallest no.in array
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
        System.out.println(largest); // finding largest no.in array

        int sum = 0;
        for (int j = 1; j <= largest; j++) {
            sum += j;
        }
        System.out.println(sum);//calcute sum till largest

        int sum2 = 0;
        for (int k = 0; k < arr3.length; k++) {
            sum2 += arr3[k];
        }
        System.out.println(sum2);//calculate sum of elements in array

        int output = sum - sum2;
        System.out.println(output);// difference of both the sum

    }

    public static void main(String[] args) {

        System.out.println(sum(202, 7));
        System.out.println(a); // Static Variable
        print(a); // Non static

        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(SmallestNo(arr));

        int[] arr1 = { 1, 2, 3, 4, 5 };
        printCopies(arr1);

        int[] arr3 = { 1, 2, 3, 5, 6 };
        FindMissing(arr3);

    }
}
