package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/20 15:17
 * @description 414.第三大的数
 *
 * 给定一个非空数组，返回此数组中第三大的数。
 * 如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 *
 * 示例 2:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 *
 * 示例 3:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        ThirdMaximumNumber t = new ThirdMaximumNumber();
        System.out.println(t.thirdMax(new int[]{3, 2, 1}));
        System.out.println(t.thirdMax(new int[]{1, 2}));
        System.out.println(t.thirdMax(new int[]{2, 2, 3, 1}));
    }

    private int thirdMax(int[] nums) {
        // 维护三个最大的数
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
