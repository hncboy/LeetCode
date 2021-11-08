package com.hncboy.swordreferstoofferspecial;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2021/11/8 9:55
 * @description 剑指 Offer II 010.和为 k 的子数组
 * 
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 *
 * 示例 2 :
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 *
 * 提示:
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/QTMn0o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question010 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prevSumMap = new HashMap<>();
        prevSumMap.put(0, 1);

        int result = 0;
        // 前缀和，将每个前缀和存入 prevSumMap
        int sum = 0;
        for (int num : nums) {
            sum += num;
            // 如果 prevSumMap 中存在 sum-k 的前缀和，则说明存在前缀和为 k 的
            if (prevSumMap.containsKey(sum - k)) {
                result += prevSumMap.get(sum - k);
            }
            prevSumMap.put(sum, prevSumMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
