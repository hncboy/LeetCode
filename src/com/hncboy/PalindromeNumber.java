package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/4 14:27
 * @description Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * example 1:
 * Input: 121
 * Output: true
 * <p>
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Follow up:
 * Could you solve it without converting the integer to a string?
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
