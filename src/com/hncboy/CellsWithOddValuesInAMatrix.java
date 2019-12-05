package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/5 9:24
 * @description 1252.奇数值单元格的数目
 *
 * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 *  
 *
 * 示例 1：
 * 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 *
 * 示例 2：
 * 输入：n = 2, m = 2, indices = [[1,1],[0,0]]
 * 输出：0
 * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 *
 * 提示：
 * 1 <= n <= 50
 * 1 <= m <= 50
 * 1 <= indices.length <= 100
 * 0 <= indices[i][0] < n
 * 0 <= indices[i][1] < m
 */
public class CellsWithOddValuesInAMatrix {

    public static void main(String[] args) {
        CellsWithOddValuesInAMatrix c = new CellsWithOddValuesInAMatrix();
        System.out.println(c.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
        System.out.println(c.oddCells(2, 2, new int[][]{{1, 1}, {0, 0}}));
    }

    private int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] columns = new int[m];

        for (int[] index : indices) {
            rows[index[0]]++;
            columns[index[1]]++;
        }

        int[][] counter = new int[2][2];

        for (int row : rows) {
            if ((row & 1) == 0) {
                counter[0][0]++;
            } else {
                counter[0][1]++;
            }
        }

        for (int column : columns) {
            if ((column & 1) == 0) {
                counter[1][0]++;
            } else {
                counter[1][1]++;
            }
        }
        // 只要该位置所属的行和列有一个为奇数，则该数为奇数
        // 奇数的行*偶数的列 + 偶数的行*奇数的列
        return counter[0][0] * counter[1][1] + counter[0][1] * counter[1][0];
    }
}
