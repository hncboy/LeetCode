package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/10 9:21
 * @description 78.子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Subsets().subsets1(nums));
    }

    /**
     * 位运算
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 长度为 n 的数组，都有 2^n 个子集
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            // 遍历每个数
            for (int j = 0; j < nums.length; j++) {
                // 从低位到高位逐个取二进制位，如果为 1，则将对应的该数放入集合
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            result.add(sub);
        }
        return result;
    }

    /**
     * 枚举
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        // 遍历所有数
        for (int num : nums) {
            int subSize = result.size();
            // 遍历已有的集合，每次对之前的集合中增加当前的数
            for (int i = 0; i < subSize; i++) {
                List<Integer> list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }
}
