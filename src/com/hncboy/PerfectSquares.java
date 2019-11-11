package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/11 8:17
 * @description 279.完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares1(12));
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    private int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 四平方数和定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
     * 推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)
     *
     * @param n
     * @return
     */
    private int numSquares2(int n) {
        // 缩小 n 的范围，
        while (n % 4 == 0) {
            n /= 4;
        }
        // 满足公式返回 4
        if (n % 8 == 7) {
            return 4;
        }

        // 判断缩小后的数是否可以由一个数的平方或两个数的平方组合成
        for (int a = 0; a * a <= n; a++) {
            int b = (int) Math.sqrt(n - a * a);
            if (a * a + b * b == n) {
                if (a == 0) {
                    return 1;
                }
                return 2;
            }
        }
        return 3;
    }
}
