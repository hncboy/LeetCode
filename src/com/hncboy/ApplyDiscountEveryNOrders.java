package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2020/2/22 22:29
 * @description 1357.每隔 n 个顾客打折
 *
 * 超市里正在举行打折活动，每隔 n 个顾客会得到 discount 的折扣。
 * 超市里有一些商品，第 i 种商品为 products[i] 且每件单品的价格为 prices[i] 。
 * 结账系统会统计顾客的数目，每隔 n 个顾客结账时，
 * 该顾客的账单都会打折，折扣为 discount （也就是如果原本账单为 x ，那么实际金额会变成 x - (discount * x) / 100 ），然后系统会重新开始计数。
 * 顾客会购买一些商品， product[i] 是顾客购买的第 i 种商品， amount[i] 是对应的购买该种商品的数目。
 *
 * 请你实现 Cashier 类：
 * Cashier(int n, int discount, int[] products, int[] prices) 初始化实例对象，参数分别为打折频率 n ，折扣大小 discount ，超市里的商品列表 products 和它们的价格 prices 。
 * double getBill(int[] product, int[] amount) 返回账单的实际金额（如果有打折，请返回打折后的结果）。返回结果与标准答案误差在 10^-5 以内都视为正确结果。
 */
public class ApplyDiscountEveryNOrders {

    private int currentConsumer;
    private int n;
    private int discount;
    private Map<Integer, Integer> productToPrice;

    public static void main(String[] args) {
        ApplyDiscountEveryNOrders a = new ApplyDiscountEveryNOrders(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{100, 200, 300, 400, 300, 200, 100});
        System.out.println(a.getBill(new int[]{1, 2}, new int[]{1, 2}));
    }

    private ApplyDiscountEveryNOrders(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        productToPrice = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            productToPrice.put(products[i], prices[i]);
        }
    }

    private double getBill(int[] product, int[] amount) {
        double total = 0;
        for (int i = 0; i < product.length; i++) {
            total += productToPrice.get(product[i]) * amount[i];
        }
        currentConsumer = (currentConsumer + 1) % n;
        return total - (currentConsumer == 0 ? discount * total / 100 : 0);
    }
}
