package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/23 9:32
 * @description 198.打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
 * 能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        int[] nums1 = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{2, 7, 9, 3, 1};
        System.out.println(h.rob(nums1));
        System.out.println(h.rob(nums2));
    }

    private int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 2];
        for (int i = 0; i < length; i++) {
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        return dp[length + 1];
    }
}
