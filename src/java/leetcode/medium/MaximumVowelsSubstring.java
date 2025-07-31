package leetcode.medium;

/**
 * Leetcode: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description
 * ---------------------------------------------------------------------------
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * <p>
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * ---------------------------------------------------------------------------*
 * Example 1:
 * <p>
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * ---------------------------------------------------------------------------*
 * Example 2:
 * <p>
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * ---------------------------------------------------------------------------*
 * Example 3:
 * <p>
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * ---------------------------------------------------------------------------*
 */
public class MaximumVowelsSubstring {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3)); // 3
        System.out.println(maxVowels("aeiou", 2)); // 2
        System.out.println(maxVowels("leetcode", 3)); // 2
        System.out.println(maxVowels("tryhard", 4)); // 1
        System.out.println(maxVowels("weallloveyou", 7)); // 4
        System.out.println(maxVowels("a", 1)); // 1
    }

    public static int maxVowels(String s, int k) {
        int maxVowels = 0;

        int counter = 0;

        for (int i = 0; i < s.length(); i++) {

            // increment the counter if the current char is vowel
            char currentChar = s.charAt(i);
            if (isVowel(currentChar)) {
                counter++;
            }

            // once we have reached minium k, check if the char at the begining (i-k) isVowel then decrease the counter
            if (i >= k) {
                char initChar = s.charAt(i - k);
                if (isVowel(initChar)) counter--;
            }

            maxVowels = Math.max(counter, maxVowels);
        }

        return maxVowels;
    }

    public static boolean isVowel(char c) {
        //        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
