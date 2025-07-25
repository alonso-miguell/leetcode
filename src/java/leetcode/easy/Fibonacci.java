package leetcode.easy;

public class Fibonacci {
    /*
    Leetcode #509: https://leetcode.com/problems/fibonacci-number/description/

    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.
    Given n, calculate F(n).
    ---------------------------------------------------------------------------
    Example 1:

    Input: n = 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
    ---------------------------------------------------------------------------
    Example 2:

    Input: n = 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
    ---------------------------------------------------------------------------
    Example 3:

    Input: n = 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
     */

    public static void main(String[] args) {
        System.out.println(" fibonacci with DP: " + fibonacciWithDp(15));
        System.out.println(" fibonacci with recursion: " + recursiveFib(15));
    }

    public static int fibonacciWithDp(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
//            if(dp[i]==0)
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int recursiveFib(int n) {
        if (n == 0 || n == 1) //base cases
            return n;

        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }
}
