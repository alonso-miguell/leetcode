package leetcode.easy;

import java.util.Arrays;

/**
 * Leetcode #509: https://leetcode.com/problems/fibonacci-number/description/
 * ---------------------------------------------------------------------------
 * Given an integer n, return an array ans of length n + 1 such that
 * for each i (0 <= i <= n), ans[i] is the number of 1's in the
 * binary representation of i.
 * <p>
 * ---------------------------------------------------------------------------
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * ---------------------------------------------------------------------------
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */


/**
 * Accoding to chatgpt, all bitwise operations have some math equivalents
 *
 * | Bitwise Operation | Math Equivalent   | Description                                      | Example (`i = 5`)                               |     |         |
 * | ----------------- | ----------------- | ------------------------------------------------ | ----------------------------------------------- | --- | ------- |
 * | `i << 1`          | `i * 2`           | Multiply by 2 (left shift)                       | `5 << 1 = 10`                                   |     |         |
 * | `i >> 1`          | `i / 2` (int div) | Divide by 2 (right shift, drops decimals)        | `5 >> 1 = 2`                                    |     |         |
 * | `i & 1`           | `i % 2`           | Check if `i` is odd (`1`) or even (`0`)          | `5 & 1 = 1`                                     |     |         |
 * | `i & (i - 1)`     | —                 | Clears the **lowest set bit**                    | `5 & 4 = 4`                                     |     |         |
 * | \`i               | 1\`               | —                                                | Force number to be **odd** (sets last bit to 1) | \`4 | 1 = 5\` |
 * | `i & ~1`          | —                 | Force number to be **even** (sets last bit to 0) | `5 & ~1 = 4`                                    |     |         |
 * | `~i`              | `-(i + 1)`        | Bitwise NOT (invert all bits, 2’s complement)    | `~5 = -6`                                       |     |         |
 * | `i ^ 1`           | —                 | Toggle last bit (even ↔ odd)                     | `5 ^ 1 = 4`                                     |     |         |
 * | `i ^ j`           | —                 | Bitwise XOR — returns bits that differ           | `5 ^ 3 = 6`                                     |     |         |
 */

public class CountBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        if (n == 0)
            return dp;

        for (int i = 1; i <= n; i++) {
            String temp = Integer.toBinaryString(i);
            System.out.println("temp = " + temp);

            int oneCounter = 0;
            for (Character c : temp.toCharArray()) {
                if (c.equals('1'))
                    oneCounter++;
            }
            dp[i] = oneCounter;
        }


        return dp;
    }

    //using bitwise operations
    public static int[] countBitWiseOperations(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }

    //using the equivalent math operation to bitwise
    public static int[] countBitsMath(int n) {
        int[] dp = new int[n + 1];
        if (n >= 0)
            dp[0] = 0;
        if (n >= 1)
            dp[1] = 1;
        if (n >= 2)
            dp[2] = 1;


        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i / 2] + (i % 2);
        }
        return dp;
    }


}
