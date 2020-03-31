package com.hncboy;

/**
 * @author hncboy
 * @date 2020/3/31 22:13
 * @description 912.排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class SortAnArray {

    private int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int p = partition(nums, left, right);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right + 1;
        // 选取 nums[left] 作为切分元素
        int num = nums[left];

        while (true) {
            // 从数组左端开始扫描，找到第一个大于等于 num 的元素
            while (nums[++i] < num && i != right) {
            }
            // 从数组右端开始扫描，找到第一个小于等于 num 的元素
            while (nums[--j] > num && j != left) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
