package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/11/25 8:46
 * @description 661.图片平滑器
 *
 * 包含整数的二维矩阵 M 表示一个图片的灰度。
 * 你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 * 示例 1:
 * 输入:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 *
 * 注意:
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为 [1, 150]。
 */
public class ImageSmoother {

    public static void main(String[] args) {
        ImageSmoother i = new ImageSmoother();
        int[][] M = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(i.imageSmoother(M)));
    }

    private int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int column = M[0].length;
        int[][] result = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = smooth(M, i, j);
            }
        }
        return result;
    }

    private int smooth(int[][] M, int x, int y) {
        int row = M.length;
        int column = M[0].length;
        int sum = 0;
        int count = 0;

        // 遍历包含(x,y)的9个单元格
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // 判断单元格是否在二维数组内
                if (x + i >= 0 && x + i < row && y + j >= 0 && y + j < column) {
                    count++;
                    sum += M[x + i][y + j];
                }
            }
        }

        return sum / count;
    }
}
