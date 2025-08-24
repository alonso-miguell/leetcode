package leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Leetcode #2215: https://leetcode.com/problems/find-the-difference-of-two-arrays/description
 * ---------------------------------------------------------------------------
 Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

 answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 Note that the integers in the lists may be returned in any order.
 * ---------------------------------------------------------------------------
 * Example 1:
     Input: nums1 = [1,2,3], nums2 = [2,4,6]
     Output: [[1,3],[4,6]]
     Explanation:
     For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
     For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].
 * ---------------------------------------------------------------------------
 * Example 2:
 *
     Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
     Output: [[3],[]]
     Explanation:
     For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
     Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 * ---------------------------------------------------------------------------

 */

public class FindDifferenceTwoArrays {
    public static void main(String[] args) {

        System.out.println(findDifference(new int[]{1,2,3},new int[]{2,4,6})); // [[1,3],[4,6]]
        System.out.println(findDifference(new int[]{1,2,3,3},new int[]{1,1,2,2})); // [[3],[]]
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result=new ArrayList<>();

//        Set<Integer> set1=new HashSet<>();
//        Set<Integer> set2=new HashSet<>();

        //slower than using looping
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

//        for(int i = 0; i < nums1.length; i++) {
//            set1.add(nums1[i]);
//        }
//
//        for(int i = 0; i < nums2.length; i++) {
//            set2.add(nums2[i]);
//        }

        List<Integer> result1=new ArrayList<>();
        List<Integer> result2=new ArrayList<>();

        for (Integer i: set1){
            if(!set2.contains(i))
                result1.add(i);
        }

        for (Integer i: set2){
            if(!set1.contains(i))
                result2.add(i);
        }

        result.add(result1);
        result.add(result2);


        return result;
    }
}
