package com.hncboy;

/**
 * @author hncboy
 * @date 2021/10/14 9:39
 * @description 400.第 N 位数字
 * 
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
 * 注意：n 是正数且在 32 位整数范围内（n < 231）。
 *
 * 示例 1：
 * 输入：3
 * 输出：3
 *
 * 示例 2：
 * 输入：11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthDigit {

    public static void main(String[] args) {
        NthDigit n = new NthDigit();
        System.out.println(n.findNthDigit(11));
    }

    private int findNthDigit(int n) {
        // 当前计算区间中的数字是几位数
        int digit = 1;
        // 当前计算区间中数字的开始数字，start*9 表示当前区间有多少数字
        long start = 1;
        // 当前计算区间中数位的数量，也就是 digit*start*9
        long count = 9;

        // 如果要查找的某位数再当前区间就结束循环
        while (n > count) {
            // 减去上一个区间数位的数量
            n -= count;
            // 位数+1
            digit += 1;
            // 开始数字扩大 10 倍
            start *= 10;
            // 计算当前区间中数位的数量，
            count = digit * start * 9;
        }

        // (n-1)/digit 得出所求序列在当前区间所在的顺序，加上 start 就是所在的数字
        long num = start + (n - 1) / digit;
        // (n-1)%digit 得出所求序列在所在数字的第几位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
