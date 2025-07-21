package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {

    /*

    Can't really say where I saw this one...

    Given an array of integers nums and an integer k, return all the subarrays of
    contiguous subarrays where the sum and product of the length of the subarray in the
    subarray is strictly less than k.

    ---------------------------------------------------------------------------
    Example 1

    Input: k = 10, nums = [2,3,1,2,2,1]
    Output:
    [2],[3],[1],[2],[2],[1]
    [2, 3],[3,1], [1 ,2] , [ 2,2], [ 2, 1]

    Explanation:
     1 + 2 * 2 = 3*2 = 6 < 10
     2 + 2 * 2 = 4*2 = 8 < 10
     2 + 1 * 2 = 3*2 = 6 < 10

    ---------------------------------------------------------------------------
    Example 2

    Input: k = 11, nums = [1,1,1,1,1,1,1,1]
    Output:
    [1],[1],[1],[1],[1],[1],[1],[1] //All 8 elements
    [1 ,1], [1 ,1],[1 ,1],[1 ,1],[1 ,1],[1 ,1],[1 ,1] //7 elements

    //same for 3

    [1 ,1, 1], [1 ,1, 1], [1 ,1, 1], [1 ,1, 1], [1 ,1, 1], [1 ,1, 1] //6 elements
    // 4 shouldn't be returned
    */

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
//    nums.add(3);
//    nums.add(-2);
//    nums.add(1);
//    nums.add(4);

//    nums.add(17);
//    nums.add(13);

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

//    nums.add(-2);
//    nums.add(2);
//    nums.add(-3);
//    nums.add(1);
        System.out.println(minimumSumSubarray(nums, 2, 4));

    }

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int result = Integer.MAX_VALUE;
        int sum = 0;

        for (int left = l; left <= r; left++) {
//        System.out.println("left------- "+left);
            sum = 0;

            //fills initial range starting by left
            for (int i = 0; i < left; i++) {
                //System.out.println("filling with"+nums.get(i));

                sum += nums.get(i);

            }

            if (sum > 0)
                result = Math.min(result, sum);

            //starts from current windows index 1(-1 because of index 0 based)
            for (int current = 1 ; left + current - 1 < nums.size(); current++) {

                System.out.println("current: "+ ( left + current - 1));

                sum=sum - nums.get(current - 1) + nums.get( left +current - 1);

                if (sum > 0)
                    result = Math.min(result, sum);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

//public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
//    int n = nums.size();
//    int minSum = Integer.MAX_VALUE;
//    int[] prefixSum = new int[n + 1];
//
//    //set prefixSum approach
//    for (int i = 0; i < n; i++) {
//        prefixSum[i + 1] = prefixSum[i] + nums.get(i);
//    }
//
//
//    for (int start = 0; start < n; start++) {
//        //set array range
//        for (int size = l; size <= r; size++) {
//            int end = start + size - 1;
//            if (end >= n) break; //to avoid outbound exceptions
//
//            int subarraySum = prefixSum[end + 1] - prefixSum[start]; //sum prefix formula for range
//            if (subarraySum > 0) {
//                minSum = Math.min(minSum, subarraySum);
//            }
//        }
//    }
//
//    return (minSum == Integer.MAX_VALUE) ? -1 : minSum;
//}





}
