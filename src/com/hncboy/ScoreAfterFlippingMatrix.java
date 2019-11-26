package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/26 11:16
 * @description 861.翻转矩阵后的得分
 *
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *
 *
 * 示例：
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *  
 * 提示：
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 */
public class ScoreAfterFlippingMatrix {

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix s = new ScoreAfterFlippingMatrix();
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(s.matrixScore(A));
    }

    /**
     * 空间复杂度：O(1)
     * 时间复杂度：O(row*column)
     *
     * @param A
     * @return
     */
    private int matrixScore(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        int result = 0;
        // 取最大时，必须将最高位翻转为 1，也就是第一列翻转为 1，因为 1000>0111
        for (int c = 0; c < column; c++) {
            int count = 0;
            // 遍历列中的每一行，统计每一列中 0 的数量
            for (int r = 0; r < row; r++) {
                // 每行第一列中，A[r][c] ^ A[r][0] = 0，0 的数量为 0，第二列开始统计 0 的数量。
                // 该行第一列为0的话：需要翻转
                // 因为0^1=1，所以结果为1的数量就是翻转后0的数量
                // 因为0^0=0，所以结果为0的数量就是翻转后1的数量
                // 该行第一列为1的话：不需要翻转
                // 因为1^1=0，所以结果为1的数量就是未翻转时0的数量
                // 因为1^0=1，所以结果为0的数量就是未翻转时0的数量
                count += A[r][c] ^ A[r][0];
            }
            // 按列计算结果，取每列中0或1最多的数量统计
            result += Math.max(count, row - count) * (1 << (column - c - 1));
        }
        return result;
    }
}
