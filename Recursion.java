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


    public static void main(String[] args) {

        System.out.println(fact(7));
        System.out.println(sum(10));
        System.out.println(fibbonaci(25));
        int arr[] = {1,2,3,4,5};
        System.out.println(isSorted(arr ,0));
    }
}