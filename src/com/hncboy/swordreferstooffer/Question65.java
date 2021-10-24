package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/24 13:10
 * @description 剑指 Offer 65.不用加减乘除做加法
 * 
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 * 提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question65 {

    public int add(int a, int b) {
        if (a == 0 || b == 0) {
            return a ^ b;
        }
        // a^b 表示 a+b 不进位的结果
        // (a&b)<<1 表示 a+b 只计算需要进位后的结果
        // 把这两个数相加，递归直到一方为 0，也就是不需要进位
        return add(a ^ b, (a & b) << 1);
    }

    public int add2(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
