import java.util.*;
import java.util.Arrays;

public class DynamicProgramming2 {

    public static boolean wildcardMatching(String s, String p) { // wildcard problem
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];

    }

    public static int catalnRec(int n) { // catalane number using recursion
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalnRec(i) * catalnRec(n - i - 1);
        }
        return ans;
    }

    public static int catalnMem(int n, int[] dp) { // catalane number using memoization
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalnMem(i, dp) * catalnMem(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    public static int catalnTab(int n) { // catane number using tabulation
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    

    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.println(wildcardMatching(s, p));
        int n = 4;
        // System.out.println(catalnRec(n));
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        System.out.println(catalnTab(n));
    }
}
