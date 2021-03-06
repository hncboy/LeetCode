package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/9/28 13:56
 * @description 54.螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        // 遍历四个方向循环打印
        while (true) {
            // 从左到右遍历
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // 边界收缩，去掉上边界，top+1，判断是否打印完毕
            if (++top > bottom) {
                break;
            }

            // 从上到下遍历
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // 边界收缩，去掉右边界，right-1，判断是否打印完毕
            if (left > --right) {
                break;
            }

            // 从右往左遍历
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            // 边界收缩，去掉下边界，bottom-1，判断是否打印完毕
            if (top > --bottom) {
                break;
            }

            // 从下往上遍历
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            // 边界收缩，去掉左边界，left+1，判断是否打印完毕
            if (++left > right) {
                break;
            }
        }
        return result;
    }
}
