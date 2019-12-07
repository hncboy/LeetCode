package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/9/6 8:24
 * @description 15.三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [[-1, 0, 1], [-1, -1, 2]]
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ll = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            // 跳过可能重复的答案
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1; // 最左下标
                int right = length - 1; // 最右下标
                while (left < right) {
                    // 符合题意的条件
                    if (nums[left] + nums[right] == -nums[i]) {
                        ll.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // 跳过重复的 left
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 跳过重复的 right
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < -nums[i]) {
                        // 跳过重复的 left
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else {
                        // 跳过重复的 right
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return ll;
    }
}
