package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/10/23 10:17
 * @description 213.打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 通过次数 188,541 提交次数 434,231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII h = new HouseRobberII();
        int[] nums1 = new int[]{2, 3, 2};
        int[] nums2 = new int[]{1, 2, 3, 1};
        System.out.println(h.rob(nums1));
        System.out.println(h.rob(nums2));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 比较从第 0 间开始偷和第 1 间开始偷的最大金额
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int prev = 0;
        int curr = 0;
        for (int num : nums) {
            int temp = Math.max(curr, prev + num);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
