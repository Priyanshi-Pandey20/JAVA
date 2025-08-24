import java.util.*;

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

    public static boolean isSafe(char board[][], int row, int col) { // N Queen Problem
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
                
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
  
    public static boolean NQueen(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            count++;
            return true;

        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (NQueen(board, row + 1)) {
                    return true;
                }
                NQueen(board, row + 1);
                board[row][j] = '.';

            }
        }
        return false;
    }

    public static void printBoard(char board[][]) { // print the board
        System.out.println("---------chess board-----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static int gridWays(int i, int j, int n, int m) { // O(2^n+m)
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) { // Sudoku Problem
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] sudoku, int row, int col) { 

        if (row == 9 && col == 0) {
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) { // corrected here (1 to 9)
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (solveSudoku(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    public static void printSudoku(int[][] sudoku) { // sudoku board print 
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printSolution(int sol[][]) { // rat in a maze pblm 
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    public static boolean solveMaze(int[][] maze) {
        int N = maze.length;
        int[][] sol = new int[N][N];
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("sol doesn't exsits");
            return false;
        }
        printSolution(sol);
        return true;
    }

    public static boolean solveMazeUtil(int[][] maze, int x, int y, int sol[][]) {
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y) == true) {
            if (sol[x][y] == 1)
                return false;
            sol[x][y] = 1;

            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            sol[x][y] = 0;
            return false;

        }
        return false;
    }

    // keypad combinations 

    final static char[][] L = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public static void letterCombinations(String D) {
        int len = D.length();
        if (len == 0) {
            System.out.println("");
            return;
        }
        bfs(0, len, new StringBuilder(), D);
    }

    public static void bfs(int pos, int len, StringBuilder sb, String D) { // bfs pblm
        if (pos == len) {
            System.out.println(sb.toString());
        } else {
            char[] letters = L[Character.getNumericValue(D.charAt(pos))];
            for (int i = 0; i < letters.length; i++) {
                bfs(pos + 1, len, new StringBuilder(sb).append(letters[i]), D);
            }
        }
    }

    static int N = 8;

    public static boolean IsSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    public static void printKnightSolution(int[][] sol) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.println(sol[x][y] + " ");
                System.out.println();
            }
        }
    }

    public static boolean solveKT() { // solve kt 
        int[][] sol = new int[8][8];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

        sol[0][0] = 1;

        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("solution does not exists");
        } 
        else 
            printSolution(sol);
            return true;
        
        

    }

    public static boolean solveKTUtil(int x, int y, int movei, int sol[][], int[] xMove, int[] yMove) { // solve kt util
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
           if( IsSafe(next_x,next_y ,sol)){
            sol[next_x][next_y] = movei;
            if(solveKTUtil(next_x, next_y, movei +1, sol, xMove, yMove))
            return true;
            else
            sol[next_x][next_y] =-1;
           }

        }
        return false;
    }

    public static void main(String[] args) {
        // int n = 4;
        // char board[][] = new char[n][n];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // board[i][j] = '.';
        // }
        // }
        // if( NQueen(board, 0)){
        // System.out.println("solution is possible");
        // printBoard(board);
        // System.out.println(count);
        // }else{
        // System.out.println("solution is not possible");
        // }

        int[][] sudoku = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

        if (solveSudoku(sudoku, 0, 0)) {
            System.out.println("solution exists");
            printSudoku(sudoku);
        } else {
            System.out.println("solution does not exists");
        }

        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }

        };
        solveMaze(maze);
        letterCombinations("56");
        solveKT();
    }

}
