package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/1 9:06
 * @description 7.整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    private static int reverse(int x) {
        if (x == 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        } else if (x > 0) {
            return plusReverse(x);
        } else {
            return -plusReverse(-x);
        }
    }

    private static int plusReverse(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(s.charAt(length - i - 1));
        }

        String maxValue = String.valueOf(Integer.MAX_VALUE);
        if (length == maxValue.length() && sb.toString().compareTo(maxValue) > 0) {
            return 0;
        }
        return Integer.parseInt(sb.toString());
    }
}
