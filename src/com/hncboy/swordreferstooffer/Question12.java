package com.hncboy.swordreferstooffer;

import com.hncboy.WordSearch;

/**
 * @author hncboy
 * @date 2021/9/21 17:04
 * @description 剑指 Offer 12.矩阵中的路径
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *
 * 注意：本题与主站 79 题 {@link WordSearch} 相同：https://leetcode-cn.com/problems/word-search/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question12 {

    public boolean exist(char[][] board, String word) {
        // 判断是否经过
        boolean[][] status = new boolean[board.length][board[0].length];

        // 遍历每个点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(i, j, 0, word, status, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先遍历
     *
     * @param i      i
     * @param j      j
     * @param count  符合的字母数量
     * @param word   判断的单词
     * @param status 是否经过的表示
     * @param board  需要遍历的网格
     * @return 是否匹配成功
     */
    private boolean dfs(int i, int j, int count, String word, boolean[][] status, char[][] board) {
        // 点需要在网格区域内
        if (!inArea(i, j, board)) {
            return false;
        }

        // 如果当前网格点未经过且当前网格点对应的字母与单词需要查找的字母一样
        if (!status[i][j] && board[i][j] == word.charAt(count)) {
            // 如果已经查找到了单词最后一个，则直接返回 true
            if (count == word.length() - 1) {
                return true;
            }

            // 经过当前点改变标志
            status[i][j] = true;

            // 往右走
            if (dfs(i + 1, j, count + 1, word, status, board)) {
                return true;
            }

            // 往左走
            if (dfs(i - 1, j, count + 1, word, status, board)) {
                return true;
            }

            // 往下走
            if (dfs(i, j - 1, count + 1, word, status, board)) {
                return true;
            }

            // 往上走
            if (dfs(i, j + 1, count + 1, word, status, board)) {
                return true;
            }

            // 该点不符合，清除标记
            status[i][j] = false;
        }
        return false;
    }

    /**
     * 判断该点是否在网格区域内
     *
     * @param i
     * @param j
     * @param board
     * @return
     */
    private boolean inArea(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[i].length;
    }
}
