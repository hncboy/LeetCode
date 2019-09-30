package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/9/30 8:59
 * @description 16.最接近的三数之和
 *
 * 定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 0};
        System.out.println(new ThreeSumClosest().threeSumClosest2(nums, -100));
    }

    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    private int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        int left;
        int right;
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;

            // 区间的最小值
            int rangeMin = nums[i] + nums[left] + nums[left + 1];
            // 区间的最大值
            int rangeMax = nums[right - 2] + nums[right - 1] + nums[right];

            // target < rangeMin || target > rangeMax 只需比较两个值
            if (rangeMin > target) {
                if (rangeMin - target < Math.abs(min - target)) {
                    min = rangeMin;
                }
            } else if (rangeMax < target) {
                if (target - rangeMax < Math.abs(min - target)) {
                    min = rangeMax;
                }
            } else {
                // target 在区间内则根据比较大小进行左右指针的移动
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(target - sum) < Math.abs(target - min)) {
                        min = sum;
                    }
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        return min;
                    }
                }
            }
        }
        return min;
    }

    /**
     * 暴力
     *
     * @param nums
     * @param target
     * @return
     */
    private int threeSumClosest1(int[] nums, int target) {
        int length = nums.length;
        long min = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (Math.abs(min - target) > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
                        min = nums[i] + nums[j] + nums[k];
                        if (min == target) {
                            return (int) min;
                        }
                    }
                }
            }
        }
        return (int) min;
    }
}
