package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/1 13:53
 * @description 剑指 Offer 16.值的整数次方
 *
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * 
 * 提示：
 * -100.0 <x< 100.0
 * -231<= n <=231-1
 * -104<= xn<= 104
 *
 * 注意：本题与主站 50 题 {@link com.hncboy.PowxN} 相同：https://leetcode-cn.com/problems/powx-n/
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question16 {

    public static void main(String[] args) {
        Question16 q = new Question16();
        System.out.println(q.myPow(2.0, 10));
        System.out.println(q.myPow(2.1, 3));
        System.out.println(q.myPow(2.0, -1));
    }

    private double myPow(double x, int n) {
        double result = 1;
        // 折半计算
        for (int i = n; i != 0; i /= 2) {
            // 奇数的 result 需要乘上 x
            if (i % 2 != 0) {
                result *= x;
            }
            // 偶数的话区 x 的平方
            x *= x;
        }
        return n > 0 ? result : 1 / result;
    }
}
