package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/29 10:43
 * 713.乘积小于K的子数组
 *
 * 给定一个正整数数组 nums和整数 k 。
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * 示例 2:
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *
 * 提示: 
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();
        System.out.println(s.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(s.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int count = 0;
        for (int left = 0, right = 0, result = 1; right < nums.length; right++) {
            // 右指针往右移，获得乘积
            result *= nums[right];
            // 如果乘积 result 大于目标 k，则将 left 指针不断往右移，直到找到乘积比目标 k 小的
            while (result >= k) {
                result /= nums[left++];
            }
            // 此时 [left,right] 区间内连续子数组乘积都小于目标 k
            count += right - left + 1;
        }
        return count;
    }
}
