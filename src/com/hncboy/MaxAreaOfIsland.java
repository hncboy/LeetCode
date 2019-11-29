package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/29 10:01
 * @description 695.岛屿的最大面积
 *
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class MaxAreaOfIsland {

    private int maxIslandArea = 0;
    private int currentIslandArea = 0;

    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        int[][] grid1 = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid2 = {{1}};
        int[][] grid3 = {{0}};
        System.out.println(m.maxAreaOfIsland(grid1));
        //System.out.println(m.maxAreaOfIsland(grid2));
        //System.out.println(m.maxAreaOfIsland(grid3));
    }

    /**
     * 时间复杂度：O(row*column)
     * 空间复杂度：O(1)
     * @param grid
     * @return
     */
    private int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    currentIslandArea = 0;
                    getMaxIslandArea(grid, i, j);
                    maxIslandArea = Math.max(maxIslandArea, currentIslandArea);
                }
            }
        }
        return maxIslandArea;
    }

    private void getMaxIslandArea(int[][] grid, int x, int y) {
        if (x != -1 && x != grid.length && y != -1 && y != grid[0].length && grid[x][y] == 1) {
            grid[x][y] = ++currentIslandArea + 1;
            // 上下左右四个方向
            getMaxIslandArea(grid, x + 1, y);
            getMaxIslandArea(grid, x - 1, y);
            getMaxIslandArea(grid, x, y - 1);
            getMaxIslandArea(grid, x, y + 1);
        }
    }
}
