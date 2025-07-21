package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    /*
    Not leetcode
    https://tutorialhorizon.com/algorithms/colorful-numbers/

    Given a number, find out whether it is colorful.
    Colorful Number: When in a given number, the product of every contiguous sub-sequence is different.
    That number is called a Colorful Number.

    ---------------------------------------------------------------------------
    Example 1:

    Given Number : 3245
    Output: Colorful

    Number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
    this number is a colorful number, since product of every digit of a sub-sequence are different.
    That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20, (3*2*4)= 24 (2*4*5)= 40

    ---------------------------------------------------------------------------
    Example 2:

    Given Number : 326
    Output: Not Colorful.

    326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12.
    */

    public static void main(String[] args) {
        boolean isColorful1=isColorful(3245);
        System.out.println("32454 is colorful: "+isColorful1);

        boolean isColorful2=isColorful(326);
        System.out.println("326 is colorful: "+isColorful2);
//
        boolean isColorful3=isColorful(32458);
        System.out.println("32458 is colorful: "+isColorful3);
    }

    static boolean isColorful(int number) {
        String numberStr = Integer.toString(number);
        Set<Integer> products = new HashSet<>();

        for (int i = 0; i < numberStr.length(); i++) {
            for (int j = i+1; j <= numberStr.length(); j++) {
                String substr = numberStr.substring(i, j);

//                System.out.println("substr: "+substr);

                int product = 1;
                for (Character c : substr.toCharArray()) {
                    int val = Integer.parseInt(String.valueOf(c));
                    product *= val;
                }
//                System.out.println("product is: "+product);

                if (products.contains(product)) {
                    System.out.println("repeated product is:" +product+" so not a colorful number");
                    System.out.println(products);
                    return false;
                } else {
                    products.add(product);
                }

            }
        }
        return true;
    }


}
