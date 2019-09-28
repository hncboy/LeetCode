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
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return list;
        }
        int column = matrix[0].length;
        int i = 0;

        // 统计矩阵的层数
        int count = (Math.min(row, column) + 1) / 2;
        // 从外向内按层遍历
        while (i < count) {
            // 从左到右遍历
            for (int j = i; j < column - i; j++) {
                list.add(matrix[i][j]);
            }
            // 从上到下遍历
            for (int j = i + 1; j < row - i; j++) {
                list.add(matrix[j][(column - 1) - i]);
            }
            // 从右往左遍历，如果这一层只有一行则不用打印
            for (int j = (column - 1) - (i + 1); j >= i && (row - 1 - i != i); j--) {
                list.add(matrix[(row - 1) - i][j]);
            }
            // 从下往上遍历，如果这一层只有一列则不用打印
            for (int j = (row - 1) - (i + 1); j >= i + 1 && (column - 1 - i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;
    }
}
