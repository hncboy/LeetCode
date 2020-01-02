package com.hncboy;

/**
 * @author hncboy
 * @date 2020/1/2 19:42
 * @description 367.有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 * 输入：16
 * 输出：True
 *
 * 示例 2：
 * 输入：14
 * 输出：False
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        ValidPerfectSquare v = new ValidPerfectSquare();
        System.out.println(v.isPerfectSquare1(1));
        System.out.println(v.isPerfectSquare1(16));
        System.out.println(v.isPerfectSquare1(14));
    }

    /**
     * 牛顿迭代法
     *
     * @param num
     * @return
     */
    private boolean isPerfectSquare2(int num) {
        if (num < 2) {
            return true;
        }

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    /**
     * 二分查找
     *
     * @param num
     * @return
     */
    private boolean isPerfectSquare1(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
