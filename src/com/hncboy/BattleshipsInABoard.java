package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/18 13:38
 * @description 419.甲板上的战舰
 * 
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
 * 返回在甲板 board 上放置的 战舰 的数量。
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，
 * 其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 *
 * 示例 1：
 * 输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
 * 输出：2
 *
 * 示例 2：
 * 输入：board = [["."]]
 * 输出：0
 *
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 是 '.' 或 'X'
 *  
 * 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？
 * 通过次数 21,426 提交次数 27,555
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/battleships-in-a-board
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BattleshipsInABoard {

    public int countBattleships(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 如果水平方向上一个位置是 X，则表示已经统计过
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                // 如果垂直方向上一个位置是 X，则表示已经统计过
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                // 当前为战舰的头节点
                if (board[i][j] == 'X') {
                    result++;
                }
            }
        }
        return result;
    }
}
