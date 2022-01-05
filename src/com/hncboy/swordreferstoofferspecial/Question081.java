package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/1/5 9:29
 * 剑指 Offer II 081.允许重复选择元素的组合
 * 
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，
 * 找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * 示例 1：
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 *
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 * 示例 4：
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 *
 * 示例 5：
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 *
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *  
 * 注意：本题与主站 39 题 {@link com.hncboy.CombinationSum} 相同： https://leetcode-cn.com/problems/combination-sum/
 *
 * 通过次数 6,825 提交次数 8,695
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Ygoe9J
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question081 {

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (current + candidates[i] > target) {
                break;
            }
            sub.add(candidates[i]);
            backTrack(candidates, current + candidates[i], target, sub, i);
            sub.remove(sub.size() - 1);
        }
    }
}
