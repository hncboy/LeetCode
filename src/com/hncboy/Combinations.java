package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/27 14:10
 * @description 77.组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }

    private List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(n, k, 1, result, new ArrayList<>());
        return result;
    }

    private void backTrack(int n, int k, int start, List<List<Integer>> result, List<Integer> sub) {
        if (sub.size() == k) {
            result.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i <= n - (k - sub.size()) + 1; i++) {
            sub.add(i);
            backTrack(n, k, i + 1, result, sub);
            sub.remove(sub.size() - 1);
        }
    }
}
