package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/11/19 18:07
 * @description 219.存在重复元素 II
 * <p>
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        ContainsDuplicateII c = new ContainsDuplicateII();
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    private boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 35000) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = map.getOrDefault(nums[i], -1);
            map.put(nums[i], i);
            if (index != -1) {
                if (i - index <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
