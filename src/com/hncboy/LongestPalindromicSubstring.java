package com.hncboy;

/**
 * User: hncboy
 * DateTime: 2019/8/31 10:15
 * Description:
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    private static String longestPalindrome(String s) {
        // 在第 103 个用例出错 input: "" output: ""
        if (s.length() == 0) {
            return "";
        }

        int min = 0;
        int max = 1;
        int left;
        int right;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < 3; j++) {
                // j = 1 偶数回文 j = 2 奇数回文
                left = i;
                right = left + j;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                left++; // left >= 0
                if (max - min < right - left) {
                    max = right;
                    min = left;
                }
            }
        }
        // 截取 [min, max)
        return s.substring(min, max);
    }
}
