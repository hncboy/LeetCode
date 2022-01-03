package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2022/1/3 14:21
 * 剑指 Offer II 072.求平方根
 * 
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * 正数的平方根有两个，只输出其中的正数平方根。
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: x = 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 *
 * 提示:
 * 0 <= x <= 231 - 1
 *
 * 注意：本题与主站 69 题 {@link com.hncboy.SqrtX} 相同： https://leetcode-cn.com/problems/sqrtx/
 * 通过次数 7,127 提交次数 17,000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jJ0w9p
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question072 {

    private int n;

    /**
     * 二分查找法
     */
    public int mySqrt2(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    /**
     * 牛顿迭代法
     */
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        n = x;
        return ((int) (sqrt(x)));
    }

    private double sqrt(double x) {
        double result = (x + n / x) / 2;
        return result == x ? x : sqrt(result);
    }
}
