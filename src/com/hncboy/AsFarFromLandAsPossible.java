package com.hncboy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2020/3/29 20:33
 * @description 1162.地图分析
 *
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。
 * 其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？
 * 请返回该海洋区域到离它最近的陆地区域的距离。
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：
 * (x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * 示例 1：
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 * 示例 2：
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 */
public class AsFarFromLandAsPossible {

    private int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int column = grid[0].length;

        // 遍历所有单元格，将陆地加入队列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        boolean hasOcean = false;
        int[] point = null;

        // 从陆地开始，一圈一圈的遍历海洋
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0];
            int y = point[1];

            // 遍历该陆地四周的单元格，将海洋加入队列
            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];
                if (moveX < 0 || moveX >= row || moveY < 0 || moveY >= column || grid[moveX][moveY] != 0) {
                    continue;
                }

                // 通过将原单元格中的值+1来表示该海洋被访问
                grid[moveX][moveY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[] {moveX, moveY});
            }
        }

        // 如果没有陆地或海洋
        if (point == null || !hasOcean) {
            return -1;
        }

        // 最后一次遍历到的海洋
        return grid[point[0]][point[1]] - 1;
    }
}
