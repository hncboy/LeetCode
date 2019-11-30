package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/25 7:46
 * @description 10.正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch2("aa", "aa*"));
        System.out.println(r.isMatch2("aa", "a"));
        System.out.println(r.isMatch2("aa", "a*"));
        System.out.println(r.isMatch2("aab", "c*a*b"));
        System.out.println(r.isMatch2("mississippi", "mis*is*p*."));
    }

    /**
     * 递归
     *
     * @param s 字符串
     * @param p 表达式
     * @return
     */
    private boolean isMatch(String s, String p) {
        // 在表达式p为空，且s不为空的情况下，匹配失败
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // 判断第一个字符是否匹配
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // 处理 '*' 通配符
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 存在 * 通配符，0 次或 1次匹配成功都行
            // 通配符 * 取 0 次的时候，直接从截取p第三位以后的表达式进行下一次匹配
            // 在第一个字符匹配的条件下，截取s第二位以后的字符串进行下一次匹配
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            // 没有 * 通配符的话，直接一个一个字符匹配
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /**
     * 动态规划，自底向上
     *
     * @param s
     * @param p
     * @return
     */
    private boolean isMatch2(String s, String p) {
        // dp[i][j] 表示 s 中的 i 到最后一个字符和 p 中的 j 到最后一个字符是否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                // 判断当前字符是否能直接匹配或通过 . 匹配
                boolean firstMatch = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    /*
                     1.通配符 * 匹配 0 次：
                     直接将取 dp[i][j+2]的状态赋给dp[i][j]，即匹配当前状态中表达式往后两个位置的状态，除去表达式中*和*前面的字符
                     2.通配符 * 匹配 1 次：
                     直接将取 dp[i+1][j]的状态赋给dp[i][j]，在满足当前字符的匹配的情况下，
                     还需要满足除去当前的字符，后面的字符能和该表达式匹配，因为要查看后面*取0或1次的情况来更新状态
                     */
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    // 当前的字符能匹配且之后的字符也能匹配，则包含当前字符往后的dp才能完全匹配
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
