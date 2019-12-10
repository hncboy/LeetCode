package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/10 11:04
 * @description 172.阶乘后的零
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 *
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        FactorialTrailingZeroes f = new FactorialTrailingZeroes();
        System.out.println(f.trailingZeroes(3));
        System.out.println(f.trailingZeroes(5));
        System.out.println(-1%5);
    }

    private int trailingZeroes(int n) {
        // 当前数乘以10就能得到一个0
        // 10 = 2*5，2出现的次数明显多余5的次数，所以统计 5 出现的次数
        // 每隔5个数，出现1个5，每个25个数出现2个5，每个125个数，出现3个5，依次类推
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
