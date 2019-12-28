package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/28 10:13
 * @description 204.计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes(10));
    }

    /**
     * the Sieve of Eratosthenes
     * 埃拉托色尼筛选法
     *
     * @param n
     * @return
     */
    private int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        // 标记所有数都为质数
        Arrays.fill(isPrim, true);

        for (int i = 2; i * i < n; i++) {
            // 如果当前数为质数
            if (isPrim[i]) {
                // 从当前数的平方开始遍历，将当前数的整数倍的数都标记为非质数
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }

        return count;
    }
}
