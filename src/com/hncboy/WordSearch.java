package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/8 9:36
 * @description 79.单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "SEE"));
        System.out.println(ws.exist(board, "ABCB"));
        System.out.println(ws.exist(board, "AAA"));
    }

    private boolean exist(char[][] board, String word) {
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
     * @param i
     * @param j
     * @param count  符合的字母数量
     * @param word   判断的单词
     * @param status 是否经过的表示
     * @param board  需要遍历的网格
     * @return
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
