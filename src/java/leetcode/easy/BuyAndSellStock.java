package leetcode.easy;

/*
    Leetcode #121: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    ---------------------------------------------------------------------------
    Example 1:

    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    ---------------------------------------------------------------------------
    Example 2:

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BuyAndSellStock {

    public static void main(String[] args) {


        int[] prices=new int[]{7,1,5,3,6,4};
        System.out.println(" profit: " + maxProfit(prices));
        System.out.println("my solution profit: " + mySolutionMaxProfit(prices));
    }





    // My solution works but breaks when the array is too long due to O(n^2)
    public static int mySolutionMaxProfit(int[] prices) {
        int [] dp=new int[prices.length];

        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                dp[i]=Math.max(dp[i],prices[j]-prices[i]);
            }
        }

        int result=0;
        for(int i=0; i<dp.length;i++){
            result=Math.max(result,dp[i]);
        }

        return result;
    }

    // optimized with Kadane's algorithm, this is O(n)
    public static int maxProfit(int[] prices) {
        int [] dp=new int[prices.length];

        for(int i=1;i<prices.length;i++){
            int todaysProfit=prices[i] - prices[i-1];

            //we keep increasing or decreasing the probably profit
            //if we keep losing, we reset to 0
            dp[i]=Math.max(0, dp[i-1]+todaysProfit);
        }

        int result=0;

        //at the end we just search for the biggest profit
        for(int i=0; i<dp.length;i++){
            result=Math.max(result,dp[i]);
        }

        return result;
    }
}
