package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/30 10:45
 * 747.至少是其他数字两倍的最大数
 *
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 *
 * 示例 1：
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 *
 * 提示：
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 * 通过次数50,474提交次数118,057
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers l = new LargestNumberAtLeastTwiceOfOthers();
        System.out.println(l.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(l.dominantIndex(new int[]{1, 2, 3, 4}));
    }

    private int dominantIndex(int[] nums) {
        // 最大的数
        int firstMax = Integer.MIN_VALUE;
        // 最大的数的下标
        int firstIndex = 0;
        // 第二大的数
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondMax && nums[i] < firstMax) {
                secondMax = nums[i];
            } else if (nums[i] > firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
                firstIndex = i;
            }
        }
        return firstMax >= 2 * secondMax ? firstIndex : -1;
    }
}
