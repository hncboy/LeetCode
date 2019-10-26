package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/25 13:41
 * @description 32.最长有效括号
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses("(()"));
        System.out.println(l.longestValidParentheses(")()())"));
    }

    private int longestValidParentheses(String s) {
        // 存放连续的括号数量，每个下标表示在当前位置时连续括号的数量
        int[] dp = new int[s.length()];
        int maxCount = 0;

        for (int i = 1; i < s.length(); i++) {
            // 只需要计算')'出现时的次数，因为以'('结尾对应的连续括号为0
            if (s.charAt(i) == ')') {
                // 当上一个括号为'('，则连续括号的数量为上上个括号时的数量+2
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // 当前括号是 ')' 的话，判断连续括号之前的字符是否是 '('，也就是 (()) 这种情况
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 当前连续括号的数量 + 连续括号之前再连续括号的数量，也就是 ()(()) 这种情况
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxCount = Math.max(maxCount, dp[i]);
            }
        }

        return maxCount;
    }
}
