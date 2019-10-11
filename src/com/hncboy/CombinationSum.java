package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/11 8:52
 * @description 39.组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] candidates1 = new int[]{2, 3, 6, 7};
        int[] candidates2 = new int[]{2, 3, 5};

        System.out.println(c.combinationSum(candidates1, 7));
        c.result.clear();
        System.out.println(c.combinationSum(candidates2, 8));
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序过后利于剪枝
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, new ArrayList<>(), 0);
        return result;
    }

    /**
     * 回溯
     *
     * @param candidates
     * @param current
     * @param target
     * @param sub
     * @param index
     */
    private void backTrack(int[] candidates, int current, int target, List<Integer> sub, int index) {
        if (current == target) {
            result.add(new ArrayList<>(sub));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (current + candidates[i] > target) {
                break;
            }
            sub.add(candidates[i]);
            backTrack(candidates, current + candidates[i], target, sub, i);
            sub.remove(sub.size() - 1);
        }
    }
}
