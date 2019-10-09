package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/9 9:28
 * @description 371.两整数之和
 *
 * 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
 *
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class SumOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(1, 2));
        System.out.println(new SumOfTwoIntegers().getSum(-2, 3));
    }

    private int getSum(int a, int b) {
        // 循环，直到进位符为 0
        while (b != 0) {
            // & 操作符获取进位结果
            int c = (a & b) << 1;
            // ^ 操作符获取无进位结果
            // 当进位符为 0 时，异或运算的结果就是加法的结果，异或是无进位加法
            a = a ^ b;
            b = c;
        }
        return a;
    }
}
