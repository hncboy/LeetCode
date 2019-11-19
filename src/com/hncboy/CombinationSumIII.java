package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/19 15:22
 * @description 216.组合总和 III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII c = new CombinationSumIII();
        System.out.println(c.combinationSum3(3, 7));
        System.out.println(c.combinationSum3(3, 9));
        System.out.println(c.combinationSum3(2, 18));
        System.out.println(c.combinationSum3(3, 15));
    }

    private List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), 1, k, 0, n);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> sub, int start, int count, int target, int n) {
        if (target > n || sub.size() > count) {
            return;
        }
        if (sub.size() == count && target == n) {
            result.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (target + i > n) {
                break;
            }

            sub.add(i);
            backTrack(result, sub, i + 1, count, target + i, n);
            sub.remove(sub.size() - 1);
        }
    }
}
