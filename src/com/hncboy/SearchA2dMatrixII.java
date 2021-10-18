package com.hncboy;

/**
 * @author hncboy
 * @date 2020/2/16 14:30
 * @description 240.搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class SearchA2dMatrixII {

    private boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;

        // 从矩阵的左下角开始遍历
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                // 如果值大于 target，则往上移动
                i--;
            } else if (matrix[i][j] < target) {
                // 如果值小于 target，则往右移动
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
