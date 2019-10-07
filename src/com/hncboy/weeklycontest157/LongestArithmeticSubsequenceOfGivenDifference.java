package com.hncboy.weeklycontest157;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/10/6 10:57
 * @description 5214.最长定差子序列
 *
 * 给你一个整数数组 arr 和一个整数 difference，
 * 请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，
 * 并返回其中最长的等差子序列的长度。
 *
 *
 * 示例 1：
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 *
 * 示例 2：
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 *
 * 示例 3：
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 * 提示：
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 */
public class LongestArithmeticSubsequenceOfGivenDifference {

    public static void main(String[] args) {
        LongestArithmeticSubsequenceOfGivenDifference lasogd = new LongestArithmeticSubsequenceOfGivenDifference();
        System.out.println(lasogd.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(lasogd.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(lasogd.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }

    private int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        // 存放每个数字对应的最长等差子序列长度
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (!map.containsKey(num - difference)) {
                map.put(num - difference, 0);
            }
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, Math.max(map.get(num), map.get(num - difference) + 1));
            // 从每个数字对应的最长等差子序列长度取最大的长度
            max = Math.max(max, map.get(num));
        }
        return max;
    }
}
