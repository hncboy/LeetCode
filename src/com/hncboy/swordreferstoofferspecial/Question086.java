package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/1/13 8:50
 * 剑指 Offer II 086.分割回文子字符串
 *
 * 给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "google"
 * 输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
 *
 * 示例 2：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * 注意：本题与主站 131 题 {@link com.hncboy.PalindromePartitioning} 相同： https://leetcode-cn.com/problems/palindrome-partitioning/
 * 通过次数 4,363 提交次数 5,836
 */
public class Question086 {

    public String[][] partition(String s) {
        int n = s.length();
        // 动态规划，用于存储对应区间内的字符串是否为回文串
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]);
            }
        }

        List<String[]> result = new ArrayList<>();
        backTrack(s, 0, dp, new ArrayList<>(), result);

        return result.toArray(new String[result.size()][]);
    }

    private void backTrack(String s, int start, boolean[][] dp, List<String> sub, List<String[]> result) {
        if (start == s.length()) {
            result.add(sub.toArray(new String[sub.size()]));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // 当前子串满足回文才进行回溯
            if (dp[start][i]) {
                sub.add(s.substring(start, i + 1));
                backTrack(s, i + 1, dp, sub, result);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
