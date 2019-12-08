package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/1 11:05
 * @description 1277.统计全为 1 的正方形子矩阵
 *
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 * 示例 1：
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 *
 * 示例 2：
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 *  
 * 提示：
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 */
public class CountSquareSubmatricesWithAllOnes {

    public static void main(String[] args) {
        CountSquareSubmatricesWithAllOnes c = new CountSquareSubmatricesWithAllOnes();
        int[][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(c.countSquares(matrix));
    }

    private int countSquares(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 1) {
                    continue;
                }

                // 记录边长为 1 的正方形
                result++;
                if (j == 0) {
                    matrix[i][j] = 1;
                    continue;
                }
                matrix[i][j] = matrix[i][j - 1] + 1;

                // 第一行不计算面积
                if (i == 0) {
                    continue;
                }

                // 从第二行开始计算正方形面积，将当前位置作为正方行的右下角
                int maxWidth = matrix[i][j];
                int minWidth = maxWidth;
                // 沿着同一列往上遍历，遍历的同时宽度+1，但始终要小于最大宽度
                for (int row = i - 1, width = 2; row >= 0 && width <= maxWidth; row--, width++) {
                    minWidth = Math.min(matrix[row][j], minWidth);
                    // 当前遍历的宽度大于最小宽度时结束循环
                    if (minWidth < width) {
                        break;
                    }
                    result++;
                }
            }
        }
        return result;
    }
}
