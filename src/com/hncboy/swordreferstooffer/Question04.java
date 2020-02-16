package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/2/16 14:27
 * @description 面试题04.二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
 *  
 *
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */
public class Question04 {

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
