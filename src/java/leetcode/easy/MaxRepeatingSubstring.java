package leetcode.easy;

/**
 * Leetcode #1668: https://leetcode.com/problems/maximum-repeating-substring/description
 * ---------------------------------------------------------------------------
 *For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. If word is not a substring of sequence, word's maximum k-repeating value is 0.
 *
 * Given strings sequence and word, return the maximum k-repeating value of word in sequence.
 * ---------------------------------------------------------------------------
 * Example 1:
 *
 * Input: sequence = "ababc", word = "ab"
 * Output: 2
 * Explanation: "abab" is a substring in "ababc".
 * ---------------------------------------------------------------------------
 * Example 2:
 *
 * Input: sequence = "ababc", word = "ba"
 * Output: 1
 * Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
 * ---------------------------------------------------------------------------
 * Example 3:
 *
 * Input: sequence = "ababc", word = "ac"
 * Output: 0
 * Explanation: "ac" is not a substring in "ababc".
 */

public class MaxRepeatingSubstring {
    public static void main(String[] args) {

        System.out.println("maxRepeating() = " + maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba")); //5
        System.out.println("maxRepeating() = " + maxRepeating("ababc", "ab")); //2
        System.out.println("maxRepeating() = " + maxRepeating("ababc", "ba")); //1
        System.out.println("maxRepeating() = " + maxRepeating("aaa", "a")); //3
        System.out.println("maxRepeating() = " + maxRepeating("ababc", "ac")); //0
    }

    /**
     * This problem s not a good fit for sliding window because
     * you're checking for increasing-length repeated patterns,
     * not fixed-size or incrementally updated windows.
     * A simple string-building loop is the most effective approach here.
     */
    public static int maxRepeating(String sequence, String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        int result = 0;
        //this will append the word and search for the appended word in each iteration

        //a
        //aa
        //aaa

        //aaaba
        //aaabaaaaba
        //aaabaaaabaaaaba
        //aaabaaaabaaaabaaaaba
        //aaabaaaabaaaabaaaabaaaaba
        while (sequence.contains(stringBuilder)) {
            stringBuilder.append(word);
            result++;
        }

        return result;
    }
}
