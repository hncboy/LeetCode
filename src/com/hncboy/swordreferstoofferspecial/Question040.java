package com.hncboy.swordreferstoofferspecial;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2021/12/18 16:27
 * @description 剑指 Offer II 040.矩阵中最大的矩形
 * 
 * 给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 * 注意：此题 matrix 输入格式为一维 01 字符串数组。
 *
 * 示例 1：
 * 输入：matrix = ["10100","10111","11111","10010"]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 *
 * 示例 3：
 * 输入：matrix = ["0"]
 * 输出：0
 *
 * 示例 4：
 * 输入：matrix = ["1"]
 * 输出：1
 *
 * 示例 5：
 * 输入：matrix = ["00"]
 * 输出：0
 *
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *  
 * 注意：本题与主站 85 题 {@link com.hncboy.MaximalRectangle} 相同（输入参数格式不同）： https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/PLYXKQ
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question040 {

    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int result = 0;
        // 连续的列的高度
        int[] heights = new int[matrix[0].length()];
        // 遍历每行
        for (String row : matrix) {
            // 构建连续的列的高度
            buildHeights(row, heights);
            result = Math.max(result, largestRectangleArea(heights));
        }
        return result;
    }

    private void buildHeights(String row, int[] heights) {
        for (int i = 0; i < row.length(); i++) {
            if (row.charAt(i) == '1') {
                heights[i]++;
            } else {
                heights[i] = 0;
            }
        }
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // 栈顶存放 -1 表示开始
        stack.push(-1);
        int maxArea = 0;

        // 遍历所有列
        for (int i = 0; i < heights.length; ++i) {
            // 当栈顶不为 -1 且栈顶的数 >= 当前的数（开始递减），则弹出栈顶并计算最大面积
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // 因为是单调递增栈，所以对应当前栈顶元素的最大面积可以直接通过 heights[stack.pop()] * (i - stack.peek() - 1) 计算出来
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
