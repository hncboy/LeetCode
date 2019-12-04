package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/4 15:49
 * @description 37.解数独
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * Note:
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class SudokuSolver {

    private char[][] board;
    /**
     * 判断每一行上的数字是否存在
     */
    private int[][] rows = new int[9][10];
    /**
     * 判断每一列上的数字是否存在
     */
    private int[][] columns = new int[9][10];
    /**
     * 判断每一个九宫格内的数字是否存在
     */
    private int[][] boxes = new int[9][10];
    /**
     * 判断是否解决
     */
    private boolean sudokuSolved = false;

    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.' },
                {'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                {'.', '9', '8', '.', '.', '.', '.', '6', '.' },
                {'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                {'7', '.', '.', '.', '2', '.', '.', '.', '6' },
                {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                {'.', '.', '.', '.', '8', '.', '.', '7', '9' }};
        s.solveSudoku(board);
    }

    private void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9) {
                    placeNumber(num, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    /**
     * 回溯
     *
     * @param row
     * @param column
     */
    private void backtrack(int row, int column) {
        // 如果该位置为空
        if (board[row][column] == '.') {
            // 遍历 1-9 个数字
            for (int i = 1; i <= 9; i++) {
                // 剪枝，判断该位置是否能放置该数字
                if (couldPlace(i, row, column)) {
                    // 放置该数字
                    placeNumber(i, row, column);
                    // 放置下一个位置
                    placeNextNumbers(row, column);
                    // 恢复现场
                    if (!sudokuSolved) {
                        removeNumber(i, row, column);
                    }
                }
            }
        } else {
            // 该位置不为空放置在下一个位置
            placeNextNumbers(row, column);
        }
    }

    /**
     * 在(row, column)放置对应的数字
     *
     * @param num
     * @param row
     * @param column
     */
    private void placeNumber(int num, int row, int column) {
        int idx = (row / 3) * 3 + column / 3;
        rows[row][num]++;
        columns[column][num]++;
        boxes[idx][num]++;
        board[row][column] = (char) (num + '0');
    }

    /**
     * 判断对应的行、列、九宫格中是否已有该数字
     *
     * @param num
     * @param row
     * @param column
     * @return
     */
    private boolean couldPlace(int num, int row, int column) {
        int idx = (row / 3) * 3 + column / 3;
        return rows[row][num] + columns[column][num] + boxes[idx][num] == 0;
    }

    /**
     * 移除该数字
     *
     * @param num
     * @param row
     * @param column
     */
    public void removeNumber(int num, int row, int column) {
        int idx = (row / 3) * 3 + column / 3;
        rows[row][num]--;
        columns[column][num]--;
        boxes[idx][num]--;
        board[row][column] = '.';
    }

    /**
     * 放置下一个数字
     *
     * @param row
     * @param column
     */
    private void placeNextNumbers(int row, int column) {
        // 如果为最后一个数字，则该熟读已解决
        if (column == 8 && row == 8) {
            sudokuSolved = true;
        } else {
            // 按行放置，先把每一行放满，再放下一行
            if (column == 8) {
                backtrack(row + 1, 0);
            } else {
                backtrack(row, column + 1);
            }
        }
    }
}
