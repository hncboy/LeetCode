package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/12 7:41
 * @description 125.验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(v.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断该字符是否在 a-z, 0-9
     * @param ch
     * @return
     */
    private boolean inArea(char ch) {
        return ch <= 'z' && ch >= '0' && (ch <= '9' || ch >= 'a');
    }
}
