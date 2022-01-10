package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2022/1/10 9:50
 * 剑指 Offer II 099.最小路径之和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：一个机器人每次只能向下或者向右移动一步。
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
 *  
 * 注意：本题与主站 64 题 {@link com.hncboy.MinimumPathSum} 相同： https://leetcode-cn.com/problems/minimum-path-sum/
 * 通过次数 4,958 提交次数 6,908
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/0i0mDW
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question099 {

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
