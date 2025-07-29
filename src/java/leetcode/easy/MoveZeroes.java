package leetcode.easy;

import java.util.Arrays;
import java.util.List;

/**
 * Leetcode: https://leetcode.com/problems/move-zeroes/description
 * ---------------------------------------------------------------------------
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * ---------------------------------------------------------------------------*
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * ---------------------------------------------------------------------------*
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * ---------------------------------------------------------------------------*
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] array1 = new int[]{0, 1, 0, 3, 12};
        moveZeroes(array1);
        System.out.println(Arrays.toString(array1)); //[1,3,12,0,0]

        int[] array2 = new int[]{0};
        moveZeroes(array2);
        System.out.println(Arrays.toString(array2)); //[1,3,12,0,0]

    }

//    public static void moveZeroes(int[] nums) {
//
//        if (nums.length <= 1)
//            return;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0 ) {
//                int j = i + 1;
//                while (j<nums.length && nums[j] == 0 ) {
//                    j++;
//                }
//
//                if(j< nums.length) {
//                    int temp = nums[j];
//                    nums[i] = temp;
//                    nums[j] = 0;
//                }
//            }
//        }
//
//    }

    //optimized version
    //trackingIndex moves first the nonzero values
    //the it fills remaining spaces with zeroes
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int trackingIndex = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[trackingIndex] = num;
                trackingIndex++;
            }
        }

        while (trackingIndex < nums.length) {
            nums[trackingIndex] = 0;
            trackingIndex++;
        }
    }
}
