package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/3/15 16:23
 * @description 面试题 29.顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class Question29 {

    private int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int count = 0;
        int[] result = new int[(right + 1) * (bottom + 1)];

        // 遍历四个方向循环打印
        while (true) {
            // 从左到右遍历
            for (int i = left; i <= right; i++) {
                result[count++] = matrix[top][i];
            }
            // 边界收缩，去掉上边界，top+1，判断是否打印完毕
            if (++top > bottom) {
                break;
            }

            // 从上到下遍历
            for (int i = top; i <= bottom; i++) {
                result[count++] = matrix[i][right];
            }
            // 边界收缩，去掉右边界，right-1，判断是否打印完毕
            if (left > --right) {
                break;
            }

            // 从右往左遍历
            for (int i = right; i >= left; i--) {
                result[count++] = matrix[bottom][i];
            }
            // 边界收缩，去掉下边界，bottom-1，判断是否打印完毕
            if (top > --bottom) {
                break;
            }

            // 从下往上遍历
            for (int i = bottom; i >= top; i--) {
                result[count++] = matrix[i][left];
            }
            // 边界收缩，去掉左边界，left+1，判断是否打印完毕
            if (++left > right) {
                break;
            }
        }
        return result;
    }
}
