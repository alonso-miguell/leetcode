package leetcode.medium;

import java.util.*;

/**
 * Leetcode #735: https://leetcode.com/problems/asteroid-collision/description
 * ---------------------------------------------------------------------------
 * We are given an array asteroids of integers representing asteroids in a row.
 * The indices of the asteriod in the array represent their relative position in space.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * ---------------------------------------------------------------------------
 * Example 1:
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * ---------------------------------------------------------------------------
 * Example 2:
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * ---------------------------------------------------------------------------
 * Example 3:
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 *
 * Note: This describes the order in which a collision happens.
 *
 * -2(<-) -1(<-) 1(->) 2(->)
 *
 * This case would never collide since all asteroids are moving away from each other.
 * So, the only collision posible it's if we have  -->  <--  meaning  + -
 *
 */
public class AsteroidCollision {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(asteroidCollision(new int[] {5, 10, -5}))); // [5,10]
        System.out.println(Arrays.toString(asteroidCollision(new int[] {8, -8}))); // []
        System.out.println(Arrays.toString(asteroidCollision(new int[] {10, 2, -5}))); // [10]
        System.out.println(Arrays.toString(asteroidCollision(new int[] {-2, -1, 1, 2}))); // [-2,-1,1,2]
        System.out.println(Arrays.toString(asteroidCollision(new int[] {1, -2, -2, -2}))); // [-2,-2,-2]
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (true) {
                    // storing this variable for checking instead of calling peek everytime increases performance by 15%
                    int priorAsteroid = stack.peek();

                    if (priorAsteroid < 0) {
                        stack.push(asteroid);
                        break;
                    } else if (asteroid + priorAsteroid == 0) {
                        stack.pop();
                        break;
                    } else if (asteroid + priorAsteroid < 0) {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroid);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        // shorter but takes more processing time
        return stack.stream().mapToInt(Integer::valueOf).toArray();

        // this increases performance by 30%
        //        int[] result=new int[stack.size()];
        //        int i=stack.size()-1;
        //        while (!stack.isEmpty()){
        //            result[i]=stack.pop();
        //            i--;
        //        }
        //
        //        return result;
    }

    // suggested approach by chadGpt
    //    Uses Deque (ArrayDeque) instead of Stack → more modern and faster.
    //    Uses destroyed flag instead of multiple breaks → clearer logic.
    //    Collision handling is cleaner:
    //    Compare magnitudes (top < -asteroid) rather than sum.
    //    More efficient array conversion → avoids streams.

    public int[] asteroidCollision2(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Process collisions only if current asteroid is moving left
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -asteroid) {
                    stack.pop(); // top destroyed, keep checking
                    continue;
                } else if (top == -asteroid) {
                    stack.pop(); // both destroyed
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert to int[]
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
