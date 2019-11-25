package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/25 8:26
 * @description 643.子数组最大平均数 I
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * 注意:
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        MaximumAverageSubarrayI m = new MaximumAverageSubarrayI();
        System.out.println(m.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(m.findMaxAverage(new int[]{5}, 1));
        System.out.println(m.findMaxAverage(new int[]{0, 1, 1, 3, 3}, 4));
    }

    private double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int left = 0;
        int right = 0;
        while (right < k) {
            sum += nums[right];
            right++;
        }
        double average = sum / k;
        while (right < nums.length) {
            sum = sum - nums[left++] + nums[right++];
            average = Math.max(average, sum / k);
        }
        return average;
    }
}
