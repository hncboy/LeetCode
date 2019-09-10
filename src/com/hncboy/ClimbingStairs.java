package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/10 8:25
 * @description 70.爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int n) {
        // 迭代法 斐波那契
        if (n >= 1 && n <= 3) {
            return n;
        }
        int n1 = 2;
        int n2 = 3;
        while (n-- > 3) {
            n2 = n1 + n2;
            n1 = n2 - n1;
        }
        return n2;
    }
}
