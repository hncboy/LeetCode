package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/11 15:20
 * @description 233.数字 1 的个数
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 示例:
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 */
public class NumberOfDigitOne {

    public static void main(String[] args) {
        NumberOfDigitOne n = new NumberOfDigitOne();
        System.out.println(n.countDigitOne(1410065408));
        System.out.println(n.countDigitOne(10));
        System.out.println(n.countDigitOne(1));
    }

    private int countDigitOne(int n) {
        long count = 0;
        // 分别计算个位、十位、百位上...出现 1 的个数
        for (long i = 1; i <= n; i *= 10) {
            // 高位
            long a = n / i;
            // 低位
            long b = n % i;
            /*
             当该位上的数属于 [2,9]，直接进 8 位将 a/10 的值 + 1，因为需要考虑该位为 1 的情况
             当该位上的数为 1，进 8 位之后也不会将总数 +1，该位为 1 的情况会移到下面的式子计算
             当改为上的数为 0，不用考虑该位为 1 的情况
             */
            count += (a + 8) / 10 * i;
            count += a % 10 == 1 ? b + 1 : 0;
        }
        return (int) count;
    }
}
