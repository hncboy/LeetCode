package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/11/26 8:44
 * @description 135.分发糖果
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 *
 * 示例 2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Candy {

    public static void main(String[] args) {
        Candy c = new Candy();
        System.out.println(c.candy(new int[]{1, 0, 2})); // 2
        System.out.println(c.candy(new int[]{1, 2, 2})); // 4
        System.out.println(c.candy(new int[]{1, 5, 4, 3, 2, 1})); // 16
        System.out.println(c.candy(new int[]{1, 3, 2, 2, 1})); // 7
        System.out.println(c.candy(new int[]{29, 51, 87, 87, 72, 12})); // 12
        System.out.println(c.candy(new int[]{1, 2, 3, 2, 1})); // 9
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param ratings
     * @return
     */
    private int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // 保证每人至少一个糖果
        Arrays.fill(candies, 1);

        // 从左到右遍历，更新左邻居小于右邻居的情况
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        int sum = candies[ratings.length - 1];
        // 从右到左遍历，更新左邻居大于右邻居的情况
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // 需要同时满足左右邻居的情况
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }
}
