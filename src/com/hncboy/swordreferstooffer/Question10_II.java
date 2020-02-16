package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/2/16 17:10
 * @description 面试题10-II.青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 提示：
 * 0 <= n <= 100
 */
public class Question10_II {

    private int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }

        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++) {
            int c = a;
            a = b;
            b = (c + b) % 1000000007;
        }
        return b;
    }
}
