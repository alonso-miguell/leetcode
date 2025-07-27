package interviews;
/*
    Leetcode #20: https://leetcode.com/problems/valid-parentheses/description/

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

     ---------------------------------------------------------------------------
    Example 1:
    Input: s = "()"
    Output: true
    ---------------------------------------------------------------------------
    Example 2:
    Input: s = "()[]{}"
    Output: true
    ---------------------------------------------------------------------------
    Example 3:
    Input: s = "(]"
    Output: false
    ---------------------------------------------------------------------------
    Example 4:
    Input: s = "([])"
    Output: true
    ---------------------------------------------------------------------------
    Example 5:
    Input: s = "([)]"
    Output: false
 */

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "()";
        System.out.println(s1 + " isValid = " + isValid(s1));
        String s2 = "([)]";
        System.out.println(s2 + " isValid = " + isValid(s2));
        String s3 = "(]";
        System.out.println(s3 + " isValid = " + isValid(s3));
        String s4 = "([])";
        System.out.println(s4 + " isValid = " + isValid(s4));
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (s.toCharArray().length < 2)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() ||
                        ((c == ')' && stack.peek() != '(') ||
                                (c == ']' && stack.peek() != '[') ||
                                (c == '}' && stack.peek() != '{')
                        )
                ) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}


