package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/19 13:59
 * @description 154.寻找旋转排序数组中的最小值 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 *
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 *
 * 示例 2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 *
 * 说明：
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 */
public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII f = new FindMinimumInRotatedSortedArrayII();
        System.out.println(f.findMin(new int[]{1, 3, 5}));
        System.out.println(f.findMin(new int[]{2, 2, 2, 0, 1}));
        System.out.println(f.findMin(new int[]{3, 1, 3}));
        System.out.println(f.findMin(new int[]{1}));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // 原来是升序的数组，旋转之后，其中任意一个位置
        // 要么左边的数组有序，要不右边的数组有序。
        // 当该位置左边的数组有序并且右边的数组有序时，该位置存在最小的元素。
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // 左边有序，最小的数字一定在 mid 右边
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 右边有序，最小的数字一定在 mid 左边，包括 mid 位置
                right = mid;
            } else {
                // 当出现 nums[mid] 和 nums[right] 相等时，直接遍历 left+1 和 right 之间的数字获得最小值
                int result = left;
                for (int i = left + 1; i < right; i++) {
                    if (nums[i] < nums[result]) {
                        result = i;
                    }
                }
                return nums[result];
            }
        }

        return nums[left];
    }
}
