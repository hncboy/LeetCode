package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/10/25 8:34
 * @description 剑指 Offer II 001.整数除法
 * 
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 * 注意：
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *
 * 示例 1：
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 *
 * 示例 2：
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 *
 * 示例 3：
 * 输入：a = 0, b = 1
 * 输出：0
 *
 * 示例 4：
 * 输入：a = 1, b = 1
 * 输出：1
 *
 * 提示:
 * -231 <= a, b <= 231 - 1
 * b != 0
 *  
 *
 * 注意：本题与主站 29 题 {@link com.hncboy.DivideTwoIntegers}
 * 相同：https://leetcode-cn.com/problems/divide-two-integers/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xoh6Oh
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question001 {

    public int divide(int a, int b) {
        // 判断结果的正负，true 为负，false 为正
        boolean sign = (a > 0) ^ (b > 0);
        // 将除数和被除数都转为负数方便处理边界
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }

        int result = 0;
        while (a <= b) {
            int tempResult = -1;
            int tempDivisor = b;
            // 得到满足当前 a <= tempDivisor*(2^n) 的结果 2^n
            while (a <= (tempDivisor << 1)) {
                // 如果除数小于 Integer.MIN_VALUE 的一半，再往左移会溢出，结束循环
                if (tempDivisor < (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                tempResult <<= 1;
                tempDivisor <<= 1;
            }
            // 将被除数-除数重新计算
            a -= tempDivisor;
            result += tempResult;
        }

        // 如果是正数
        if (!sign) {
            // 正数结果溢出的话返回最大值，否则取反返回
            return result <= Integer.MIN_VALUE ? Integer.MAX_VALUE : -result;
        }
        return result;
    }
}
