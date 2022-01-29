package com.hncboy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hncboy
 * @date 2022/1/29 9:24
 * 1765.地图中的最高点
 *
 * 给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。
 * 如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
 * 如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
 * 你需要按照如下规则给每个单元格安排高度：
 *
 * 每个格子的高度都必须是非负的。
 * 如果一个格子是是 水域 ，那么它的高度必须为 0 。
 * 任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
 * 找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。
 *
 * 请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。
 *
 * 示例 1：
 * 输入：isWater = [[0,1],[0,0]]
 * 输出：[[1,0],[2,1]]
 * 解释：上图展示了给各个格子安排的高度。
 * 蓝色格子是水域格，绿色格子是陆地格。
 *
 * 示例 2：
 * 输入：isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * 输出：[[1,1,0],[0,1,1],[1,2,2]]
 * 解释：所有安排方案中，最高可行高度为 2 。
 * 任意安排方案中，只要最高高度为 2 且符合上述规则的，都为可行方案。
 *
 * 提示：
 * m == isWater.length
 * n == isWater[i].length
 * 1 <= m, n <= 1000
 * isWater[i][j] 要么是 0 ，要么是 1 。
 * 至少有 1 个水域格子。
 * 通过次数 6,436 提交次数 10,625
 */
public class MapOfHighestPeak {

    public int[][] highestPeak(int[][] g) {
        int row = g.length;
        int column = g[0].length;
        int[][] result = new int[row][column];

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (g[i][j] == 1) {
                    deque.addLast(new int[]{i, j});
                }
                result[i][j] = g[i][j] == 1 ? 0 : -1;
            }
        }

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int h = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                int[] point = deque.pollFirst();
                int x = point[0];
                int y = point[1];
                // 往四个方向都走一遍
                for (int[] di : directions) {
                    int nx = x + di[0];
                    int ny = y + di[1];

                    // 超出边界
                    if (nx < 0 || nx >= row || ny < 0 || ny >= column) {
                        continue;
                    }

                    // 水域
                    if (result[nx][ny] != -1) {
                        continue;
                    }

                    result[nx][ny] = h;
                    deque.addLast(new int[]{nx, ny});
                }
            }

            // 高度 +1
            h++;
        }
        return result;
    }
}
