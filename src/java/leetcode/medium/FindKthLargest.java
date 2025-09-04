package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode #215: https://leetcode.com/problems/kth-largest-element-in-an-array/description
 * ---------------------------------------------------------------------------
 Given an integer array nums and an integer k, return the kth largest element in the array.

 Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Can you solve it without sorting?
 * ---------------------------------------------------------------------------
 * Example 1:
     Input: nums = [3,2,1,5,6,4], k = 2
     Output: 5
 * ---------------------------------------------------------------------------
 * Example 2:
     Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     Output: 4
 * ---------------------------------------------------------------------------

 */

public class FindKthLargest {
    public static void main(String[] args) {

        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4

    }

    public static int findKthLargest(int[] nums, int k) {
        Comparator comparator=Comparator.naturalOrder().reversed();
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>(comparator);
        for (int i: nums){
            priorityQueue.add(i);
        }

        int counter=0;

        int result=0;
        while(counter!=k){
            result=priorityQueue.poll();
            counter++;
        }

        return result;
    }


    //Suggested solution
    //around twice faster than inserting all nums into heap
//    public static int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        //create heap of size K
//        for (int i = 0; i < k; i++) {
//            minHeap.offer(nums[i]);
//        }
//
//        //process the rest of elements and only insert if the element is greater than the first (greater) element
//        for (int i = k; i < nums.length; i++) {
//            if (nums[i] > minHeap.peek()) {
//                minHeap.poll();
//                minHeap.offer(nums[i]);
//            }
//        }
//
//        return minHeap.peek();
//    }
}
