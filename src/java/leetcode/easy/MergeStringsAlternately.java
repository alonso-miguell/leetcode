package leetcode.easy;

/**
 * Leetcode #1768: https://leetcode.com/problems/merge-strings-alternately/description
 * ---------------------------------------------------------------------------
 You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 starting with word1. If a string is longer than the other, append the additional letters onto the
 end of the merged string.

 Return the merged string.
 * ---------------------------------------------------------------------------*
 Example 1:

 Input: word1 = "abc", word2 = "pqr"
 Output: "apbqcr"
 Explanation: The merged string will be merged as so:
 word1:  a   b   c
 word2:    p   q   r
 merged: a p b q c r
 * ---------------------------------------------------------------------------*
 Example 2:

 Input: word1 = "ab", word2 = "pqrs"
 Output: "apbqrs"
 Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 word1:  a   b
 word2:    p   q   r   s
 merged: a p b q   r   s
 * ---------------------------------------------------------------------------*
 Example 3:

 Input: word1 = "abcd", word2 = "pq"
 Output: "apbqcd"
 Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 word1:  a   b   c   d
 word2:    p   q
 merged: a p b q c   d
 */
public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr")); //apbqcr
        System.out.println(mergeAlternately("ab", "pqrs")); //apbqrs
        System.out.println(mergeAlternately("abcd", "pq")); //apbqcd

    }

    public static String mergeAlternately(String word1, String word2) {
        String longestWord=word1.length()>=word2.length()? word1:word2;

        StringBuilder sb=new StringBuilder();

        if(longestWord.equals(word1)){
            for (int i = 0; i < word1.length(); i++) {

                sb.append(word1.charAt(i));
                if(i<word2.length()){
                    sb.append(word2.charAt(i));
                }
            }
        }
        else{
            for (int i = 0; i < word2.length(); i++) {

                if(i<word1.length()){
                    sb.append(word1.charAt(i));
                }
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }

    //suggested solution using while
    public String mergeAlternatelyWithWhile(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }

}
