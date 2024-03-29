package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/12 8:05
 * 131.分割回文串
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * 通过次数 152,396 提交次数 210,448
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        // 动态规划，用于存储对应区间内的字符串是否为回文串
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]);
            }
        }

        List<List<String>> result = new ArrayList<>();
        backTrack(s, 0, dp, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(String s, int start, boolean[][] dp, List<String> sub, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(sub));
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
