package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/19 13:35
 * @description 153.寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(f.findMin(nums1));
        System.out.println(f.findMin(nums2));
    }

    private int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // 旋转前后一样
        if (nums[right] >= nums[left]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 最小值的情况
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[left] <= nums[mid]) {
                // 左边有序，取右边
                left = mid + 1;
            } else {
                // 右边有序，取左边
                right = mid - 1;
            }
        }
        return -1;
    }
}
