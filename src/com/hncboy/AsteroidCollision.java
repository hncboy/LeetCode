package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2021/11/21 13:59
 * @description 735.行星碰撞
 * 
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 * 示例 1：
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 *
 * 示例 2：
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 *
 * 示例 3：
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 * 示例 4：
 * 输入：asteroids = [-2,-1,1,2]
 * 输出：[-2,-1,1,2]
 * 解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。 
 *  
 *
 * 提示：
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/asteroid-collision
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            // 判断新小行星是否爆炸
            boolean isBomb = false;

            // 如果新的小行星往左移动，旧的小行星往右移动，则可能碰撞
            while (!stack.isEmpty() && asteroid < 0 && 0 < stack.peek()) {
                // 如果旧的小行星没有新的小行星大，则旧的小行星发生爆炸
                if (stack.peek() < -asteroid) {
                    stack.pop();
                    // 继续判断新的小行星是否会和旧的小行星发生碰撞
                    continue;
                }

                // 如果两个小行星一样大，则都爆炸
                if (stack.peek() == -asteroid) {
                    stack.pop();
                }

                // 如果旧小行星大，则新小行星爆炸
                isBomb = true;
                break;
            }

            if (!isBomb) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
