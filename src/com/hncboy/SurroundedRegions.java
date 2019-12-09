package com.hncboy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/12/9 9:16
 * @description 130.被围绕的区域
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        SurroundedRegions s = new SurroundedRegions();
        s.solve(new char[][]{{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}});
    }

    private void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 从边缘的 O 节点搜索
                boolean isEdge = i == 0 || j == 0 || i == row - 1 || j == column - 1;
                if (isEdge && board[i][j] == 'O') {
                    //dfs1(board, i, j);
                    //dfs2(board, i, j);
                    bfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * BFS 非递归
     *
     * @param board
     * @param i
     * @param j
     */
    private void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        board[i][j] = '#';
        // 通过队列存储遍历过的节点，根据先进先出的特性，弹出队首的节点，将上下左右四个方向都遍历完
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // 往上搜索
            if (current[0] - 1 >= 0 && board[current[0] - 1][current[1]] == 'O') {
                queue.add(new int[]{current[0] - 1, current[1]});
                board[current[0] - 1][current[1]] = '#';
            }
            // 往下搜索
            if (current[0] + 1 <= board.length - 1
                    && board[current[0] + 1][current[1]] == 'O') {
                queue.add(new int[]{current[0] + 1, current[1]});
                board[current[0] + 1][current[1]] = '#';
            }
            // 往左搜索
            if (current[1] - 1 >= 0
                    && board[current[0]][current[1] - 1] == 'O') {
                queue.add(new int[]{current[0], current[1] - 1});
                board[current[0]][current[1] - 1] = '#';
            }
            // 往右搜索
            if (current[1] + 1 <= board[0].length - 1 && board[current[0]][current[1] + 1] == 'O') {
                queue.add(new int[]{current[0], current[1] + 1});
                board[current[0]][current[1] + 1] = '#';
            }
        }
    }

    /**
     * DFS 非递归
     *
     * @param board
     * @param i
     * @param j
     */
    private void dfs2(char[][] board, int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        board[i][j] = '#';
        // 通过栈存储遍历过的节点，根据先进后出的特性，每找到一个节点，将该节点加入栈顶，从该节点开始遍历
        while (!stack.isEmpty()) {
            int[] current = stack.peek();
            // 往上搜索
            if (current[0] - 1 >= 0 && board[current[0] - 1][current[1]] == 'O') {
                stack.push(new int[]{current[0] - 1, current[1]});
                board[current[0] - 1][current[1]] = '#';
                continue;
            }
            // 往下搜索
            if (current[0] + 1 <= board.length - 1 && board[current[0] + 1][current[1]] == 'O') {
                stack.push(new int[]{current[0] + 1, current[1]});
                board[current[0] + 1][current[1]] = '#';
                continue;
            }
            // 往左搜索
            if (current[1] - 1 >= 0 && board[current[0]][current[1] - 1] == 'O') {
                stack.push(new int[]{current[0], current[1] - 1});
                board[current[0]][current[1] - 1] = '#';
                continue;
            }
            // 往右搜索
            if (current[1] + 1 <= board[0].length - 1 && board[current[0]][current[1] + 1] == 'O') {
                stack.push(new int[]{current[0], current[1] + 1});
                board[current[0]][current[1] + 1] = '#';
                continue;
            }
            // 该节点4个方向均无O节点，弹出该节点
            stack.pop();
        }
    }

    /**
     * DFS 递归
     *
     * @param board
     * @param i
     * @param j
     */
    private void dfs1(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        // 搜索与边缘 O 节点相连的 O 节点，将访问过的节点改为 #
        board[i][j] = '#';
        dfs1(board, i - 1, j);
        dfs1(board, i + 1, j);
        dfs1(board, i, j - 1);
        dfs1(board, i, j + 1);
    }
}
