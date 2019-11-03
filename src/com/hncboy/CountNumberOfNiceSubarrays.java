package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/3 11:01
 * @description 5248.统计「优美子数组」
 *
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 *
 * 示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 *
 * 示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 */
public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        CountNumberOfNiceSubarrays c = new CountNumberOfNiceSubarrays();
        int[] nums1 = new int[]{1, 1, 2, 1, 1};
        int[] nums2 = new int[]{2, 1, 1};
        int[] nums3 = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(c.numberOfSubarrays(nums1, 3));
        System.out.println(c.numberOfSubarrays(nums2, 1));
        System.out.println(c.numberOfSubarrays(nums3, 2));
    }

    private int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count1 = 0;
        int count2 = 0;
        int result = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                count1++;
                count2++;
            }

            while (count1 > k) {
                if (nums[left++] % 2 != 0) {
                    count1--;
                }
            }

            while (count2 >= k) {
                if (nums[right++] % 2 != 0) {
                    count2--;
                }
            }
            result += right - left;
        }
        return result;
    }
}
