package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/10/28 8:52
 * @description 18.四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum f = new FourSum();
        int[] nums1 = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
        int[] nums2 = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        int[] nums3 = new int[]{-5, 5, 4, -3, 0, 0, 4, -2};
        System.out.println(f.fourSum1(nums1, -11));
        System.out.println(f.fourSum1(nums2, 0));
        System.out.println(f.fourSum1(nums3, 4));
    }

    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;

        // 第一个数 nums[i]
        for (int i = 0; i < length - 3; i++) {
            // 最小的数大于 target/4，结束循环
            if (nums[i] > target / 4 || nums[length - 1] < target / 4) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 第二个数 nums[j]
            for (int j = i + 1; j < length - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 固定 nums[i] 和 nums[j]，用 left 和 right 指针寻找另外两个数
                // 第三个数 nums[left]
                int left = j + 1;
                // 第四个数 nums[right]
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 跳过重复的 nums[left] 和 nums[right]
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 回溯
     *
     * @param nums
     * @param target
     * @return
     */
    private List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> resultSet = new HashSet<>();
        backTrack(nums, target, 0, resultSet, new ArrayList<>());
        return new ArrayList<>(resultSet);
    }

    private void backTrack(int[] nums, int target, int start, Set<List<Integer>> resultSet, List<Integer> sub) {
        if (target != 0 && sub.size() == 4) {
            return;
        }
        if (target == 0 && sub.size() == 4) {
            resultSet.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target >= 0 && nums[i] > target) {
                break;
            }
            sub.add(nums[i]);
            backTrack(nums, target - nums[i], i + 1, resultSet, sub);
            sub.remove(sub.size() - 1);
        }
    }
}
