package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/19 9:01
 * @description 309.最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown b = new BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(b.maxProfit(prices));
    }

    private int maxProfit(int[] prices) {
        int noStock = 0;
        int preNoStock = 0;
        int hasStock = Integer.MIN_VALUE;

        for (int price : prices) {
            int temp = noStock;
            noStock = Math.max(noStock, hasStock + price);
            hasStock = Math.max(hasStock, preNoStock - price);
            preNoStock = temp;
        }
        return noStock;
    }
}
