package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/15 15:05
 * @description 剑指 Offer 46.把数字翻译成字符串
 * 
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 
 * 提示：
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question46 {

    public static void main(String[] args) {
        Question46 q = new Question46();
        System.out.println(q.translateNum(12258));
    }

    public int translateNum(int num) {
        int dp1 = 1;
        int dp2 = 1;

        // 前一位余数
        int x;
        // 后一位余数
        int y = num % 10;

        // 不断遍历数字
        while (num != 0) {
            // 数字除以 10
            num /= 10;
            // 前一位余数
            x = num % 10;

            // 获取两位余数合起来的结果
            int total = 10 * x + y;

            // 如果两个数字可以和形成组合字母，则组合种类加上之前上上之前的情况
            int dp3 = (total >= 10 && total <= 25) ? dp2 + dp1 : dp2;
            dp1 = dp2;
            dp2 = dp3;

            // 后一位余数往前进一位
            y = x;
        }

        return dp2;
    }
}
