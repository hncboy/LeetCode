package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/13 13:00
 * @description 11.盛最多水的容器
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int maxCapacity = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            maxCapacity = Math.max(maxCapacity, (j - i) * Math.min(height[i], height[j]));
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return maxCapacity;
    }
}
