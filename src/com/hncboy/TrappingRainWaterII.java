package com.hncboy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hncboy
 * @date 2021/11/3 8:57
 * @description 407.接雨水 II
 * 
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 * 示例 1:
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 *
 * 示例 2:
 * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 *
 * 提示:
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TrappingRainWaterII {

    public static void main(String[] args) {
        TrappingRainWaterII t = new TrappingRainWaterII();
        System.out.println(t.trapRainWater(new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}));
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        // 优先队列，按雨水高度排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visit = new boolean[m][n];

        // 遍历第一行、第一列、最后一行、最后一列，在四周构建一座围城
        // 遍历访问第一行和最后一行的雨水高度
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{0, i, heightMap[0][i]});
            queue.add(new int[]{m - 1, i, heightMap[m - 1][i]});
            visit[0][i] = visit[m - 1][i] = true;
        }
        // 遍历访问第一列和最后一列的雨水高度
        for (int i = 1; i < m - 1; i++) {
            queue.add(new int[]{i, 0, heightMap[i][0]});
            queue.add(new int[]{i, n - 1, heightMap[i][n - 1]});
            visit[i][0] = visit[i][n - 1] = true;
        }

        // 上下左右 4 个位置的路径
        int[][] distances = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int result = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int h = poll[2];

            // 遍历 4 个方向的路径
            for (int[] distance : distances) {
                int nx = x + distance[0];
                int ny = y + distance[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                if (h > heightMap[nx][ny]) {
                    result += h - heightMap[nx][ny];
                }
                queue.add(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
                visit[nx][ny] = true;
            }
        }
        return result;
    }
}
