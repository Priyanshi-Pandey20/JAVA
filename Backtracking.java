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

    public static void FindSubsets(String str, int i, String ans) { // Find the possible subsets of the string
        if (i == str.length()) { // O(2^n *n) time and O(n) space
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

    public static void PermutationsOfString(String str, String ans) {// find all the permutations of a string
        if (str.length() == 0) { // O(n*n!) -time
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i + 1);
            PermutationsOfString(Newstr, ans + curr);
        }
    }

    public static boolean isSafe(char board[][],int row,int col){
        for(int i = row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        
        for(int i = row-1,j = col-1;i >=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void NQueen(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            return;

        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                NQueen(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("---------chess board-----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
        String str = "abc";
        // FindSubsets(str, 0, "");
        PermutationsOfString(str, "");
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        NQueen(board, 0);

    }
}
