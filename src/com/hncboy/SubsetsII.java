package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/18 11:38
 * @description 90.子集 II
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII s = new SubsetsII();
        int[] nums = {1, 2, 3};
        System.out.println(s.subsetsWithDup1(nums));
    }

    /**
     * 回溯
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, 0, nums, new ArrayList<>());
        return result;
    }

    private void backTrack(List<List<Integer>> result, int start, int[] nums, List<Integer> sub) {
        result.add(new ArrayList<>(sub));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            sub.add(nums[i]);
            backTrack(result, i + 1, nums, sub);
            sub.remove(sub.size() - 1);
        }
    }

    private List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int repeatCount = 0;
            // 记录重复的数字
            while ((i + 1 < nums.length) && nums[i + 1] == nums[i]) {
                repeatCount++;
                i++;
            }

            int prevSize = result.size();
            // 遍历之前结果的集
            for (int j = 0; j < prevSize; j++) {
                List<Integer> sub = new ArrayList<>(result.get(j));
                // 将重复的数字插入每个子集
                for (int k = 0; k <= repeatCount; k++) {
                    sub.add(nums[i]);
                    result.add(new ArrayList<>(sub));
                }
            }
        }
        return result;
    }
}
