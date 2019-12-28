package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/28 10:52
 * @description 263.丑数
 * 
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数2, 3, 5的正整数。
 *
 * 示例 1:
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 ×3
 * 
 * 示例 2:
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 ×2
 * 
 * 示例3:
 * 输入: 14
 * 输出: false 
 * 解释: 14 不是丑数，因为它包含了另外一个质因数7。
 * 说明：
 * 1是丑数。
 * 输入不会超过 32 位有符号整数的范围:[-231, 231- 1]。
 */
public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        System.out.println(u.isUgly(6));
        System.out.println(u.isUgly(8));
        System.out.println(u.isUgly(14));
    }

    private boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
