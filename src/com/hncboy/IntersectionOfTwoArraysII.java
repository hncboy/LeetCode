package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/10/14 8:34
 * @description 350.两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        int[] nums11 = new int[]{1, 2, 2, 1};
        int[] nums21 = new int[]{2, 2};
        int[] nums12 = new int[]{4, 9, 5};
        int[] nums22 = new int[]{9, 4, 9, 8, 4};
        int[] nums13 = new int[]{1};
        int[] nums23 = new int[]{1};
        System.out.println(Arrays.toString(i.intersect(nums11, nums21)));
        System.out.println(Arrays.toString(i.intersect(nums12, nums22)));
        System.out.println(Arrays.toString(i.intersect(nums13, nums23)));
    }

    private int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }

        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)) {
                list2.add(num);
                list1.remove(Integer.valueOf(num));
            }
        }

        int[] result = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            result[i] = list2.get(i);
        }
        return result;
    }
}
