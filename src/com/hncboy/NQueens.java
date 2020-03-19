package com.hncboy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/10/28 19:42
 * @description 51.N皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class NQueens {

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }

    private List<List<String>> solveNQueens(int n) {
        Map<Integer, String> param = new HashMap<>();
        // 存放 n 种不重复的排列情况
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(i == j ? "Q" : ".");
            }
            param.put(i, sb.toString());
        }
        List<List<String>> result = new ArrayList<>();
        backTrack(0, param, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], result, new ArrayList<>());
        return result;
    }

    /**
     *
     * @param row 当前计算的是第几行
     * @param param
     * @param column 判断当前列是否可放置皇后，n 种情况
     * @param leftDiagonal 判断左对角线是否可放置皇后，2*n - 1 种情况
     * @param rightDiagonal 判断右对角线是否可放置皇后，2*n - 1 种情况
     * @param result
     * @param sub
     */
    private void backTrack(int row, Map<Integer, String> param, boolean[] column, boolean[] leftDiagonal, boolean[] rightDiagonal, List<List<String>> result, List<String> sub) {
        int n = param.size();
        if (sub.size() == n) {
            result.add(new ArrayList<>(sub));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 当前列，左对角线，右对角线是否符合放置皇后
            if (column[i] || leftDiagonal[n - 1 - row + i] || rightDiagonal[row + i]) {
                continue;
            }

            // 当前位置放置皇后，将对应的列，左对角线，右对角线作标记
            column[i] = true;
            leftDiagonal[n - 1 - row + i] = true;
            rightDiagonal[row + i] = true;

            // 插入对应当前列出现的皇后的情况
            sub.add(param.get(i));

            // 继续判断下一行皇后的放置
            backTrack(row + 1, param, column, leftDiagonal, rightDiagonal, result, sub);

            // 回溯完成后重置标记
            sub.remove(row);
            column[i] = false;
            leftDiagonal[n - 1 - row + i] = false;
            rightDiagonal[row + i] = false;
        }
    }
}
