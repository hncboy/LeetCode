package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/10/12 18:10
 * @description 239.滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] nums1 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = new int[]{1, 3, 1, 2, 0, 5};
         System.out.println(Arrays.toString(s.maxSlidingWindow(nums1, 3)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums2, 3)));
    }

    private int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return nums;
        }
        int length = nums.length;
        // 存放滑动窗口中的最大值
        int[] windowMax = new int[length - k + 1];
        // 当前滑动窗口中最大值的下标
        int currentMaxIndex = -1;

        int left = 0;
        int right = k - 1;

        while (right < length) {
            // 当前最大数的下标在滑动窗口内的话就直接取最大值
            if (currentMaxIndex >= left) {
                windowMax[left] = nums[currentMaxIndex];
            } else {
                // 重新计算当前滑动窗口内的最大值及其下标
                currentMaxIndex = left;
                for (int i = left; i < left + k; i++) {
                    if (windowMax[left] <= nums[i]) {
                        windowMax[left] = nums[i];
                        currentMaxIndex = i;
                    }
                }
            }

            left++;
            right++;

            // 如果下个数大于当前窗口中的最大数，替换下标
            if (right < length) {
                if (nums[currentMaxIndex] <= nums[right]) {
                    currentMaxIndex = right;
                }
            }
        }

        return windowMax;
    }
}
