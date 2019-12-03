package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/3 11:56
 * @description 840.矩阵中的幻方
 *
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 * 示例：
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 * 而这一个不是：
 * 384
 * 519
 * 762
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 *
 * 提示:
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */
public class MagicSquaresInGrid {

    public static void main(String[] args) {
        MagicSquaresInGrid m = new MagicSquaresInGrid();
        int[][] grid = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        System.out.println(m.numMagicSquaresInside(grid));
    }

    private int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isValid(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        // 中间的数一定为 5
        if (grid[i + 1][j + 1] != 5) {
            return false;
        }

        // 判断 1-9 是否重复
        int[] nums = new int[10];
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                if (grid[x][y] > 0 && grid[x][y] < 10) {
                    nums[grid[x][y]] = 1;
                }
            }
        }
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        if (count != 9) {
            return false;
        }

        // 判断第一行、第三行和第一列、第三列的和是否为 15
        return grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15
                && grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15
                && grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15
                && grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15;
    }
}
