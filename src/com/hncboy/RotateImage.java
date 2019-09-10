package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/9 20:36
 * @description 48.旋转图像
 * <p>
 * 定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
                /*15 13 2 5
                14 4 8 1
                12 3 6 9
                16 7 10 11*/
        rotate2(matrix);
    }

    private static void rotate2(int[][] matrix) {
        int length = matrix.length;
        int temp;
        // 从外圈开始旋转
        for (int i = 0; i < length / 2; i++) {
            // 向右旋转一圈
            for (int j = i; j < length - i - 1; j++) {
                temp = matrix[i][j];
                // 左下角的点移动到左上角
                matrix[i][j] = matrix[length - j - 1][i];
                // 右下角的点移动到左下角
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                // 右上角的点移动到右下角
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                // 左上角的点移动到右上角
                matrix[j][length - i - 1] = temp;
            }
        }
    }

    private static void rotate1(int[][] matrix) {
        int length = matrix.length;
        // 沿主对角线对称位置上的元素进行交换
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }
        // 将矩阵逆序
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[i][length - j - 1];
                matrix[i][length - j - 1] = matrix[i][j] ^ matrix[i][length - j - 1];
                matrix[i][j] = matrix[i][j] ^ matrix[i][length - j - 1];
            }
        }
    }
}
