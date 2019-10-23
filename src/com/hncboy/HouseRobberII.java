package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/23 10:17
 * @description 213.打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII h = new HouseRobberII();
        int[] nums1 = new int[]{2, 3, 2};
        int[] nums2 = new int[]{1, 2, 3, 1};
        System.out.println(h.rob(nums1));
        System.out.println(h.rob(nums2));
    }

    private int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        // 存放不偷窃第一个放子的情况
        int pre1 = 0;
        int curr1 = 0;

        // 存放不偷窃最后一个房子的情况
        int pre2 = 0;
        int curr2 = nums[0];

        for (int i = 2; i <= length; i++) {
            int temp = curr1;
            curr1 = Math.max(curr1, pre1 + nums[i - 1]);
            pre1 = temp;

            temp = curr2;
            curr2 = Math.max(curr2, pre2 + nums[i - 1]);
            pre2 = temp;
        }

        return Math.max(curr1, pre2);
    }
}
