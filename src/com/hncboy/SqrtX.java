package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/19 12:23
 * 69.x 的平方根
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * 提示：
 * 0 <= x <= 231 - 1
 * 通过次数 432,911 提交次数 1,108,145
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SqrtX {

    private int n;

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt2(20));
    }

    /**
     * 二分查找法
     */
    public int mySqrt2(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    /**
     * 牛顿迭代法
     */
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        n = x;
        return ((int) (sqrt(x)));
    }

    private double sqrt(double x) {
        double result = (x + n / x) / 2;
        return result == x ? x : sqrt(result);
    }
}
