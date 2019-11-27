package com.hncboy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/11/27 10:40
 * @description 697.数组的度
 *
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 示例 2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 */
public class DegreeOfAnArray {

    public static void main(String[] args) {
        DegreeOfAnArray d = new DegreeOfAnArray();
        System.out.println(d.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(d.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    private int findShortestSubArray(int[] nums) {
        // 该数第一次出现的索引
        Map<Integer, Integer> left = new HashMap<>();
        // 该数最后一次出现的索引
        Map<Integer, Integer> right = new HashMap<>();
        // 该数出现的次数
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            left.putIfAbsent(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int result = nums.length;
        // 出现的最大频度
        int degree = Collections.max(count.values());
        // 遍历所有 key
        for (int key : count.keySet()) {
            // 如果该数能达到最大频度
            if (count.get(key) == degree) {
                // 更新最小子串
                result = Math.min(result, right.get(key) - left.get(key) + 1);
            }
        }
        return result;
    }
}
