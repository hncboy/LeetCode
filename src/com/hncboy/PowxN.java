package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/29 9:32
 * @description 50.Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class PowxN {

    public static void main(String[] args) {
        System.out.println(new PowxN().myPow(2.00000, 10));
        System.out.println(new PowxN().myPow(2.10000, 3));
        System.out.println(new PowxN().myPow(2.00000, -2));
    }

    private double myPow(double x, int n) {
        // TODO
        double result = 1;
        // 折半计算
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                // i 为奇数的时候 result = result*x
                result *= x;
            }
            // 每次折半 x 都翻倍
            x *= x;
        }
        return n > 0 ? result : 1 / result;
    }
}
