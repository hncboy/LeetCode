package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/9 15:10
 * @description 74.搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class SearchA2dMatrix {

    public static void main(String[] args) {
        SearchA2dMatrix s = new SearchA2dMatrix();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(s.searchMatrix(matrix, 3));
        System.out.println(s.searchMatrix(matrix, 13));
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int column = matrix[0].length;

        // 二分查找
        int left = 0;
        int right = row * column - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = matrix[mid / column][mid % column];
            if (target == value) {
                return true;
            }
            if (target < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
