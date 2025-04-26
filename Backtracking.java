public class Backtracking {

    public static void changeArr(int[] arr, int i, int val) { // O(n) traverse the array andbacktrack it
        // base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        // recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2; // backtracking step
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void FindSubsets(String str, int i, String ans) {  // Find the  possible subsets of the string
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        FindSubsets(str, i + 1, ans + str.charAt(i));
        FindSubsets(str, i + 1, ans);
    }




    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
        String str = "abc";
        FindSubsets(str, 0, "");

    }
}
