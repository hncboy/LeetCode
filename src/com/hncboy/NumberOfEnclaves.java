package com.hncboy;

/**
 * @author hncboy
 * @date 2022/2/13 15:20
 * 1020.飞地的数量
 *
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 * 示例 1：
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 *
 * 示例 2：
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 * 通过次数 34,609 提交次数 56,898
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        // 遍历遍一列、每一行
        for (int i = 0; i < column; i++) {
            dfs(grid, 0, i);
            dfs(grid, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, column - 1);
        }

        int result = 0;
        // 将每一块单元格的值相加，没访问到的陆地还是 1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result += grid[i][j];
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int x, int y) {
        int row = grid.length;
        int column = grid[0].length;
        // 超出边界或者是海洋或者是访问过的陆地
        if (x < 0 || y < 0 || x >= row || y >= column || grid[x][y] == 0) {
            return;
        }

        // 将被访问过的陆地值赋为 0
        grid[x][y] = 0;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
