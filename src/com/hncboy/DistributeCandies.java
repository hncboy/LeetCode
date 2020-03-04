package com.hncboy;

/**
 * @author hncboy
 * @date 2020/3/5 0:19
 * @description 575.分糖果
 *
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 示例 1:
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 *
 * 示例 2 :
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。
 * 这样使得妹妹可以获得的糖果种类数最多。
 *
 * 注意:
 * 数组的长度为[2, 10,000]，并且确定为偶数。
 * 数组中数字的大小在范围[-100,000, 100,000]内。
 */
public class DistributeCandies {

    private int distributeCandies(int[] candies) {
        boolean[] check = new boolean[200001];
        // 每人平均分得的糖果数量
        int average = candies.length / 2;
        int result = 0;
        for (int candy : candies) {
            // 数组的 [100000, 200000] 用于判断种类
            int i = candy + 100000;
            // 判断是否有该种糖果
            if (!check[i]) {
                check[i] = true;
                result++;
                if (result >= average) {
                    return average;
                }
            }
        }
        return result;
    }
}
