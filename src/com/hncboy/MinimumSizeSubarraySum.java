package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/19 14:22
 * @description 209.长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 4, 4};
        int[] nums3 = {2, 3, 1, 2, 4, 3};
        int[] nums4 = {2, 3, 1, 1, 1, 1, 1};
        int[] nums5 = {1, 1};
        System.out.println(m.minSubArrayLen(11, nums1)); // 3
        System.out.println(m.minSubArrayLen(4, nums2)); // 1
        System.out.println(m.minSubArrayLen(7, nums3)); //2
        System.out.println(m.minSubArrayLen(5, nums4)); // 2
        System.out.println(m.minSubArrayLen(3, nums5)); // 0
    }

    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int right = 0, left  = 0, sum = 0; right < nums.length; right++) {
            // 右指针往右移动
            sum += nums[right];
            // 当 sum 大于等于 s 时
            while (sum >= s) {
                // 得到此时的子数组长度
                result = Math.min(result, right - left + 1);
                // 左指针往右移动
                sum -= nums[left++];
            }
        }
        return result > nums.length ? 0 : result;
    }
}
