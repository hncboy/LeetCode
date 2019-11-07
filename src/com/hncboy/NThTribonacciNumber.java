package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/7 9:28
 * @description 1137.第 N 个泰波那契数
 *
 * 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *  
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 * 示例 2：
 * 输入：n = 25
 * 输出：1389537
 *
 * 提示：
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 */
public class NThTribonacciNumber {

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
    }

    private static int tribonacci(int n) {
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        while (n-- > 0) {
            n2 = n0 + n1 + n2;
            n1 = n2 - n1 - n0;
            n0 = n2 - n1 - n0;
        }
        return n0;
    }
}
