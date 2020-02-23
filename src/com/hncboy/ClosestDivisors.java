package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2020/2/10:26
 * @description 5171.最接近的因数
 *
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 *
 * 示例 1：
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10,
 * 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 *
 * 示例 2：
 * 输入：num = 123
 * 输出：[5,25]
 *
 * 示例 3：
 * 输入：num = 999
 * 输出：[40,25]
 *
 * 提示：
 * 1 <= num <= 10^9
 */
public class ClosestDivisors {

    public static void main(String[] args) {
        ClosestDivisors c = new ClosestDivisors();
        System.out.println(Arrays.toString(c.closestDivisors(1)));
        System.out.println(Arrays.toString(c.closestDivisors(8)));
        System.out.println(Arrays.toString(c.closestDivisors(123)));
        System.out.println(Arrays.toString(c.closestDivisors(999)));
        System.out.println(Arrays.toString(c.closestDivisors(170967091)));
    }

    private int[] closestDivisors(int num) {
        int[] result1 = getDivisors(num + 1);
        int[] result2 = getDivisors(num + 2);
        return Math.abs(result1[0] - result1[1]) < Math.abs(result2[0] - result2[1]) ? result1 : result2;
    }

    private int[] getDivisors(int sum) {
        int left = (int) Math.sqrt(sum);
        while (true) {
            // 从开平方数开始递减，当该数可以被 sum 整除时，就直接返回，此时这两个数的绝对值最小
            if (sum % left == 0) {
                int right = sum / left;
                return new int[]{left, right};
            }
            left--;
        }
    }
}
