package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/9 10:08
 * 322.零钱兑换
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 *
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * 通过次数 350,333 提交次数 780,345
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins1 = new int[]{1, 2, 5};
        int[] coins2 = new int[]{2};
        System.out.println(cc.coinChange(coins1, 11));
        System.out.println(cc.coinChange(coins2, 3));
    }

    /**
     * 动态规划，自下向上
     */
    public int coinChange(int[] coins, int amount) {
        // 存放对应金额最少的硬币数量
        int[] dp = new int[amount + 1];
        // 定义最大的硬币数量
        int minCount = amount + 1;

        // 从 1 开始遍历到 amount
        for (int i = 1; i <= amount; i++) {
            dp[i] = minCount;
            for (int coin : coins) {
                // 如果硬币的面值小于计算的金额
                if (coin <= i) {
                    // 对应金额的最小硬币数量为默认最小金额与减去当前硬币面值的最小金额数量+1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
