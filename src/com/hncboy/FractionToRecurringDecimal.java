package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2021/10/3 9:11
 * @description 166.分数到小数
 * 
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 *
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 *
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 *
 * 示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 *
 * 示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 * 示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 *
 * 提示：
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FractionToRecurringDecimal {

    public static void main(String[] args) {
        FractionToRecurringDecimal f = new FractionToRecurringDecimal();
        System.out.println(f.fractionToDecimal(1, 2));
        System.out.println(f.fractionToDecimal(2, 1));
        System.out.println(f.fractionToDecimal(2, 3));
        System.out.println(f.fractionToDecimal(4, 333));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        // 转 long 计算，防止溢出
        long numeratorL = numerator;
        long denominatorL = denominator;

        // 如果能直接整除，直返返回结果
        if (numeratorL % denominatorL == 0) {
            return String.valueOf(numeratorL / denominatorL);
        }

        StringBuilder sb = new StringBuilder();
        // 如果有一个数是负的，则追加负号
        if (numeratorL * denominatorL < 0) {
            sb.append('-');
        }

        // 取绝对值
        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);

        // 计算小数点之前的数字
        sb.append(numeratorL / denominatorL).append(".");

        // 将余数赋给除数
        numeratorL %= denominatorL;

        // 存放余数的 map
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (numeratorL != 0) {
            // 记录当前余数的位置
            remainderMap.put(numeratorL, sb.length());
            // 除数扩大 10 倍
            numeratorL *= 10;
            // 计算结果
            sb.append(numeratorL / denominatorL);
            // 计算余数
            numeratorL %= denominatorL;

            // 如果这个余数之前出现过，则取出之前出现过的位置
            if (remainderMap.containsKey(numeratorL)) {
                int value = remainderMap.get(numeratorL);
                return String.format("%s(%s)", sb.substring(0, value), sb.substring(value));
            }
        }
        return sb.toString();
    }
}
