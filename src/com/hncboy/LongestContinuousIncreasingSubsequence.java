package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/27 10:30
 * @description 674.最长连续递增序列
 *
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 */
public class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence l = new LongestContinuousIncreasingSubsequence();
        System.out.println(l.findLengthOfLCIS(new int[]{1, 3, 5, 7}));
        System.out.println(l.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(l.findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5}));
    }

    private int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            count = nums[i] > nums[i - 1] ? count + 1 : 1;
            max = Math.max(count, max);
        }
        return max;
    }
}
