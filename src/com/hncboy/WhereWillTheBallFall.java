package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2022/2/24 9:06
 * 1706.球会落何处
 *
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 *
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 *
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 *
 * 示例 1：
 * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * 输出：[1,-1,-1,-1,-1]
 * 解释：示例如图：
 * b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
 * b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 *
 * 示例 2：
 * 输入：grid = [[-1]]
 * 输出：[-1]
 * 解释：球被卡在箱子左侧边上。
 *
 * 示例 3：
 * 输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
 * 输出：[0,1,2,3,4,-1]
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 为 1 或 -1
 * 通过次数 7,050 提交次数 10,971
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/where-will-the-ball-fall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WhereWillTheBallFall {

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int column = 0; column < n; column++) {
            // 球的初始列
            int currColumn = column;
            // 遍历所有行
            for (int[] row : grid) {
                // 如果挡板向右偏，则球会向右移动；如果挡板左偏，则球会向左移动。
                int direction = row[currColumn];
                // 移动球
                currColumn += direction;
                // 球到达侧边或 V 形
                if (currColumn < 0 || currColumn == n || row[currColumn] != direction) {
                    currColumn = -1;
                    break;
                }
            }

            // 成功到达底部
            if (currColumn >= 0) {
                result[column] = currColumn;
            }
        }
        return result;
    }
}
