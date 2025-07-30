package leetcode.easy;

/**
 * Leetcode: https://leetcode.com/problems/maximum-average-subarray-i/description
 * ---------------------------------------------------------------------------
 * You are given an integer array nums consisting of n elements, and an integer k.
 * <p>
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less
 * than 10-5 will be accepted.
 * ---------------------------------------------------------------------------*
 * Example 1:
 * <p>
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * ---------------------------------------------------------------------------*
 * Example 2:
 * <p>
 * Input: nums = [5], k = 1
 * Output: 5.00000
 * ---------------------------------------------------------------------------*
 */
public class MaximumAverageSubarray {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); //12.75000
        System.out.println(findMaxAverage(new int[]{5}, 1)); // 5.00000
        System.out.println(findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1)); // 4.00000
    }

    public static double findMaxAverage(int[] nums, int k) {

        if (nums.length == 1)
            return nums[0];

        double maximunAverage = -Double.MAX_VALUE; //could also be Double.NEGATIVE_INFINITY

        int currentSum = 0;

        double average = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        average = (double) currentSum / k;
        maximunAverage = Math.max(average, maximunAverage);


        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            average = (double) currentSum / k;
            maximunAverage = Math.max(average, maximunAverage);
        }

        return maximunAverage;

    }
}

