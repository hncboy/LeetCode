package com.hncboy;

/**
 * @author hncboy
 * @date 2021/9/25 13:28
 * @description 1143.最长公共子序列
 * 
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace" 
 * 输出：3  
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 * 提示：
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        assert l.longestCommonSubsequence("abcde", "ace") == 3;
        assert l.longestCommonSubsequence("abc", "abc") == 3;
        assert l.longestCommonSubsequence("abc", "dev") == 0;
    }

    private int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[] dp = new int[length2 + 1];

        for (int i = 1; i <= length1; i++) {
            // 上一个 dp[j] 位置的值
            int prevIndexValue = 0;
            for (int j = 1; j <= length2; j++) {
                // 当前 dp[j] 的旧值
                int currentIndexValue = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prevIndexValue + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                // last记录的是旧值，表示上一行的dp[j]
                prevIndexValue = currentIndexValue;
            }
        }
        return dp[length2];
    }
}
