package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/21 8:57
 * @description 122.买卖股票的最佳时机 II
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
        int[] prices1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices2 = new int[]{1, 2, 3, 4, 5};
        int[] prices3 = new int[]{7, 6, 4, 3, 1};
        System.out.println(b.maxProfit2(prices1));
        System.out.println(b.maxProfit2(prices2));
        System.out.println(b.maxProfit2(prices3));
    }

    private int maxProfit2(int[] prices) {
        // 第i天不持有股票的利润
        int dp_i_0 = 0;
        // 第i天持有股票的的利润
        int dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp_i_0;
            // 第i天不持有股票的最大利润 = Math(第i天不持有股票的利润, 第i天持有股票的的利润+卖出该天的股票)
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            // 第i天持有股票的的最大利润 = Math(第i天持有股票的的利润， 第i天不持有股票的利润 + 买入当天的股票)
            dp_i_1 = Math.max(dp_i_1, temp - price);
        }
        return dp_i_0;
    }

    private int maxProfit1(int[] prices) {
        int maxProfit = 0;
        // 如果第二天的价格比第一天高，那么直接卖出
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
