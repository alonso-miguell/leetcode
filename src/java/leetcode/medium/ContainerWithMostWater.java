package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Leetcode #11: https://leetcode.com/problems/container-with-most-water/description
 * ---------------------------------------------------------------------------
 You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

 Find two lines that together with the x-axis form a container, such that the container contains the most water.

 Return the maximum amount of water a container can store.

 Notice that you may not slant the container.
 * ---------------------------------------------------------------------------
 * Example 1:
     Input: height = [1,8,6,2,5,4,8,3,7]
     Output: 49
     Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * ---------------------------------------------------------------------------
 * Example 2:
     Input: height = [1,1]
     Output: 1
 * ---------------------------------------------------------------------------

 */

public class ContainerWithMostWater {
    public static void main(String[] args) {

        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(maxArea(new int[]{1,1})); // 1
        System.out.println(maxArea(new int[]{1,2,1})); // 2
        System.out.println(maxArea(new int[]{4,3,2,1,4})); // 16
    }

    /**
     *
     * Suggested approach
     *The two-pointer technique starts with the widest container and moves the pointers inward based on the comparison of heights.
     * Increasing the width of the container can only lead to a larger area if the height of the new boundary is greater.
     * By moving the pointers towards the center, we explore containers with the potential for greater areas.
     *
     * So basically, we start from left =0 & right= length-1
     * We cget the minimun edge for that iteration and decrease left or right accordingly
     * We're trying to keep the max height
     *
     * Look at the image to get a clearer mental image
     */
    public static int maxArea(int[] height) {
        int result=0;

        if (height.length<2)
            return result;

        int left=0;
        int right=height.length-1;

        while(left<right){
            int min=Math.min(height[left],height[right]);

            int wide=right-left;
            int currentArea=min*wide;

            result=Math.max(result, currentArea);

            if(height[left]>height[right])
                right--;
            else
                left++;
        }

        return result;
    }
}
