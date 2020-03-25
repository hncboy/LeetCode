package com.hncboy;

/**
 * @author hncboy
 * @date 2020/3/25 15:39
 * @description 892.三维形体的表面积
 *
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 *
 * 示例 1：
 * 输入：[[2]]
 * 输出：10
 *
 * 示例 2：
 * 输入：[[1,2],[3,4]]
 * 输出：34
 *
 * 示例 3：
 * 输入：[[1,0],[0,2]]
 * 输出：16
 *
 * 示例 4：
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 *
 * 示例 5：
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 * 提示：
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
public class SurfaceAreaOf3dShapes {

    private int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int level = grid[i][j];
                if (level > 0) {
                    // 4个侧面*个数+底面+顶面
                    area += level * 4 + 2;
                    // 减去与左边立方体相贴的两份表面积
                    area -= i > 0 ? Math.min(level, grid[i - 1][j]) * 2 : 0;
                    // 减去与上边立方体相贴的两份表面积
                    area -= j > 0 ? Math.min(level, grid[i][j - 1]) * 2 : 0;
                }
            }
        }
        return area;
    }
}
