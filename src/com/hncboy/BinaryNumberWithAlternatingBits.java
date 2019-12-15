package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/15 14:44
 * @description 693.交替位二进制数
 *
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 *
 * 示例 2:
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 *
 * 示例 3:
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *
 *  示例 4:
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 */
public class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits b = new BinaryNumberWithAlternatingBits();
        System.out.println(b.hasAlternatingBits(5));
        System.out.println(b.hasAlternatingBits(7));
        System.out.println(b.hasAlternatingBits(11));
        System.out.println(b.hasAlternatingBits(10));
    }

    public boolean hasAlternatingBits(int n) {
        // n = n^(n>>1) = 1010101 ^ (1010101 >> 1) = 1010101 ^ 0101010  = 1111111
        n = n ^ (n >> 1);
        // n & (n+1) = 1111111 & 10000000 = 0
        return (n & (n + 1)) == 0;
    }
}
