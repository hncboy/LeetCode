package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/9/14 15:24
 * @description 41.缺失的第一个正数
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 说明:
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 0};
        int[] nums2 = new int[]{3, 4, -1, 1};
        int[] nums3 = new int[]{7, 8, 9, 11, 12};
        int[] nums4 = new int[]{-5};
        int[] nums5 = new int[]{0, 2, 2, 1, 1};
        int[] nums6 = new int[]{1, 2, 2, 2, 2, 3, 1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        assert firstMissingPositive.firstMissingPositive(nums1) == 3;
        assert firstMissingPositive.firstMissingPositive(nums2) == 2;
        assert firstMissingPositive.firstMissingPositive(nums3) == 1;
        assert firstMissingPositive.firstMissingPositive(nums4) == 1;
        assert firstMissingPositive.firstMissingPositive(nums5) == 3;
        assert firstMissingPositive.firstMissingPositive(nums6) == 4;
    }

    private int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];

        // 遍历原数组，将大于等于1和小于数组长度的数放到temp数组对应位置
        for (int num : nums) {
            if (num >= 1 && num <= length) {
                temp[num - 1] = num;
            }
        }
        // 遍历 temp 数组，如果下标+1和当前数不对应，那该数就是缺失的
        for (int i = 0; i < length; i++) {
            if (temp[i] != i + 1) {
                return i + 1;
            }
        }
        // 没有数缺失，就是数组长度 + 1
        return length + 1;
    }


    private int firstMissingPositive2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int negativeCount = 0; // 统计负数的次数
        int repeatCount = 0; // 统计重复的正整数
        for (int i = 0; i < length; i++) {
            // 去掉负数的计算
            if (nums[i] > 0) {
                // 重复正整数的情况
                if (i > 0 && nums[i] == nums[i - 1]) {
                    repeatCount++;
                }
                // 应该出现的整数
                int correctNum = i + 1 - negativeCount - repeatCount;
                if (nums[i] != correctNum) {
                    // 开头或中间缺少整数的情况
                    return correctNum;
                }
            } else {
                negativeCount++;
            }
        }
        // 都是负数的情况
        if (negativeCount == length) {
            return 1;
        }
        // 按顺序的整数，返回最后一个整数+1
        return nums[length - 1] + 1;
    }
}
