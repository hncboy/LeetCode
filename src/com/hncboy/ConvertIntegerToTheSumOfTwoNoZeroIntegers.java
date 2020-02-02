package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2020/1/11 22:25
 * @description 1314.矩阵区域和
 *
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，
 * 其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
 * i - K <= r <= i + K, j - K <= c <= j + K 
 * (r, c) 在矩阵内。
 *  
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 *
 * 示例 2：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 *  
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public static void main(String[] args) {
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] mat2 = {{67, 64, 78}, {99, 98, 38}, {82, 46, 46}, {6, 52, 55}, {55, 99, 45}};
        ConvertIntegerToTheSumOfTwoNoZeroIntegers c = new ConvertIntegerToTheSumOfTwoNoZeroIntegers();
        System.out.println(Arrays.deepToString(c.matrixBlockSum(mat1, 1)));
        System.out.println(Arrays.deepToString(c.matrixBlockSum(mat2, 3)));
    }

    private int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int column = mat[0].length;

        // 前缀和数组
        int[][] preSum = new int[row + 1][column + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 计算该位置前面的数的和
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + mat[i][j];
            }
        }

        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int x1 = Math.max(i - K, 0);
                int y1 = Math.max(j - K, 0);
                int x2 = Math.min(i + K, row - 1);
                int y2 = Math.min(j + K, column - 1);
                result[i][j] = preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
            }
        }
        return result;
    }
}
