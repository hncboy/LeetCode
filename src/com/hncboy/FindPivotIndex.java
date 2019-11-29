package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/29 13:05
 * @description 724.寻找数组的中心索引
 *
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例 1:
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 *
 * 示例 2:
 * 输入:
 * nums = [1, 2, 3]
 * 输出: -1
 * 解释:
 * 数组中不存在满足此条件的中心索引。
 *
 * 说明:
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class FindPivotIndex {

    public static void main(String[] args) {
        FindPivotIndex f = new FindPivotIndex();
        System.out.println(f.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(f.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(f.pivotIndex(new int[]{-1, -1, 0, 1, 1, 0}));
        System.out.println(f.pivotIndex(new int[]{-1, -1, -1, -1, -1}));
    }

    private int pivotIndex(int[] nums) {
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
            rightSum -= nums[i + 1];
        }

        return leftSum == rightSum ? nums.length - 1 : -1;
    }
}
