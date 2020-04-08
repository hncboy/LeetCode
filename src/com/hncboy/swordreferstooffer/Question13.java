package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/4/8 21:05
 * @description 面试题 13.机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 1：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Question13 {

    private int movingCount(int m, int n, int k) {
        return backTrack(new boolean[m][n], 0, 0, k);
    }

    private int backTrack(boolean[][] visited, int i, int j, int threshold) {
        if (i >= 0 && i < visited.length && j >= 0 && j < visited[0].length) {
            if (sum(i) + sum(j) <= threshold && !visited[i][j]) {
                visited[i][j] = true;
                // 向四个方向遍历
                return backTrack(visited, i, j - 1, threshold)
                        + backTrack(visited, i, j + 1, threshold)
                        + backTrack(visited, i - 1, j, threshold)
                        + backTrack(visited, i + 1, j, threshold) + 1;
            }
        }
        return 0;
    }

    /**
     * 计算位数之和
     *
     * @param num
     * @return
     */
    private int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
