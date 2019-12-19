package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/19 17:23
 * @description 123.买卖股票的最佳时机 III
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，
 *      在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，
 *      在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
        System.out.println(b.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(b.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(b.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    private int maxProfit(int[] prices) {
        // 第i天，最多进行1笔交易，此时没有股票的最大利润
        int dp_i_1_0 = 0;
        // 第i天，最多进行1笔交易，此时持有股票的最大利润
        int dp_i_1_1 = Integer.MIN_VALUE;
        // 第i天，最多进行2笔交易，此时没有股票的最大利润
        int dp_i_2_0 = 0;
        // 第i天，最多进行2笔交易，此时持有股票的最大利润
        int dp_i_2_1 = Integer.MIN_VALUE;

        for (int price : prices) {
            // 1.最多进行两笔交易的情况
            // 1.1 当天不持有股票最大利润 = Math(当天不持有股票的利润，当天持有股票的利润加上卖出的利润)
            dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + price);
            // 1.2 当天持有股票最大利润 = Math(当天持有股票的利润，
            // 进行一笔交易情况并且当前不持有股票最大利润减去买入股票的价格)
            dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - price);

            // 2.最多进行一笔交易的情况
            dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + price);
            dp_i_1_1 = Math.max(dp_i_1_1, -price);
        }

        // 最多进行2次交易，且当前不持有股票的最大利润
        return dp_i_2_0;
    }
}
