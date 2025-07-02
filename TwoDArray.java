import java.util.*;
public class TwoDArray {
    

    public static void main(Demo[] args) {
        int[][] r = { { 1, 2, 3 }, { 6, 7, 8 }, { 9, 10, 11 } };// row sum
        for (int i = 0; i < r.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < r.length; j++) {
                rowSum = rowSum + r[i][j];
            }
            System.out.println(rowSum);
        }
        System.out.println();

        int[][] s = { { 1, 2 }, { 6, 7 }, { 9, 10 } };// col sum
        for (int i = 0; i < s[0].length; i++) {
            int colSum = 0;
            for (int j = 0; j < s.length; j++) {
                colSum = colSum + r[j][i];
            }
            System.out.println(colSum);
        }

        int[][] b = { { 7, 8, 9 }, { 2, 3, 1 } }; // max element
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] > max) {
                    max = b[i][j];
                }
            }

        }
        System.out.println(max);

        int[][] c = { { 7, 8, 9 }, { 2, 3, 1 } }; // min element
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (b[i][j] < min) {
                    min = b[i][j];
                }
            }

        }
        System.out.println(min);

    }
}
