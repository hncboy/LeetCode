package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/2 14:04
 * @description 835.图像重叠
 *
 * 给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
 * 我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。
 * 之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
 * （请注意，转换不包括向任何方向旋转。）
 *
 * 最大可能的重叠是什么？
 * 示例 1:
 * 输入：A = [[1,1,0],
 *           [0,1,0],
 *           [0,1,0]]
 *      B = [[0,0,0],
 *           [0,1,1],
 *           [0,0,1]]
 * 输出：3
 * 解释: 将 A 向右移动一个单位，然后向下移动一个单位。
 *
 * 注意: 
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */
public class ImageOverlap {

    public static void main(String[] args) {
        ImageOverlap i = new ImageOverlap();
        int[][] A1 = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] B1 = {{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};
        int[][] A2 = {{0, 1}, {1, 1}};
        int[][] B2 = {{1, 1}, {1, 0}};
        int[][] A3 = {{0, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 1}};
        int[][] B3 = {{1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}};
        System.out.println(i.largestOverlap1(A1, B1)); // 3
        System.out.println(i.largestOverlap1(A2, B2)); // 2
        System.out.println(i.largestOverlap1(A3, B3)); // 5
    }

    private int largestOverlap2(int[][] A, int[][] B) {
        int n = A.length;
        int[][] count = new int[2 * n + 1][2 * n + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int i2 = 0; i2 < n; i2++) {
                    for (int j2 = 0; j2 < n; j2++) {
                        if (B[i2][j2] == 1) {
                            count[i - i2 + n][j - j2 + n] += 1;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count.length; j++) {
                result = Math.max(result, count[i][j]);
            }
        }
        return result;
    }

    private int largestOverlap1(int[][] A, int[][] B) {
        int n = A.length;
        int max = 0;

        // 遍历能移动到所有位置
        for (int offsetX = 0; offsetX < n; offsetX++) {
            for (int offsetY = 0; offsetY < n; offsetY++) {
                int count1 = 0, count2 = 0;
                for (int i = offsetX; i < n; i++) {
                    for (int j = offsetY; j < n; j++) {
                        // 计算往右和下偏移，以(0,0)为起点，往右移动offsetX，往下移动offsetY
                        count1 += (A[(i - offsetX) % n][(j - offsetY) % n] & B[i][j]);
                        // 计算往左和上偏移，以(row-1,column-)为起点，往左移动offsetX，往上移动offsetY
                        count2 += (A[i % n][j % n] & B[i - offsetX][j - offsetY]);
                    }
                }
                max = Math.max(max, Math.max(count1, count2));
            }
        }
        return max;
    }
}
