package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/15 15:41
 * @description 剑指 Offer 47.礼物的最大价值
 * 
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question47 {

    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        // 初始化第一行
        for (int j = 1; j < column; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // 初始化第一列
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[row - 1][column - 1];
    }
}
