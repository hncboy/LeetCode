package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/9/18 13:28
 * @description 46.全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    private List<List<Integer>> listList = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        System.out.println(new Permutations().permute(nums));
    }

    private List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return listList;
    }

    /**
     * 回溯
     *
     * @param nums
     */
    private void backtrack(int[] nums) {
        int length = nums.length;
        if (list.size() == length) {
            listList.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backtrack(nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
