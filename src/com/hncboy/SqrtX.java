package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/19 12:23
 * @description 69.x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class SqrtX {

    private int n;

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt2(20));
    }

    /**
     * 二分查找法
     *
     * @param x
     * @return
     */
    private int mySqrt2(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
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
     *
     * @param x
     * @return
     */
    private int mySqrt1(int x) {
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
