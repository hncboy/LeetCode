package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2022/1/18 9:03
 * 剑指 Offer II 103.最少的硬币数目
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
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
 *
 * 注意：本题与主站 322 题 {@link com.hncboy.CoinChange} 相同： https://leetcode-cn.com/problems/coin-change/
 * 通过次数 5,658 提交次数 11,315
 */
public class Question103 {

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
