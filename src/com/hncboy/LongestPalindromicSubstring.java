package com.hncboy;

/**
 * @author hncboy
 * @date 2019/8/31 10:15
 * @description 5.最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
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
