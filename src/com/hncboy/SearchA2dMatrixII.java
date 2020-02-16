package com.hncboy;

/**
 * @author hncboy
 * @date 2020/2/16 14:30
 * @description 240.搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
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
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class SearchA2dMatrixII {

    private boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target < matrix[i][mid]) {
                    right = mid - 1;
                } else if (target > matrix[i][mid]) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
