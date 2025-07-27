package leetcode.easy;

/**
 * Leetcode #1071: https://leetcode.com/problems/greatest-common-divisor-of-strings/description
 * ---------------------------------------------------------------------------
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
 * (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * ---------------------------------------------------------------------------*
 * Example 1:
 * <p>
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * ---------------------------------------------------------------------------*
 * Example 2:
 * <p>
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * ---------------------------------------------------------------------------*
 * Example 3:
 * <p>
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 */
public class GreatestCommonDivisorStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC")); //ABC
        System.out.println(gcdOfStrings("ABABAB", "ABAB")); //AB
        System.out.println(gcdOfStrings("LEET", "CODE")); // ""
        System.out.println(gcdOfStrings("ABCDEF", "ABC")); // ""
        System.out.println(gcdOfStrings("AAAAAAAAA", "AAACCC")); // ""
    }

    public static String gcdOfStrings(String str1, String str2) {

        //The problem doesn't state this clearly but str2 +str1 == str2 + str1
        if(!(str1+str2).equals(str2+str1))
            return "";


        int gcd = calculateGdc(str1.length(), str2.length());

//        String longestWord = str1.length() >= str2.length() ? str1 : str2;
//        String smallestWord = str1.length() < str2.length() ? str1 : str2;

//        String gcdStr = smallestWord.substring(0, gcd);

//        StringBuilder sb = new StringBuilder(gcdStr);
//        StringBuilder sbSmallest = new StringBuilder(gcdStr);
//        while (sb.length() < longestWord.length()) {
//            sb.append(gcdStr);
//        }
//
//        while (sbSmallest.length() < smallestWord.length()) {
//            sbSmallest.append(gcdStr);
//        }
//
//        if (sb.toString().equals(longestWord) && sbSmallest.toString().equals(smallestWord))
//            return gcdStr;

        return str1.substring(0, gcd);
    }

    //how to calculate GreatestCommonDivisor
    public static int calculateGdc(int length1, int length2) {
        int biggest = Math.max(length1, length2);
        int smallest = Math.min(length1, length2);

        if (smallest == 0)
            return biggest;
        else {
            return calculateGdc(smallest, biggest % smallest);
        }
    }
}
