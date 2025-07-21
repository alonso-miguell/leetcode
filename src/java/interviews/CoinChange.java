package interviews;

import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {
    /*
    Leetcode #322: https://leetcode.com/problems/coin-change/description/

    You are given an integer array coins representing coins of different denominations
    and an integer amount representing a total amount of money.
    Return the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.

    ---------------------------------------------------------------------------
    Example 1:

    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    ---------------------------------------------------------------------------
    Example 2:

    Input: coins = [2], amount = 3
    Output: -1
    ---------------------------------------------------------------------------
    Example 3:

    Input: coins = [1], amount = 0
    Output: 0
    ---------------------------------------------------------------------------
    Interview

    example was asking for: 130ish and coins= [1,2,5,10,20] ish
     */

    public static void main(String[] args) {
        int[] interViewCoins = {1, 10, 20, 5, 2};
        System.out.println("interviewCoinChange = " + interviewCoinChange(interViewCoins, 130));
        System.out.println("coinChangeDp = " + coinChangeDp(interViewCoins, 130));

        int[] coins = new int[]{186, 419, 83, 408};
        int amount = 6249;
        System.out.println("coinChangeDp = " + coinChangeDp(coins, amount));

    }

    //Used a very similar solution in interview
    public static int interviewCoinChange(int[] coins, int amount) {
        Integer[] orderedCoins = new Integer[coins.length];

        for (int i = 0; i < coins.length; i++) {
            orderedCoins[i] = coins[i];
        }
        Arrays.sort(orderedCoins, Comparator.reverseOrder());

        int result = 0;
        int addedAmount = 0;

        for (int i = 0; i < orderedCoins.length; i++) {
            if (amount >= orderedCoins[i]) {
                int change = amount % orderedCoins[i];
                int numCoins = amount / orderedCoins[i];
                result += numCoins;

                if (change == 0) {
                    addedAmount += orderedCoins[i] * numCoins;
                    break;
                } else {
                    amount = change;
                }
            }
        }

        if (addedAmount == amount) return result;
        else return -1;
    }

    //Another solution optimized with kadane's algorithm
    //This one calculates all solutions from 0 to requiredAmount and can
    // be used for any number and combination of coins (unlike my solution)
    public static int coinChangeDp(int[] coins, int requiredAmount) {
        int[] dp = new int[requiredAmount + 1]; //create array to store results
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;// base case, 0 coins needed to make 0

        //iterate until making requiredAmount
        for (int currentAmount = 1; currentAmount <= requiredAmount; currentAmount++) {
            //iterate for each coin value
            for (int j = 0; j < coins.length; j++) {
                int coinValue = coins[j];

                int remainingAmount = currentAmount - coinValue;
                if (remainingAmount >= 0 && dp[remainingAmount] != Integer.MAX_VALUE) {
                    //chose the min, we do dp[remainingAmount] + 1 because we're adding the current coin
                    //we're currently using kadane's algorithm in this line
                    dp[currentAmount] = Math.min(dp[currentAmount], dp[remainingAmount] + 1);

//                    System.out.println("currentAmount = " + currentAmount + " calculatedAmount: " + remainingAmount + " coins: " + dp[currentAmount] + " coin value: " + coinValue);
                }
            }
        }

        //if the requiredAmount is still Integer.MAX_VALUE then we couldn't meet the amount with the current coins
        return dp[requiredAmount] == Integer.MAX_VALUE ? -1 : dp[requiredAmount];
    }

}
