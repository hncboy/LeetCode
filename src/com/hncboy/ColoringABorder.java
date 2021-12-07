package com.hncboy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hncboy
 * @date 2021/12/7 8:45
 * @description 1034.边界着色
 * 
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。
 * 网格中的每个值表示该位置处的网格块的颜色。
 *
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 *
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 *
 * 示例 1：
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 *
 * 示例 2：
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 *
 * 示例 3：
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 *
 * 通过次数 6,329 提交次数 13,347
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coloring-a-border
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ColoringABorder {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        // 四个方向
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Deque<int[]> deque = new ArrayDeque<>();
        // 从 [row,col] 出发
        deque.addLast(new int[]{row, col});
        while (!deque.isEmpty()) {
            // 取出队列中的第一个点
            int[] point = deque.pollFirst();
            int x = point[0];
            int y = point[1];
            int count = 0;

            // 遍历四个方向
            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                // 越界
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                // 颜色不一样
                if (grid[x][y] != grid[nx][ny]) {
                    continue;
                }

                // 同一连通分量的格子 +1
                count++;

                // 判断 [nx,xy] 是否已经上色
                if (result[nx][ny] != 0) {
                    continue;
                }

                // 插入当前的连通分量的各自
                deque.addLast(new int[]{nx, ny});
            }

            // 如果当前各子与四连通方向均存在相邻的格子，则使用原始颜色，否则为边界格子，使用 color 上色
            result[x][y] = count == 4 ? grid[x][y] : color;
        }

        // 遍历所有格子，将未上色的格子进行上色
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = grid[i][j];
                }
            }
        }
        return result;
    }
}
