package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/29 10:56
 * @description 64.最小路径和
 *
 * 定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }

    private int minPathSum(int[][] grid) {
        int m = grid.length;
        if (grid.length == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 只能向右或向下移动
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == 0) {
                    // dp[0][0] 就是 grid[0][0]
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    // 最上面的一条线，只有一直向右移动一种情况
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    // 最做面的一条线，只有一直向下移动一种情况
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    // 除此之外，到达 grid[i][j] 的最小路径为当前 (i,j) 的数以及
                    // 加上到达 Min(上边的位置，左边的位置) 最小路径
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
