package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/7 10:10
 * @description 794.有效的井字游戏
 *
 * 用字符串数组作为井字游戏的游戏板 board。当
 * 且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
 * 该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。
 *
 * 以下是井字游戏的规则：
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
 * “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 *
 * 示例 1:
 * 输入: board = ["O  ", "   ", "   "]
 * 输出: false
 * 解释: 第一个玩家总是放置“X”。
 *
 * 示例 2:
 * 输入: board = ["XOX", " X ", "   "]
 * 输出: false
 * 解释: 玩家应该是轮流放置的。
 *
 * 示例 3:
 * 输入: board = ["XXX", "   ", "OOO"]
 * 输出: false
 *
 * 示例 4:
 * 输入: board = ["XOX", "O O", "XOX"]
 * 输出: true
 *
 * 说明:
 * 游戏板 board 是长度为 3 的字符串数组，其中每个字符串 board[i] 的长度为 3。
 *  board[i][j] 是集合 {" ", "X", "O"} 中的一个字符。
 *  通过次数 9,462 提交次数 26,298
 */
public class ValidTicTacToeState {

    public static void main(String[] args) {
        ValidTicTacToeState v = new ValidTicTacToeState();
        String[] board1 = {"O  ", "   ", "   "};
        String[] board2 = {"XO ", "XO ", "XO "};
        String[] board3 = {"XXX", "   ", "OOO"};
        String[] board4 = {"XOX", "O O", "XOX"};
        System.out.println(v.validTicTacToe(board1));
        System.out.println(v.validTicTacToe(board2));
        System.out.println(v.validTicTacToe(board3));
        System.out.println(v.validTicTacToe(board4));
    }

    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;
        // 遍历统计 O 和 X 的数量
        for (String row : board) {
            for (char ch : row.toCharArray()) {
                xCount = (ch == 'X') ? (xCount + 1) : xCount;
                oCount = (ch == 'O') ? (oCount + 1) : oCount;
            }
        }

        // X 和 O 的条件必须满足：X==O || O=X-1
        if (oCount != xCount && oCount != xCount - 1) {
            return false;
        }

        // 如果 X 赢的话，X=O-1
        if (win(board, 'X') && oCount != xCount - 1) {
            return false;
        }

        // 如果 O 赢的话，X=O
        if (win(board, 'O') && oCount != xCount) {
            return false;
        }
        return true;
    }

    private boolean win(String[] board, char ch) {
        // 遍历每一行和每一列，只要有一行或一列有 3 个一样的字符，则代表胜利
        for (int i = 0; i < 3; ++i) {
            if (ch == board[0].charAt(i) && ch == board[1].charAt(i) && ch == board[2].charAt(i)) {
                return true;
            }
            if (ch == board[i].charAt(0) && ch == board[i].charAt(1) && ch == board[i].charAt(2)) {
                return true;
            }
        }

        // 两条对角线胜利的情况
        if (ch == board[0].charAt(0) && ch == board[1].charAt(1) && ch == board[2].charAt(2)) {
            return true;
        }
        if (ch == board[0].charAt(2) && ch == board[1].charAt(1) && ch == board[2].charAt(0)) {
            return true;
        }
        return false;
    }
}
