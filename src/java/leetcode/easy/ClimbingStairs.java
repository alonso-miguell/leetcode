package leetcode.easy;

public class ClimbingStairs {
    /*
    Leetcode #70: https://leetcode.com/problems/climbing-stairs/description/

    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    ---------------------------------------------------------------------------
    Example 1:

    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    ---------------------------------------------------------------------------
    Example 2:

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
     */


    public static void main(String[] args) {
        System.out.println(" fibonacci with DP: " + fibonacciWithDp(15));
        System.out.println(" fibonacci with recursion: " + recursiveFib(15));
    }

    /*
    This problem is basically a fibonacci just adding an extra base case
    for n=2
     */

    public static int fibonacciWithDp(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 3; i <= n; i++) {
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
