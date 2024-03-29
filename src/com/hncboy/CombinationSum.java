package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/11 8:52
 * 39.组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
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
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 * 通过次数 385,305 提交次数 529,591
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] candidates1 = new int[]{2, 3, 6, 7};
        int[] candidates2 = new int[]{2, 3, 5};

        System.out.println(c.combinationSum(candidates1, 7));
        c.result.clear();
        System.out.println(c.combinationSum(candidates2, 8));
    }

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
