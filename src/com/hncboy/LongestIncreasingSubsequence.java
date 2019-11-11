package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/11/11 8:47
 * @description 300.最长上升子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(l.lengthOfLIS2(nums));
    }

    /**
     * 动态规划
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    private int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int result = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * 动态规划+二分查找
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    private int lengthOfLIS2(int[] nums) {
        int[] tail = new int[nums.length];
        int result = 0;
        for (int num : nums) {
            int left = 0;
            int right = result;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tail[mid] < num) {
                    // 将小于 num 的数存入 tail
                    left = mid + 1;
                } else {
                    // num 大于所有 tail中的数的话，将该数插入 tail，并 result++
                    right = mid;
                }
            }
            tail[left] = num;
            result = result == right ? result + 1 : result;
        }
        return result;
    }
}
