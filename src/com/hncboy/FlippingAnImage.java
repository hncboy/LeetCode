package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/2 13:39
 * @description 832.翻转图像
 *
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 示例 2:
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * 说明:
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class FlippingAnImage {

    public static void main(String[] args) {
        FlippingAnImage f = new FlippingAnImage();
        int[][] A1 = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] A2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println(Arrays.deepToString(f.flipAndInvertImage(A1)));
        System.out.println(Arrays.deepToString(f.flipAndInvertImage(A2)));
    }

    private int[][] flipAndInvertImage(int[][] A) {
        int column = A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (column + 1) / 2; j++) {
                if (j == column - j - 1) {
                    A[i][j] ^= 1;
                    break;
                }
                if (A[i][j] == A[i][column - j - 1]) {
                    A[i][j] ^= 1;
                    A[i][column - j - 1] ^= 1;
                }
            }
        }
        return A;
    }
}
