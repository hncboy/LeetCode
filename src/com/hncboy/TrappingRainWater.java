package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/16 14:39
 * @description 42.接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap1(height));
    }

    /**
     * 暴力解法
     *
     * @param height
     * @return
     */
    private int trap2(int[] height) {
        int result = 0;
        // 遍历所有柱子的高度
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            // 遍历当前柱子左边的最大高度
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // 遍历当前柱子右边的最大高度
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            // 当前柱子能容纳的雨水量为 两边最大高度的较小值减去当前高度的值
            result += Math.min(maxLeft, maxRight) - height[i];
        }
        return result;
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    private int trap1(int[] height) {
        int result = 0;
        int maxLeft = 0;
        int[] maxRights = new int[height.length];

        // 存放 maxRight[i] 右边的最大值
        for (int i = height.length - 2; i >= 0; i--) {
            maxRights[i] = Math.max(maxRights[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            // 因为从左到右遍历，所有可以每次遍历都更新左边最大值，重新遍历
            maxLeft = Math.max(maxLeft, height[i - 1]);
            // 当前柱子能容纳的雨水量为 两边最大高度的较小值减去当前高度的值
            int minLeftRight = Math.min(maxLeft, maxRights[i]);
            if (minLeftRight > height[i]) {
                result += minLeftRight - height[i];
            }
        }
        return result;
    }
}
