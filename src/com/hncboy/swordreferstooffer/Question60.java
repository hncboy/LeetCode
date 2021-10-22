package com.hncboy.swordreferstooffer;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2021/10/22 9:12
 * @description 剑指 Offer 60.n个骰子的点数
 * 
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 *
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * 限制：
 * 1 <= n <= 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question60 {

    public double[] dicesProbability(int n) {
        // 初始化 1 个骰子的点数情况概率，1个骰子只有 6 种情况
        double[] dp = new double[6];
        // 初始化 1 个骰子下各个点数的概率都为 1/6
        Arrays.fill(dp, 1.0 / 6.0);

        // 从 2 个骰子的情况遍历到 n 个骰子
        for (int i = 2; i <= n; i++) {
            // 当有 i 个骰子时，点数的范围为 [i, 6*i]，因此最多会有 5*i 种情况，先初始化一个 5*i+1 的数组
            double[] currentDp = new double[5 * i + 1];

            //从i-1个骰子的点数之和的值数组入手，计算i个骰子的点数之和数组的值
            //先拿i-1个骰子的点数之和数组的第j个值，它所影响的是i个骰子时的temp[j+k]的值

            // 先遍历上一轮 i-1 个骰子中各个值出现的概率
            for (int j = 0; j < dp.length; j++) {
                // 新增一个骰子后，重新计算变更的值的概率
                for (int k = 0; k < 6; k++) {
                    // 将上一轮点数 j 出现的概率再乘以多出一个骰子的 1/6 概率的结果作为新一轮的 i+k 值出现的概率
                    currentDp[j + k] += dp[j] * (1.0 / 6.0);
                }
            }
            // 当新一轮的 i 个骰子的所有值都计算出概率后，重新赋值给 dp 数组
            dp = currentDp;
        }
        return dp;
    }
}
