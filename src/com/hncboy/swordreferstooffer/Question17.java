package com.hncboy.swordreferstooffer;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2021/9/28 18:42
 * @description 剑指 Offer 17.打印从1到最大的n位数
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question17 {

    public static void main(String[] args) {
        Question17 q = new Question17();
        System.out.println(Arrays.toString(q.printNumbers(2)));
    }

    private int[] result;
    private int count = 0;

    private int[] printNumbers(int n) {
        result = new int[(int) Math.pow(10, n) - 1];
        // 遍历 n 位数
        for (int digit = 1; digit < n + 1; digit++) {
            // 每种位数都生成对应的全排列组合
            for (char first = '1'; first <= '9'; first++) {
                // 定义 digit 长度的数组，用于表示位数
                char[] num = new char[digit];
                // 设置 first 首位
                num[0] = first;
                // 递归生成剩下的 digit-1 位数
                dfs(1, num, digit);
            }
        }
        return result;
    }

    private void dfs(int index, char[] num, int digit) {
        // 遍历到该位的最后一位数，则存入 result
        if (index == digit) {
            result[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }

        // 生成除去首位的全排列组合
        for (char i = '0'; i <= '9'; i++) {
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }
}
