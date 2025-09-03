package leetcode.medium;
/**
 * Leetcode #2236: https://leetcode.com/problems/smallest-number-in-infinite-set/description
 * ---------------------------------------------------------------------------
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 *
 * Implement the SmallestInfiniteSet class:
 *
 * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
 * int popSmallest() Removes and returns the smallest integer contained in the infinite set.
 * void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 * ---------------------------------------------------------------------------
 * Example 1:

 Input
     ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
     [[], [2], [], [], [], [1], [], [], []]
     Output
     [null, null, 1, 2, 3, null, 1, 4, 5]

 Explanation
     SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
     smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
     smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
     smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
     smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
     smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
     smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and is the smallest number, and remove it from the set.
     smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
     smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.

 Best to test this in leetcode

 */
public class SmallestInfiniteSet {
    private Integer[] set;
    private int pointToSmallest;

    public SmallestInfiniteSet() {
        //constraint says that greatest number is 1000 thus used this number
        this.set = new Integer[1001];
        for (int i = 1; i < 1001; i++) {
            this.set[i] = i;
        }

        pointToSmallest = 1;
    }

    public int popSmallest() {
        int i = pointToSmallest;
        Integer result = null;

        while (result == null && i < 1001) {
            result = this.set[i];
            if (result != null) {
                this.set[i] = null;
                pointToSmallest = i;
            }
            i++;
        }

        return result == null ? 0 : result;
    }

    public void addBack(int num) {
        this.set[num] = num;
        if(num< pointToSmallest)
            pointToSmallest =num;
    }
}

//other solution using PriorityQueue
/**

 class SmallestInfiniteSet {
 private int current;
 private PriorityQueue<Integer> minHeap;
 private Set<Integer> addedBack;

 public SmallestInfiniteSet() {
 current = 1;
 minHeap = new PriorityQueue<>();
 addedBack = new HashSet<>();
 }

 public int popSmallest() {
 if (!minHeap.isEmpty()) {
 int smallest = minHeap.poll();
 addedBack.remove(smallest);
 return smallest;
 }
 return current++;
 }

 public void addBack(int num) {
 if (num < current && !addedBack.contains(num)) {
 minHeap.offer(num);
 addedBack.add(num);
 }
 }
 }




 */
