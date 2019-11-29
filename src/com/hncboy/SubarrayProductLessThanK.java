package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/29 10:43
 * @description 713.乘积小于K的子数组
 *
 * 给定一个正整数数组 nums。
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * 说明:
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 */
public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();
        System.out.println(s.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(s.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
    }

    private int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int result = 1;
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 右指针往右移
            result *= nums[right];
            // 结果 result>=k 时，左指针往右移
            while (result >= k) {
                result /= nums[left++];
            }
            // 连续的长度
            count += right - left + 1;
        }
        return count;
    }
}
