package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/25 13:02
 * @description 303.区域和检索 - 数组不可变
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class RangeSumQueryImmutable {

    private int[] dp;

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable r = new RangeSumQueryImmutable(nums);
        System.out.println(r.sumRange(0, 2));
        System.out.println(r.sumRange(2, 5));
        System.out.println(r.sumRange(0, 5));
    }

    private RangeSumQueryImmutable(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    private int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
