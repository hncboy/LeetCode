package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/16 14:39
 * @description 42.接雨水
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap2(height));
    }

    /**
     * 暴力解法，两边最大高度的较小值减去当前高度的值
     * @param height
     * @return
     */
    private int trap2(int[] height) {
        int result = 0;
        int length = height.length;
        for (int i = 1; i < length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            result += Math.min(maxLeft, maxRight) - height[i];
        }
        return result;
    }

    private int trap1(int[] height) {
        int result = 0;
        int left = 0;
        int right = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            left = Math.max(left, height[i]);
            right = Math.max(right, height[length - 1 - i]);
            result = result + left + right - height[i];
        }
        return result - length * left;
    }
}
