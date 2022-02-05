package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/6 14:38
 * 1219.黄金矿工
 *
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。
 * 每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 *
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *
 * 示例 1：
 * 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
 * 输出：24
 * 解释：
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * 一种收集最多黄金的路线是：9 -> 8 -> 7。
 *
 * 示例 2：
 * 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * 输出：28
 * 解释：
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
 *
 * 提示：
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * 最多 25 个单元格中有黄金。
 * 通过次数 19,938 提交次数 29,924
 */
public class PathWithMaximumGold {

    private int max = 0;

    public static void main(String[] args) {
        PathWithMaximumGold pwmg = new PathWithMaximumGold();
        int[][] grid1 = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int[][] grid2 = new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        int[][] grid3 = new int[][]{{1, 0, 7, 0, 0, 0}, {2, 0, 6, 0, 1, 0}, {3, 5, 6, 7, 4, 2}, {4, 3, 1, 0, 2, 0}, {3, 0, 5, 0, 20, 0}};
        int[][] grid4 = new int[][]{
                {0, 0, 34, 0, 5, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 21, 0, 0, 0, 0, 0},
                {0, 18, 0, 0, 8, 0, 0, 0, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {15, 0, 0, 0, 0, 22, 0, 0, 0, 21},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 0, 0, 0, 0, 38, 0}};
        pwmg.max = 0;
        System.out.println(pwmg.getMaximumGold(grid1));
        pwmg.max = 0;
        System.out.println(pwmg.getMaximumGold(grid2));
        pwmg.max = 0;
        System.out.println(pwmg.getMaximumGold(grid3));
        pwmg.max = 0;
        System.out.println(pwmg.getMaximumGold(grid4));
    }

    public int getMaximumGold(int[][] grid) {
        // 遍历所有黄金数目不为 0 的格子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 从不为 0 的格子开始开采
                if (grid[i][j] != 0) {
                    // 0 表示未开采，1 表示开采
                    int[][] status = new int[grid.length][grid[0].length];
                    // 初始格子为已开采状态
                    status[i][j] = 1;
                    // 将初始格子的值与初始最大值比较
                    max = Math.max(grid[i][j], max);
                    // 开始开采
                    getMaximumGold(grid, status, i, j, grid[i][j]);
                }
            }
        }
        return max;
    }

    private void getMaximumGold(int[][] grid, int[][] status, int x, int y, int num) {
        // 往四个方向开采
        miningGold(grid, status, x, y - 1, num);
        miningGold(grid, status, x, y + 1, num);
        miningGold(grid, status, x - 1, y, num);
        miningGold(grid, status, x + 1, y, num);
    }

    private void miningGold(int[][] grid, int[][] status, int x, int y, int num) {
        // 当开采的格子坐标在满足的范围内才进行开采
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            // 当前格子为未开采状态且黄金数量不为 0 才进行开采
            if (status[x][y] == 0 && grid[x][y] != 0) {
                // 开采当前格子
                status[x][y] = 1;
                // 获取开采后的黄金最大值
                max = Math.max(max, num + grid[x][y]);
                // 继续开采下个格子
                getMaximumGold(grid, status, x, y, num + grid[x][y]);
                // 将开采标记清除，方便下次开采
                status[x][y] = 0;
            }
        }
    }
}
