package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/3/1 18:08
 * @description 面试题15.二进制中1的个数
 *
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class Question15 {

    public static void main(String[] args) {
        Question15 q = new Question15();
        System.out.println(q.hammingWeight(3));
        System.out.println(q.hammingWeight(1));
        System.out.println(q.hammingWeight(31));
    }

    private int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            // n 中最低位的 1 总是对应 n-1 中的 0
            // 将 n 和 n-1 做位运算可以将 n 中最低位 1 变成 0
            n &= (n - 1);
        }
        return count;
    }
}
