package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/13 13:54
 * @description 29.两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 *
 * 说明:
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(-2147483648, 2));
        System.out.println(divide(1, 1));
        System.out.println(divide(100, -3));
        System.out.println(divide(10, 3));
        System.out.println(divide(-10, 3));
        System.out.println(divide(-1010369383, -2147483648));
        System.out.println(divide(-1, -1));
    }

    private static int divide(int dividend, int divisor) {
        // 判断结果的正负，true 为负，false 为正
        boolean sign = (dividend > 0) ^ (divisor > 0);
        // 将除数和被除数都转为负数方便处理边界
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int result = 0;
        while (dividend <= divisor) {
            int tempResult = -1;
            int tempDivisor = divisor;
            // 得到满足当前 dividend <= tempDivisor*(2^n) 的结果 2^n
            while (dividend <= (tempDivisor << 1)) {
                // 如果除数小于 Integer.MIN_VALUE 的一半，再往左移会溢出，结束循环
                if (tempDivisor < (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                tempResult <<= 1;
                tempDivisor <<= 1;
            }
            // 将被除数-除数重新计算
            dividend -= tempDivisor;
            result += tempResult;
        }

        // 如果是正数
        if (!sign) {
            // 正数结果溢出的话返回最大值，否则取反返回
            return result <= Integer.MIN_VALUE ? Integer.MAX_VALUE : -result;
        }
        return result;
    }
}
