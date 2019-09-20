package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/9/20 13:25
 * @description 34.在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 7)));
    }

    private int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, false); // 查找左边界
        int right = binarySearch(nums, target, true); // 查找右边界
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        // 不存在的情况
        if ((left == 0 && right == 0) || (left == nums.length && right == nums.length)) {
            return new int[]{-1, -1};
        }

        if (nums[left] != target && nums[right] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{left, --right};
    }

    private int binarySearch(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                if (flag) {
                    left = mid + 1; // 查找右边界
                } else {
                    right = mid - 1; // 查找左边界
                }
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return left;
    }
}
