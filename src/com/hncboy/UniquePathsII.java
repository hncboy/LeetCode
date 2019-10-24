package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/24 14:30
 * @description 63.不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsII {

    public static void main(String[] args) {
        UniquePathsII u = new UniquePathsII();
        int[][] obstacleGrid1 = new int[][]{
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        int[][] obstacleGrid2 = new int[][]{{0}, {1}};
        int[][] obstacleGrid3 = new int[][]{{1, 0}};
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid1));
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid2));
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid3));
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        // 存放到达对应位置的不同路径数量
        int[][] dp = new int[row][column];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                // 每条路径都是上方和左方两条路线的合计
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[row - 1][column - 1];
    }
}
