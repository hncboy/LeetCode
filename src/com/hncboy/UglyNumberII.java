package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/28 11:06
 * @description 264.丑数 II
 * 
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数2, 3, 5 的正整数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:
 * 1是丑数。
 * n不超过1690。
 */
public class UglyNumberII {

    public static void main(String[] args) {
        UglyNumberII u = new UglyNumberII();
        System.out.println(u.nthUglyNumber(10));
    }

    /**
     * 动态规划
     * 三指针
     *
     * @param n
     * @return
     */
    private int nthUglyNumber(int n) {
        // 按顺序存放丑数
        int[] dp = new int[n];
        // 存放第一个丑数
        dp[0] = 1;
        // 存放对应质数上一次用于计算丑数的下标
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 1; i < n; i++) {
            // 第a丑数个数需要通过乘2来得到下个丑数，第b丑数个数需要通过乘2来得到下个丑数，同理第c个数
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;

            // 存放下一个最小的丑数，取三种质数得出乘积最小的一种，使得丑数按顺序排列
            dp[i] = Math.min(Math.min(n2, n3), n5);
            // 判断用的是哪个质数得出的最小丑数，然后将其对应的丑数下标+1，存在几个丑数重复的情况，此时丑数下标都会+1
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
