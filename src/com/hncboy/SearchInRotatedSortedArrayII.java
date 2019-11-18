package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/18 13:23
 * @description 81.搜索旋转排序数组 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 *
 * 进阶:
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int[] nums3 = {1, 3};
        System.out.println(s.search(nums1, 0));
        System.out.println(s.search(nums2, 3));
        System.out.println(s.search(nums3, 3));
    }

    private boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (right == 0 && nums[0] == target) {
            return true;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }

            // 至少是有一半是有序的
            if (nums[left] < nums[mid]) {
                // 前半部分有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 后半部分有序
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
