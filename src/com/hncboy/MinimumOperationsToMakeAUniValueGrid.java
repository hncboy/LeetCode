package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2021/10/10 13:14
 * @description 2033.获取单值网格的最小操作数
 * 
 * 给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
 * 单值网格 是全部元素都相等的网格。
 * 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。
 *
 *
 * 示例 1：
 * 输入：grid = [[2,4],[6,8]], x = 2
 * 输出：4
 * 解释：可以执行下述操作使所有元素都等于 4 ： 
 * - 2 加 x 一次。
 * - 6 减 x 一次。
 * - 8 减 x 两次。
 * 共计 4 次操作。
 *
 * 示例 2：
 * 输入：grid = [[1,5],[2,3]], x = 1
 * 输出：5
 *
 * 解释：可以使所有元素都等于 3 。
 * 示例 3：
 * 输入：grid = [[1,2],[3,4]], x = 2
 * 输出：-1
 * 解释：无法使所有元素相等。
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= x, grid[i][j] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-a-uni-value-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumOperationsToMakeAUniValueGrid {

    public static void main(String[] args) {
        MinimumOperationsToMakeAUniValueGrid m = new MinimumOperationsToMakeAUniValueGrid();
        System.out.println(m.minOperations(new int[][]{{2, 4}, {6, 8}}, 2));
        System.out.println(m.minOperations(new int[][]{{1, 5}, {2, 3}}, 1));
        System.out.println(m.minOperations(new int[][]{{1, 2}, {3, 4}}, 2));
    }

    private int minOperations(int[][] grid, int x) {
        int row = grid.length;
        int column = grid[0].length;

        // 将二维数组转为一维数组并进行排序
        int[] array = new int[column * row];
        for (int i = 0; i < row * column; i++) {
            array[i] = grid[i / column][i % column];
        }
        Arrays.sort(array);

        // 获取中位数
        int midNum = array[(row * column) / 2];
        int result = 0;
        for (int num : array) {
            // 获取当前数与中位数之差
            int difference = Math.abs(midNum - num);
            // 如果差不是 x 的倍数，则两数最终无法相等，返回 -1
            if (difference % x != 0) {
                return -1;
            }

            // 增加次数
            result += difference / x;
        }

        return result;
    }
}
