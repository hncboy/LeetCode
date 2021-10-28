package com.hncboy.swordreferstoofferspecial;

import com.hncboy.PalindromicSubstrings;

/**
 * @author hncboy
 * @date 2021/10/28 9:35
 * @description 剑指 Offer II 020.回文子字符串的个数
 * 
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 示例 1：
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 * 示例 2：
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 *
 * 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/a7VOhD
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question020 {

    /**
     * 动态规划
     */
    public int countSubstrings(String s) {
        // dp[i][j] 表示字符串 s 在 [i,j] 区间内的字串是否是一个回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                // 如果 i 和 j 所在位置的字符相等，并且 i 和 j 中间的字符串能构成回文串，则此时加上 i 和 j 所在的字符，也能构成回文串
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PalindromicSubstrings p = new PalindromicSubstrings();
        p.countSubstrings2("abcbca");
    }

    /**
     * 中心扩展法
     */
    public int countSubstrings2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // 回文串奇数长度的情况
            result += countSubstrings(s, i, i);
            // 回文串偶数长度的情况
            result += countSubstrings(s, i, i + 1);
        }
        return result;
    }

    private int countSubstrings(String s, int left, int right) {
        int result = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result++;
            left--;
            right++;
        }
        return result;
    }
}
