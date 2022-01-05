package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/1/5 9:43
 * 剑指 Offer II 082.含有重复元素集合的组合
 * 
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * 提示:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * 注意：本题与主站 40 题 {@link com.hncboy.CombinationSumII} 相同： https://leetcode-cn.com/problems/combination-sum-ii/
 * 通过次数 5,362 提交次数 8,274
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sjJUc
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question082 {

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序过后利于剪枝
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, new ArrayList<>(), 0);
        return result;
    }

    /**
     * 回溯
     */
    private void backTrack(int[] candidates, int current, int target, List<Integer> sub, int index) {
        if (current == target) {
            result.add(new ArrayList<>(sub));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 剪枝，最小的大于目标值时，结束循环
            if (current + candidates[i] > target) {
                break;
            }
            // 去除重复的组合
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sub.add(candidates[i]);
            backTrack(candidates, current + candidates[i], target, sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
