package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/31 20:02
 * @description 52.N皇后 II
 */
public class NQueensII {

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));
    }

    private int totalNQueens(int n) {
        return backTrack(0, n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], 0);
    }

    /**
     * @param row           当前计算的是第几行
     * @param column        判断当前列是否可放置皇后，n 种情况
     * @param leftDiagonal  判断左对角线是否可放置皇后，2*n - 1 种情况
     * @param rightDiagonal 判断右对角线是否可放置皇后，2*n - 1 种情况
     * @param count         满足的情况数量
     */
    private int backTrack(int row, int n, boolean[] column, boolean[] leftDiagonal, boolean[] rightDiagonal, int count) {
        for (int i = 0; i < n; i++) {
            // 当前列，左对角线，右对角线是否符合放置皇后
            if (column[i] || leftDiagonal[n - 1 - row + i] || rightDiagonal[row + i]) {
                continue;
            }

            // 当前位置放置皇后，将对应的列，左对角线，右对角线作标记
            column[i] = true;
            leftDiagonal[n - 1 - row + i] = true;
            rightDiagonal[row + i] = true;

            // 满足情况的数量
            if (row + 1 == n) {
                count++;
            } else {
                // 继续判断下一行皇后的放置
                count = backTrack(row + 1, n, column, leftDiagonal, rightDiagonal, count);
            }

            column[i] = false;
            leftDiagonal[n - 1 - row + i] = false;
            rightDiagonal[row + i] = false;
        }

        return count;
    }
}
