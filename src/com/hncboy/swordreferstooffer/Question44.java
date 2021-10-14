package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/14 8:57
 * @description 剑指 Offer 44.数字序列中某一位的数字
 * {@link com.hncboy.NthDigit}
 *
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 *
 * 限制：
 * 0 <= n < 2^31
 * 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question44 {

    public static void main(String[] args) {
        Question44 q = new Question44();
        System.out.println(q.findNthDigit(11));
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
