package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/24 9:20
 * @description 53.最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
        assert new MaximumSubarray().maxSubArray(nums) == 6;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    private int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        // 如果该数组有正数，那么最大子序列从头到尾都是正数
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
