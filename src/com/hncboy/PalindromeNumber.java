package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/4 14:27
 * @description 9.回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1341));
    }

    private static boolean isPalindromeWithString(int x) {
        String num = String.valueOf(x);
        for (int i = 0, j = num.length() - 1; i < j; i++, j--) {
            if (num.charAt(i) != num.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int y = x;
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == y;
    }
}
