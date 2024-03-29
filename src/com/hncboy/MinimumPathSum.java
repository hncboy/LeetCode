package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/29 10:56
 * 64.最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * 通过次数 299,939 提交次数 434,778
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (i == 0) {
                    // 最上面的一条线，只有一直向右移动一种情况
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    // 最做面的一条线，只有一直向下移动一种情况
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    // 除此之外，到达 grid[i][j] 的最小路径为当前 (i,j) 的数以及加上到达 Min(上边的位置，左边的位置) 最小路径
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
