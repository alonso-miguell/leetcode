package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
/*
    Leetcode #118: https://leetcode.com/problems/pascals-triangle/description/
    Leetcode #119: https://leetcode.com/problems/pascals-triangle-ii/description

    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
    ---------------------------------------------------------------------------
    Example 1:

    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    ---------------------------------------------------------------------------
    Example 2:

    Input: numRows = 1
    Output: [[1]]

 */
public class PascalsTriangle {
    public static void main(String[] args) {

        System.out.println("generate = " + generate(5));
    }

    //JUst another fibonacci using lists
    //# 119 is almost the same, just returning the list in index n-1
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0)
            return result;

        result.add(List.of(1));

        if (numRows >= 2)
            result.add(List.of(1, 1));

        for (int i = 2; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> priorRow = result.get(i - 1);
            result.add(currentRow);

            currentRow.add(1);
            for (int j = 1; j < priorRow.size(); j++) {
                currentRow.add(priorRow.get(j - 1) + priorRow.get(j));
            }
            currentRow.add(1);
        }

        return result;
    }
}
