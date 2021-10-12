package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/12 8:13
 * @description 剑指 Offer 49.丑数
 * {@link com.hncboy.UglyNumberII}
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question49 {

    public int nthUglyNumber(int n) {
        // 按顺序存放丑数
        int[] dp = new int[n];
        // 存放第一个丑数
        dp[0] = 1;
        // 存放对应质数上一次用于计算丑数的下标
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 1; i < n; i++) {
            // 第a丑数个数需要通过乘2来得到下个丑数，第b丑数个数需要通过乘2来得到下个丑数，同理第c个数
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;

            // 存放下一个最小的丑数，取三种质数得出乘积最小的一种，使得丑数按顺序排列
            dp[i] = Math.min(Math.min(n2, n3), n5);
            // 判断用的是哪个质数得出的最小丑数，然后将其对应的丑数下标+1，存在几个丑数重复的情况，此时丑数下标都会+1
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
