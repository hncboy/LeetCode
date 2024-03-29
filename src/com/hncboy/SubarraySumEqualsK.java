package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/11/22 11:25
 * @description 560.和为K的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        System.out.println(s.subarraySum(new int[]{1, 2, 3, 2}, 3));
    }

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
