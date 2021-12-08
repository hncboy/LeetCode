package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/8 8:59
 * @description 689.三个无重叠子数组的最大和
 * 
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 *
 * 示例 1：
 * 输入：nums = [1,2,1,2,6,7,5,1], k = 2
 * 输出：[0,3,5]
 * 解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
 * 也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 *
 * 示例 2：
 * 输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
 * 输出：[0,2,4]
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] < 216
 * 1 <= k <= floor(nums.length / 3)
 * 通过次数 5,765 提交次数 10,719
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSumOf3NonOverlappingSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] result = new int[3];

        // sum1 为第一个滑动窗口的元素和
        int sum1 = 0;
        int maxSum1 = 0;
        int maxSum1Idx = 0;

        // sum2 为第二个滑动窗口的元素和
        int sum2 = 0;
        int maxSum12 = 0;
        int maxSum12Idx1 = 0;
        int maxSum12Idx2 = 0;

        // sum3 为第三个滑动窗口的元素和
        int sum3 = 0;

        // 当前三个滑动窗口的最大元素和
        int maxTotal = 0;

        for (int i = k * 2; i < nums.length; ++i) {
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];

            // 窗口长度得到达 k
            if (i < k * 3 - 1) {
               continue;
            }

            // 比对最大的 sum1
            if (sum1 > maxSum1) {
                maxSum1 = sum1;
                maxSum1Idx = i - k * 3 + 1;
            }

            // 比对 sum1 + sum2 的最大和
            if (maxSum1 + sum2 > maxSum12) {
                maxSum12 = maxSum1 + sum2;
                maxSum12Idx1 = maxSum1Idx;
                maxSum12Idx2 = i - k * 2 + 1;
            }

            // 比对 sum1 + sum2 + sum3 的最大和
            if (maxSum12 + sum3 > maxTotal) {
                maxTotal = maxSum12 + sum3;
                result[0] = maxSum12Idx1;
                result[1] = maxSum12Idx2;
                result[2] = i - k + 1;
            }

            sum1 -= nums[i - k * 3 + 1];
            sum2 -= nums[i - k * 2 + 1];
            sum3 -= nums[i - k + 1];
        }
        return result;
    }
}
