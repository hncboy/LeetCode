package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/10 19:59
 * @description 221.最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class MaximalSquare {

    public static void main(String[] args) {
        MaximalSquare m = new MaximalSquare();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(m.maximalSquare3(matrix));
    }

    /**
     * 暴力法
     * 时间复杂度：O((mn)^2)
     * 空间复杂度：O(1)
     *
     * @param matrix
     * @return
     */
    private int maximalSquare1(char[][] matrix) {
        int row = matrix.length;
        int column = row > 0 ? matrix[0].length : 0;
        int maxWidth = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    // 正方形的宽
                    int width = 1;
                    // 标记该行列是否全部是 1
                    boolean flag = true;

                    // 从标记为 1 的位置开始遍历
                    while (width + i < row && width + j < column && flag) {
                        for (int k = i; k <= width + i; k++) {
                            if (matrix[k][j + width] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        for (int k = j; k <= width + j; k++) {
                            if (matrix[i + width][k] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        width = flag ? width + 1 : width;
                    }
                    maxWidth = Math.max(maxWidth, width);
                }
            }
        }

        return maxWidth * maxWidth;
    }

    /**
     * 动态规划
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     *
     * @param matrix
     * @return
     */
    private int maximalSquare2(char[][] matrix) {
        int row = matrix.length;
        int column = row > 0 ? matrix[0].length : 0;
        // 存放该位置往前能组成的最大正方形宽度
        int[][] dp = new int[row + 1][column + 1];
        int maxWidth = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxWidth = Math.max(maxWidth, dp[i][j]);
                }
            }
        }
        return maxWidth * maxWidth;
    }

    /**
     * 动态规划优化
     * 时间复杂度：O(mn)
     * 空间复杂度：O(n)
     *
     * @param matrix
     * @return
     */
    private int maximalSquare3(char[][] matrix) {
        int row = matrix.length;
        int column = row > 0 ? matrix[0].length : 0;
        int[] dp = new int[column + 1];
        int maxWidth = 0;
        int prev = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxWidth = Math.max(maxWidth, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxWidth * maxWidth;
    }
}
