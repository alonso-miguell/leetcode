package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode #22: https://leetcode.com/problems/generate-parentheses/description/
 * ---------------------------------------------------------------------------
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * ---------------------------------------------------------------------------*
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * ---------------------------------------------------------------------------
 * * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(parentheses(4));
    }

    static List<String> parentheses(int n) {
        List<String> parenthesesList = new ArrayList<>();
        /**
         *  We can't pass the next line, since in each call we need to pass the number of pairs
         *  instead of the length required, pairsNeeded is the maximum number that can be used for each parentheses
         */
//        int max=n*2;

        /**
         * Also, we can't use StringBuilder for this exercise since all recursive calls would reuse
         * the same StringBuilder instance, for this exercise we need to create a new string in each call
         */
        buildParentheses(parenthesesList, "", 0, 0, n);

        return parenthesesList;
    }

    static void buildParentheses(List<String> list, String sb, int opened, int closed, int pairsNeeded) {
        if (sb.length() == pairsNeeded * 2) {
            list.add(sb);
            return;
        }

        if (opened < pairsNeeded) {
            buildParentheses(list, sb + "(", opened + 1, closed, pairsNeeded);
        }

        if (closed < opened) {
            buildParentheses(list, sb + ")", opened, closed + 1, pairsNeeded);
        }
    }
}
