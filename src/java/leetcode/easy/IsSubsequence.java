package leetcode.easy;

/**
 * Leetcode: https://leetcode.com/problems/is-subsequence
 * ---------------------------------------------------------------------------
 Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

 A subsequence of a string is a new string that is formed from the original string by
 deleting some (can be none) of the characters without disturbing the relative positions
 of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * ---------------------------------------------------------------------------*
 * Example 1:

 Input: s = "abc", t = "ahbgdc"
 Output: true
 * ---------------------------------------------------------------------------*
 * Example 2:

 Input: s = "axc", t = "ahbgdc"
 Output: false
 * ---------------------------------------------------------------------------*
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); //true
        System.out.println(isSubsequence("axc", "ahbgdc")); //false
        System.out.println(isSubsequence("", "ahbgdc")); //true
        System.out.println(isSubsequence("b", "abc")); //true
    }

    //to improve we could just take into account the counter
    public static boolean isSubsequence(String s, String t) {

        if(s.isEmpty())
            return true;

//        StringBuilder sb=new StringBuilder();

        int j=0;
        for (int i = 0; i < t.length(); i++) {
            if(j<s.length() && t.charAt(i)==s.charAt(j)){
//                sb.append(t.charAt(i));
                j++;
            }
        }

//        return sb.toString().equals(s);
        return j==s.length();
    }
}
