package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/28 12:14
 * @description 313.超级丑数
 *
 * 编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为k的质数列表primes中的正整数。
 *
 * 示例:
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 *
 * 说明:
 * 1是任何给定primes的超级丑数。
 * 给定primes中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第n个超级丑数确保在 32 位有符整数范围内。
 */
public class SuperUglyNumber {

    public static void main(String[] args) {
        SuperUglyNumber s = new SuperUglyNumber();
        System.out.println(s.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

    private int nthSuperUglyNumber(int n, int[] primes) {
        // 统计每个数使用的次数
        int[] count = new int[primes.length];
        // 统计每个位置对应的丑数
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            // 遍历计算当前最小的丑数
            for (int j = 0; j < primes.length; j++) {
                // 计算当前质数对应的最小丑数
                min = Math.min(min, primes[j] * dp[count[j]]);
            }

            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                // 如果当前计算的质数*次数能得到最小值，该质数的数量+1
                if (min == primes[j] * dp[count[j]]) {
                    count[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}
