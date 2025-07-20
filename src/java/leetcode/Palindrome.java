public static void main(String[] args) {
    /*

    Leetcode #125: https://leetcode.com/problems/valid-palindrome/description/
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
    all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.

    ---------------------------------------------------------------------------
    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
    ---------------------------------------------------------------------------
    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.
    ---------------------------------------------------------------------------
    Example 3:

    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.

     */

//            String s = " ";
            String s = "race a car";
//            String s = "A man, a plan, a canal: Panama";
//            String s = "Anita lava la tina";
            System.out.println(isPalindrome(s));
}

public static boolean isPalindrome(String s) {
    String lowerCase = s.toLowerCase();
    StringBuilder sb = new StringBuilder();

    for (char c : lowerCase.toCharArray()) {
        if (Character.isLetterOrDigit(c)) {
            sb.append(c);
        }
    }

    for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) return false;
    }

    return true;
}