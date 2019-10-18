package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/18 15:19
 * @description 44.通配符匹配
 */
public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching w = new WildcardMatching();
        System.out.println(w.isMatch("aa", "a"));
        System.out.println(w.isMatch("aaaa", "*"));
        System.out.println(w.isMatch("aa", "?a"));
        System.out.println(w.isMatch("adceb", "*a*b"));
        System.out.println(w.isMatch("acdcb", "a*c?b"));
    }

    private boolean isMatch(String s, String p) {
        int length1 = s.length();
        int length2 = p.length();
        // 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;

        // s 的第 0 个字符和 p 的前 i 个字符是否匹配
        for (int i = 1; i <= length2; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // 如果 p 的第 j-1 个字符和 s 的第 i-1 个字符相等或 p 的第 j-1 个字符为 ?
                // 则 s 的第 i 个字符和 p 的第 j 个字符相等
                // s 的前 i 个字符和 p 的前 j 个字符根据 s 的前 i-1 和 p 的前 j-1 得出
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                // 如果 p 的第 j-1 个字符为 *
                // 如果 p 的第 j 个字符匹配空串，dp[i][j] = dp[i][j - 1]
                // 如果 p 的第 j 个字符匹配 s 的第 i 个字符，dp[i][j] = dp[i-1][j]
                if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[length1][length2];
    }
}
