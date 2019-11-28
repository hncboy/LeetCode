package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/11/28 8:51
 * @description 84.柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(l.largestRectangleArea(new int[]{5}));
        System.out.println(l.largestRectangleArea(new int[]{5, 5, 5, 5}));
        System.out.println(l.largestRectangleArea(new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // 栈顶存放 -1 表示开始
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            // 当栈顶不为 -1 且栈顶的数 >= 当前的数开始弹出栈顶并计算最大面积
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // 因为是单调递增栈，所以面积可以直接通过 heights[stack.pop()] * (i - stack.peek() - 1 计算
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        // 将最后剩下的单调递增的数依次弹出计算面积
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}
