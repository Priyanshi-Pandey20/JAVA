import java.util.*;
import java.util.Arrays;

public class DynamicProgramming {

    public static int fibbonacci(int[] f, int n) { // print nth fibbnocci
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];
    }

    public static int climbStairs(int n, int[] ways) { // climb stairs using memoization
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];

        }
        ways[n] = climbStairs(n - 1, ways) + climbStairs(n - 2, ways);
        return ways[n];
    }

    public static int climbStairsTab(int n){ // climb stairs using tabulation
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i =1;i<= n;i++){
            if(i ==1){
                dp[i] = dp[i-1]+0;
            }
            else{
               dp[i] = dp[i-1] + dp[i-2];
            }

        }
        return dp[n];
    }

     

    public static void main(String[] args) {
        int n = 5;
        int[] ways = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(climbStairsTab(n));
    }
}
