package com.hncboy.swordreferstoofferspecial;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2021/12/5 14:23
 * @description 剑指 Offer II 039.直方图最大矩形面积
 * 
 * 给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 *
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 *
 * 提示：
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 *  
 * 注意：本题与主站 84 题 {@link com.hncboy.LargestRectangleInHistogram}
 * 相同： https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 通过次数 3,734 提交次数 7,395
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/0ynMMM
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question039 {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // 栈顶存放 -1 表示开始
        stack.push(-1);
        int maxArea = 0;

        // 遍历所有柱子
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
