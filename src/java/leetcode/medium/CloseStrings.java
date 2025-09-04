package leetcode.medium;

import java.util.*;

/**
 * Leetcode #1657: https://leetcode.com/problems/determine-if-two-strings-are-close/description
 * ---------------------------------------------------------------------------
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 * ---------------------------------------------------------------------------
 * Example 1:
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * ---------------------------------------------------------------------------
 * Example 2:
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * ---------------------------------------------------------------------------
 * Example 3:
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 */
public class CloseStrings {
    public static void main(String[] args) {

        System.out.println(closeStrings("abc", "bca")); // true
        System.out.println(closeStrings("a", "aa")); // false
        System.out.println(closeStrings("cabbba", "abbccc")); // true
        System.out.println(closeStrings("abbbzcf", "babzzcz")); // false
        System.out.println(closeStrings("abbzzca", "babzzcz")); // false
    }

    /*Basically we create two maps, and both maps should be equals in the keys and the frequencys
    * BUT, no necessarily the same frequency for the same keys, keys can have different order of frequency
    * but in the end, the valueSet should be the equal
    * */
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        //Fill maps
        for (char c : word1.toCharArray()) {
//            map1.computeIfAbsent( c,k -> 0);
            map1.put(c, map1.getOrDefault(c,0)+1);
        }

        for (char c : word2.toCharArray()) {
//            map2.computeIfAbsent( c,k -> 0);
            map2.put(c, map2.getOrDefault(c,0)+1);
        }

        //keysets should be equal, each character should be present in the other word
        if(!map1.keySet().equals(map2.keySet()))
            return false;

        //get the frequency for the characters
        List<Integer> freqs1=new ArrayList<>(map1.values());
        List<Integer> freqs2=new ArrayList<>(map2.values());


        //Sort them so in the end should match if possible
        Collections.sort(freqs1);
        Collections.sort(freqs2);
//        freqs1.sort(Comparator.naturalOrder());
//        freqs2.sort(Comparator.naturalOrder());

        return freqs1.equals(freqs2);
    }
}
