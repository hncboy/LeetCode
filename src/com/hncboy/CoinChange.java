package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/10/9 10:08
 * @description 322.零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {

    private int minCoinNum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins1 = new int[]{1, 2, 5};
        int[] coins2 = new int[]{2};
        System.out.println(cc.coinChange2(coins1, 11));
        cc.minCoinNum = Integer.MAX_VALUE;
        System.out.println(cc.coinChange2(coins2, 3));
    }

    /**
     * 动态规划，自下向上
     *
     * @param coins
     * @param amount
     * @return
     */
    private int coinChange1(int[] coins, int amount) {
        // 存放对应金额最少的硬币数量
        int[] dp = new int[amount + 1];
        // 先用最大硬币数量+1填满
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 从 1 开始遍历到 amount
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 如果硬币的面值小于计算的金额
                if (coins[j] <= i) {
                    // 对应金额的最小硬币数量为默认最小金额与减去当前硬币面值的最小金额数量+1
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 递归
     *
     * @param coins
     * @param amount
     * @return
     */
    private int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        // 从大额硬币开始使用
        change(0, amount, coins, coins.length - 1);
        return minCoinNum == Integer.MAX_VALUE ? -1 : minCoinNum;
    }

    /**
     * @param useCoinNum 已经使用的硬币数量
     * @param amount     剩下的计算金额
     * @param coins      所有的硬币种类（排好序的）
     * @param n          使用的第几种硬币
     */
    private void change(int useCoinNum, int amount, int[] coins, int n) {
        // 剩余金额为 0 时重新计算最小硬币使用数量
        if (amount == 0) {
            minCoinNum = Math.min(minCoinNum, useCoinNum);
            return;
        }

        // 当前剩余金额与计算的硬币金额 + 已经使用的硬币数量 > 最小硬币数量时无需进行计算
        if (n == -1 || amount / coins[n] + useCoinNum >= minCoinNum) {
            return;
        }

        // 从最大面值的最大数量开始遍历计算
        // 先减少数量再减少面值
        for (int i = amount / coins[n]; i >= 0; i--) {
            change(useCoinNum + i, amount - coins[n] * i, coins, n - 1);
        }
    }
}
