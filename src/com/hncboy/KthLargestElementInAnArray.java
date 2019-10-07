package com.hncboy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author hncboy
 * @date 2019/10/7 8:24
 * @description 215.数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        KthLargestElementInAnArray k = new KthLargestElementInAnArray();
        int[] nums1 = new int[]{3, 2, 1, 5, 6, 4};
        int[] nums2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(k.findKthLargest2(nums1, 2));
        System.out.println(k.findKthLargest2(nums2, 4));
    }

    /**
     * 排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆
     *
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargest2(int[] nums, int k) {
        // 优先队列，最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        // 遍历所有 num，在 heap 中存放前 k 个最小的元素
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    /**
     * 快速排序
     * TODO
     * @param nums
     * @param k
     * @return
     */
    private int findKthLargest3(int[] nums, int k) {
        return 0;
    }
}
