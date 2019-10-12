package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/12 8:05
 * @description 131.分割回文串
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.partition("aab"));
    }

    private List<List<String>> partition(String s) {
        int length = s.length();
        // 动态规划，用于存储对应区间内的字符串是否为回文串
        boolean[][] dp = new boolean[length][length];

        // 遍历所有长度的子串
        for (int sub = 1; sub <= length; sub++) {
            // 考虑该子串下所有的子串
            for (int i = 0; i <= length - sub; i++) {
                int j = i + sub - 1;
                // 当 i 和 j 对应的字符相等以及在它们区间内的字串是回文子串时这串子串即为回文子串
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((i + 1 > j - 1) || dp[i + 1][j - 1]);
            }
        }

        List<List<String>> result = new ArrayList<>();
        backTrack(s, 0, dp, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯
     *
     * @param s
     * @param start
     * @param dp
     * @param sub
     * @param result
     */
    private void backTrack(String s, int start, boolean[][] dp, List<String> sub, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(sub));
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
