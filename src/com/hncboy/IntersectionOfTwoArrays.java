package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2020/1/1 16:27
 * @description 349.两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(i.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(i.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    private int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        // 求两个集合的交集
        set1.retainAll(set2);

        int [] result = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            result[i++] = num;
        }
        return result;
    }
}
