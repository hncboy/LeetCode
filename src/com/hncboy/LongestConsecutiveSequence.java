package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/9/9 18:19
 * @description 128.最长连续序列
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int count = 1;
        int max = 1;
        Arrays.sort(nums);
        for (int i = 1; i < length; i++) {
            int result = nums[i] - nums[i - 1];
            if (result == 0) {
                continue;
            }
            count = result == 1 ? ++count : 1;
            max = Math.max(max, count);
        }
        return max;
    }
}
