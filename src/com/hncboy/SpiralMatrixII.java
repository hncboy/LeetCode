package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/11/18 9:51
 * @description 59.螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        SpiralMatrixII s = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(s.generateMatrix(3)));
    }

    private int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int[][] result = new int[n][n];

        int count = 1;
        while (count <= n * n) {
            // 左->右
            for (int i = left; i <= right; i++) {
                result[top][i] = count++;
            }
            top++;

            // 上->下
            for (int i = top; i <= bottom; i++) {
                result[i][right] = count++;
            }
            right--;

            // 右->左
            for (int i = right; i >= left; i--) {
                result[bottom][i] = count++;
            }
            bottom--;

            // 下->上
            for (int i = bottom; i >= top; i--) {
                result[i][left] = count++;
            }
            left++;
        }
        return result;
    }
}
