package com.hncboy;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author hncboy
 * @date 2019/9/1 9:06
 * @description Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−2^31,  231 − 1]. For the purpose of this problem, assume that your function
 * returns 0 when the reversed integer overflows.
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
