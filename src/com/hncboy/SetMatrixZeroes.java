package com.hncboy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2019/9/18 12:29
 * @description 73.矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2:
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 0, 2},
                {1, 3, 1, 5}};
        new SetMatrixZeroes().setZeroes1(matrix);
        new SetMatrixZeroes().setZeroes2(matrix);
    }

    /**
     * 方法1 用 O(m+n) 额外存储空间方法
     *
     * @param matrix
     */
    private void setZeroes1(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        Set<Integer> zeroColumnSet = new HashSet<>();
        Set<Integer> zeroRowSet = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    zeroRowSet.add(i);
                    zeroColumnSet.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (zeroRowSet.contains(i) || zeroColumnSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 方法2 用 O(1) 额外存储空间方法
     *
     * @param matrix
     */
    private void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean zeroRowFlag = false;
        boolean zeroColumnFlag = false;

        // 判断第一列是否有 0
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                zeroColumnFlag = true;
                break;
            }
        }

        // 判断第一行是否有 0
        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == 0) {
                zeroRowFlag = true;
                break;
            }
        }

        // 将第一行和第一列作为标志位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    // 将第一行和第一列指定数置为 0
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                // 当第一行或第一列有数字为 0 时
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    // 将具体的数置为 0
                    matrix[i][j] = 0;
                }
            }
        }

        if (zeroRowFlag) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }

        if (zeroColumnFlag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
