package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/7 10:10
 * @description 794.有效的井字游戏
 *
 * 用字符串数组作为井字游戏的游戏板 board。当
 * 且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
 * 该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。
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
 * 输入: board = ["O  ", "   ", "   "]
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
 * 游戏板 board 是长度为 3 的字符串数组，其中每个字符串 board[i] 的长度为 3。
 *  board[i][j] 是集合 {" ", "X", "O"} 中的一个字符。
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

    private boolean validTicTacToe(String[] board) {
        boolean[] xCount = new boolean[10];
        boolean[] oCount = new boolean[10];
        int xNum = 0;
        int oNum = 0;
        int index = 0;

        for (String s : board) {
            for (char c : s.toCharArray()) {
                index++;
                if (c == 'X') {
                    xCount[index] = true;
                    xNum++;
                } else if (c == 'O') {
                    oCount[index] = true;
                    oNum++;
                }
            }
        }

        /*
         true 的情况：
         1.当X和O的数量相等且X没有赢时
         2.当X比O的数量多一个且O没有赢时
         false 的情况：
         1.O先走
         2.O>X
         3.X>O+1
         4.等等
         */
        return xNum == oNum && !isSuccess(xCount) || xNum == oNum + 1 && !isSuccess(oCount);
    }

    /**
     * 计算 X 或 O 是否胜利
     *
     * @param count
     * @return
     */
    private boolean isSuccess(boolean[] count) {
        /*
         胜利的 8 中情况：
         行：3种
         列：3种
         斜：2种
         */
        int[][] successes = {
                {1, 2, 3},
                {1, 4, 7},
                {1, 5, 9},
                {2, 5, 8},
                {3, 6, 9},
                {3, 5, 7},
                {4, 5, 6},
                {7, 8, 9}};

        for (int[] success : successes) {
            if (count[success[0]] && count[success[1]] && count[success[2]]) {
                return true;
            }
        }
        return false;
    }
}
