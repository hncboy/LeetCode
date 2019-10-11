package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/11 8:03
 * @description 88.合并两个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
    }

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        // 指针 i，从 nums1 数组最后开始
        int i = m - 1;
        // 指针 j，从 nums2 数组最后开始
        int j = n - 1;
        // 记录排序好的数下标
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        // 将 nums2 剩下的数拷到 nums1
        System.arraycopy(nums2, 0, nums1, 0, j+1);
    }
}
