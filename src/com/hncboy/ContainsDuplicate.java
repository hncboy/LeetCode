package com.hncboy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2019/10/6 10:02
 * @description 217.存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。
 * 如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(new ContainsDuplicate().containsDuplicate2(nums));
    }

    /**
     * 排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    private boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * hash 表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    private boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
