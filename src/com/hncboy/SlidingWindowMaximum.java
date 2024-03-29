package com.hncboy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hncboy
 * @date 2019/10/12 18:10
 * @description 239.滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
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
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] nums1 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = new int[]{1, 3, 1, 2, 0, 5};
         System.out.println(Arrays.toString(s.maxSlidingWindow(nums1, 3)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums2, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        // 定义双端队列，仅包含当前滑动窗口中的所有元素
        Deque<Integer> deque = new LinkedList<>();
        // 存放滑动窗口中最大数的数组
        int[] result = new int[nums.length - k + 1];

        // 定义第一个滑动窗口中双端队列中的元素
        for (int i = 0; i < k; i++) {
            // 如果插入的元素比队列中的元素大，则删除队列中的所有元素，队首的元素一定是当前窗口中最大
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }

            // 将当前元素插入队列尾部
            deque.addLast(nums[i]);
        }

        // 此时队列中的元素是递减的，获取队列中的第一个元素作为第一个滑动窗口的最大值
        result[0] = deque.peekFirst();

        // 遍历后面的滑动窗口
        for (int i = k; i < nums.length; i++) {
            // i-k 是上个窗口的第一个元素，如果目前队列中的第一个元素也就是最大值和上一个窗口的第一个元素相等，则移除队列中的第一个元素
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }

            // i 是当前窗口的最后一个元素，将当前窗口的最后一个元素和队列中之前的元素作比较，移除比该元素小的值
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }

            // 将当前元素插入队列尾部
            deque.addLast(nums[i]);

            // 取队首的元素当作本次滑动窗口的最大元素
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
}
