package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/30 10:45
 * @description 747.至少是其他数字两倍的最大数
 *
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *  
 * 示例 2:
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *  
 * 提示:
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 100].
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
