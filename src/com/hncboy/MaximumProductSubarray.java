package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/9 16:36
 * @description 152.乘积最大子序列
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        int[] nums1 = new int[]{2, 3, -2, 4, -2};
        int[] nums2 = new int[]{-2, 0, -1};
        System.out.println(m.maxProduct(nums1));
        System.out.println(m.maxProduct(nums2));
    }

    private int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            result = Math.max(result, max);
        }
        return result;
    }
}
