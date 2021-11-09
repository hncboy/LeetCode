package com.hncboy;

/**
 * @author hncboy
 * @date 2021/11/9 9:08
 * @description 488.祖玛游戏
 * 
 * 你正在参与祖玛游戏的一个变种。
 * 在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
 * 你的目标是 清空 桌面上所有的球。每一回合：
 *
 * 从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
 * 接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
 * 如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
 * 如果桌面上所有球都被移除，则认为你赢得本场游戏。
 * 重复这个过程，直到你赢了游戏或者手中没有更多的球。
 * 给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand ，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
 *
 *
 * 示例 1：
 * 输入：board = "WRRBBW", hand = "RB"
 * 输出：-1
 * 解释：无法移除桌面上的所有球。可以得到的最好局面是：
 * - 插入一个 'R' ，使桌面变为 WRRRBBW 。WRRRBBW -> WBBW
 * - 插入一个 'B' ，使桌面变为 WBBBW 。WBBBW -> WW
 * 桌面上还剩着球，没有其他球可以插入。
 *
 * 示例 2：
 * 输入：board = "WWRRBBWW", hand = "WRBRW"
 * 输出：2
 * 解释：要想清空桌面上的球，可以按下述步骤：
 * - 插入一个 'R' ，使桌面变为 WWRRRBBWW 。WWRRRBBWW -> WWBBWW
 * - 插入一个 'B' ，使桌面变为 WWBBBWW 。WWBBBWW -> WWWW -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 *
 * 示例 3：
 * 输入：board = "G", hand = "GGGGG"
 * 输出：2
 * 解释：要想清空桌面上的球，可以按下述步骤：
 * - 插入一个 'G' ，使桌面变为 GG 。
 * - 插入一个 'G' ，使桌面变为 GGG 。GGG -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 *
 * 示例 4：
 * 输入：board = "RBYYBBRRB", hand = "YRBGB"
 * 输出：3
 * 解释：要想清空桌面上的球，可以按下述步骤：
 * - 插入一个 'Y' ，使桌面变为 RBYYYBBRRB 。RBYYYBBRRB -> RBBBRRB -> RRRB -> B
 * - 插入一个 'B' ，使桌面变为 BB 。
 * - 插入一个 'B' ，使桌面变为 BBB 。BBB -> empty
 * 只需从手中出 3 个球就可以清空桌面。
 *  
 *
 * 提示：
 * 1 <= board.length <= 16
 * 1 <= hand.length <= 5
 * board 和 hand 由字符 'R'、'Y'、'B'、'G' 和 'W' 组成
 * 桌面上一开始的球中，不会有三个及三个以上颜色相同且连着的球
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuma-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZumaGame {

    private int minStep = 0;
    private int overStep = 0;

    public int findMinStep(String board, String hand) {
        // 初始化五种颜色的下标
        int[] colorIndex = new int[25];
        colorIndex['R' - 'A'] = 0;
        colorIndex['Y' - 'A'] = 1;
        colorIndex['B' - 'A'] = 2;
        colorIndex['G' - 'A'] = 3;
        colorIndex['W' - 'A'] = 4;

        // 遍历手中的彩球，将各个彩球对应的数量累计并按下标存入 handMap
        int[] handMap = new int[5];
        for (char ch : hand.toCharArray()) {
            handMap[colorIndex[ch - 'A']]++;
        }

        // 遍历桌面上所有的彩球，将彩球的数量存入 boardSb
        StringBuilder boardSb = new StringBuilder();
        for (char ch : board.toCharArray()) {
            boardSb.append(colorIndex[ch - 'A']);
        }

        // 手中小球的总数+1是最大步骤数，如果超过此步骤，说明无解
        overStep = hand.length() + 1;
        minStep = overStep;

        // 进行遍历
        dfsMinStep(boardSb, handMap, 0);

        return minStep == overStep ? -1 : minStep;
    }

    private void dfsMinStep(StringBuilder boardSb, int[] handMap, int step) {
        // 压缩桌面的小球，消除连续 3 个及以上相同颜色的小球
        compress(boardSb);
        // 如果桌面上彩球被清空了，则计算此时的最小步骤
        if (boardSb.length() == 0) {
            minStep = Math.min(minStep, step);
        }

        // 当前步骤超过最大步骤，无解
        if (step >= overStep) {
            return;
        }

        int left = 0;
        while (left < boardSb.length()) {
            // 右指针为左指针右边一位的指针
            int right = left + 1;
            // 如果左右指针指向的小球颜色一样，则右指针往右移
            while (right < boardSb.length() && boardSb.charAt(right) == boardSb.charAt(left)) {
                right++;
            }

            // 如果左右指针相差1，则表示左右指针并未发生移动，此时他们就是左右相邻的关系，也就是说左指针指向的小球颜色是单一的
            if (right - left == 1) {
                // 构建桌面上彩球的副本
                StringBuilder tmp = new StringBuilder(boardSb);
                // 获得左指针位置小球对应的颜色
                int checkColor = tmp.charAt(left) - '0';
                // 如果手中该颜色的小球数量超过或等于 2
                if (handMap[checkColor] >= 2) {
                    // 抛出手中的两个同颜色的小球
                    handMap[checkColor] -= 2;
                    // 消除左指针位置的小球，将步骤+2
                    dfsMinStep(tmp.deleteCharAt(left), handMap, step + 2);
                    // 将手中抛出的两个小球补充回去
                    handMap[checkColor] += 2;
                }
            } else {
                // 此时左指针处开始的位置有两个颜色相同的小球，遍历所有颜色的小球，只要有小球就直接插入
                for (int color = 0; color < 5; color++) {
                    if (handMap[color] >= 1) {
                        StringBuilder tmp = new StringBuilder(boardSb);
                        handMap[color]--;
                        dfsMinStep(tmp.insert(left + 1, color), handMap, step + 1);
                        handMap[color]++;
                    }
                }
            }
            // 左指针重新指向
            left = right;
        }
    }

    /**
     * 压缩桌面的彩球
     *
     * @param boardSb 桌面上彩球
     */
    private void compress(StringBuilder boardSb) {
        int left = 0;
        int right = 1;
        // 左指针从第一个彩球开始遍历
        while (left < boardSb.length()) {
            // 右指针如果指向和左指针相同的小球，则右指针往右移动
            while (right < boardSb.length() && boardSb.charAt(right) == boardSb.charAt(left)) {
                right++;
            }

            // 如果左右指针相差的长度大于 2
            if (right - left > 2) {
                // 删除左指针和右指针之间的小球
                boardSb.delete(left, right);
                // 重新移动右指针到左指针右边的位置
                right = left + 1;
                // 如果左指针和左指针左边的小球颜色一样，则左指针往左移动
                while (left > 0 && left < boardSb.length() && boardSb.charAt(left - 1) == boardSb.charAt(left)) {
                    left--;
                }
            } else {
                // 此时不满足彩球压缩条件，左指针移动到右指针的位置，右指针往右移动
                left = right++;
            }
        }
    }
}
