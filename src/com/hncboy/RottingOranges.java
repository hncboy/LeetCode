package com.hncboy;

import java.util.LinkedList;

/**
 * @author hncboy
 * @date 2019/12/31 13:11
 * @description 994.腐烂的橘子
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 示例 1：
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 * 示例 2：
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 * 提示：
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class RottingOranges {

    public static void main(String[] args) {
        RottingOranges r = new RottingOranges();
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] grid3 = {{0, 2}};
        System.out.println(r.orangesRotting(grid1));
        System.out.println(r.orangesRotting(grid2));
        System.out.println(r.orangesRotting(grid3));
    }

    private int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[] dxRow = new int[]{0, 0, -1, 1};
        int[] dxCol = new int[]{-1, 1, 0, 0};

        LinkedList<Integer> visited = new LinkedList<>();
        // 遍历所有单元格，将烂橘子的位置放入 visited
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    visited.add(i * col + j);
                }
            }
        }

        int minutes = 0;
        // 取出最后一个烂橘子
        Integer last = visited.peekLast();
        while (!visited.isEmpty()) {
            int curr = visited.poll();
            // 取出当前烂橘子的坐标
            int currRow = curr / col;
            int currCol = curr % col;
            // 遍历烂橘子的四个方向
            for (int i = 0; i < dxRow.length; i++) {
                int nextRow = currRow + dxRow[i];
                int nextCol = currCol + dxCol[i];
                // 如果周围有新鲜橘子，则腐烂周围的新鲜橘子，并将该橘子加入 visited
                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && grid[nextRow][nextCol] == 1) {
                    visited.add(nextRow * col + nextCol);
                    grid[nextRow][nextCol] = 2;
                }
            }
            // 当 curr==last 时，表示该一分钟里，与腐烂的橘子周围的橘子已经被腐烂
            if (curr == last && !visited.isEmpty()) {
                minutes++;
                last = visited.peekLast();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}
