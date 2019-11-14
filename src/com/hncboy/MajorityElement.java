package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/11/14 20:30
 * @description 169.求众数
 *
 * 给定一个大小为 n 的数组，找到其中的众数。
 * 众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int[] nums1 = new int[]{3, 2, 3};
        int[] nums2 = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(m.majorityElement2(nums1));
        System.out.println(m.majorityElement2(nums2));
    }

    /**
     * 哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    private int majorityElement1(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }

    /**
     * Boyer-Moore 投票算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    private int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;

        // 根据众数出现的次数大于 n/2 的特性
        // 当选的数不是众数的时候，会被众数减到 0
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
