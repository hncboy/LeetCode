package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/19 14:22
 * @description 209.长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 4, 4};
        int[] nums3 = {2, 3, 1, 2, 4, 3};
        int[] nums4 = {2, 3, 1, 1, 1, 1, 1};
        int[] nums5 = {1, 1};
        System.out.println(m.minSubArrayLen2(11, nums1)); // 3
        System.out.println(m.minSubArrayLen2(4, nums2)); // 1
        System.out.println(m.minSubArrayLen2(7, nums3)); //2
        System.out.println(m.minSubArrayLen2(5, nums4)); // 2
        System.out.println(m.minSubArrayLen2(3, nums5)); // 0
    }

    private int minSubArrayLen2(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                result = Math.min(result, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    private int minSubArrayLen1(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int total = 0;
        int count = 0;
        while ((right < nums.length && total <= s) || (left <= right && total >= s)) {
            while (right < nums.length && total <= s) {
                total += nums[right++];
                count++;
                if (total >= s) {
                    result = Math.min(result, count);
                }
            }

            while (left <= right && total >= s) {
                total -= nums[left++];
                count--;
                if (total >= s) {
                    result = Math.min(result, count);
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
