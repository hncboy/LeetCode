package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/4 10:04
 * @description 867.转置矩阵
 *
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 示例 2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * 提示：
 * 1 <= A.length <= 1000
 */
public class TransposeMatrix {

    public static void main(String[] args) {
        TransposeMatrix t = new TransposeMatrix();
        int[][] A1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] A2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(t.transpose(A1)));
        System.out.println(Arrays.deepToString(t.transpose(A2)));
    }

    private int[][] transpose(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        int[][] B = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 将行上的数替换到列
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
