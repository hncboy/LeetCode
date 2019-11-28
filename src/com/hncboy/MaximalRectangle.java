package com.hncboy;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/11/28 10:16
 * @description 85.最大矩形
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        MaximalRectangle m = new MaximalRectangle();
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(m.maximalRectangle2(matrix));
    }

    /**
     * 动态规划
     *
     * @param matrix
     * @return
     */
    private int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;

        // 存放从第一行到该行的最大连续最左边界，最小连续最右边界，最大连续最高距离
        int[] left = new int[column];
        int[] right = new int[column];
        int[] height = new int[column];

        Arrays.fill(right, column);

        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            int currLeft = 0;
            int currRight = column;

            // 从当前点出发，计算该点的最大高度
            // 计算方式：将上一行该列的最大高度 + 当前行该列1的个数作为 = 新的连续高度
            for (int j = 0; j < column; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }

            // 从当前点出发，计算该点的最左边界
            // 计算方式：Max(上一行该列最大左边界，当前行该列的最大左边界)，也就是距离该点最近的左连续点作为最左边界
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currLeft);
                } else {
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            // 从当前点出发，，计算该点的最右边界
            // 计算方式：Min(上一行该列最小右边界，当前行该列的最小右边界)，也就是距离该点最近的右连续点作为最右边界
            for (int j = column - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = column;
                    currRight = j;
                }
            }

            // 根据 (最小右边界-最大左边界)*最大高度 计算面积
            for (int j = 0; j < column; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxArea;
    }


    /**
     * 参考 84.柱状图中最大的矩形
     * 每增加一行，重新计算高度求最大面积
     *
     * @param matrix
     * @return
     */
    private int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            // 遍历完一行，更新高度，更新最大面积
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
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
