package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/13 10:44
 * @description 5223.可以攻击国王的皇后
 *
 */
public class QueensThatCanAttackTheKing {

    public static void main(String[] args) {
        QueensThatCanAttackTheKing q = new QueensThatCanAttackTheKing();
        int[][] queens1 = new int[][]{{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},
                {1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},
                {2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
        System.out.println(q.queensAttacktheKing(queens1, new int[]{3, 4}));
    }

    private List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        // 存放横线上的黑皇后的下标，前一个存小的下标，后一个存大的下标
        int[] rowQueen = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        // 存放直线上的黑皇后的下标，前一个存小的下标，后一个存大的下标
        int[] columnQueen = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        /*
         存放斜线上黑皇后的下标
         第一个存放左上角的 y 坐标
         第二个存放右上角的 y 坐标
         第三个存放左下角的 y 坐标
         第四个存放右下角的 y 坐标
         */
        int[] slashQueen = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE,
                Integer.MAX_VALUE, Integer.MAX_VALUE};

        // 遍历黑皇后的数量
        for (int[] queen : queens) {
            // 判断黑皇后和白国王是否在同一横线上
            if (queen[0] == king[0]) {
                // 两种情况，最多两个坐标
                // 横线上黑皇后的坐标大于国王的坐标
                if (queen[1] > king[1]) {
                    // 存放大的下标中更小的那个
                    rowQueen[1] = Math.min(rowQueen[1], queen[1]);
                } else {
                    // 存放小的下标中更大的那个
                    rowQueen[0] = Math.max(rowQueen[0], queen[1]);
                }
                continue;
            }

            // 判断黑皇后和白国王是否在同一直线上
            if (queen[1] == king[1]) {
                // 两种情况，最多两个坐标
                // 直线上黑皇后的坐标大于国王的坐标
                if (queen[0] > king[0]) {
                    // 存放大的下标中更小的那个
                    columnQueen[1] = Math.min(columnQueen[1], queen[0]);
                } else {
                    // 存放小的下标中更大的那个
                    columnQueen[0] = Math.max(columnQueen[0], queen[0]);
                }
                continue;
            }


            // 判断黑皇后和白国王是否在同一斜线上
            if (Math.abs(queen[1] - king[1]) == Math.abs(queen[0] - king[0])) {
                // 四种情况，最多四个坐标
                // 国王的左上角
                if (queen[0] < king[0] && queen[1] < king[1]) {
                    slashQueen[0] = Math.max(queen[1], slashQueen[0]);
                    continue;
                }
                // 国王的右上角
                if (queen[0] > king[0] && queen[1] < king[1]) {
                    slashQueen[1] = Math.max(queen[1], slashQueen[1]);
                    continue;
                }
                // 国王的左下角
                if (queen[0] < king[0]) {
                    slashQueen[2] = Math.min(queen[1], slashQueen[2]);
                    continue;
                }
                // 国王的右下角
                slashQueen[3] = Math.min(queen[1], slashQueen[3]);
            }

        }

        // 将横线和直线坐标放入 result
        for (int i = 0; i < 2; i++) {
            // 将横线上的黑皇后的坐标放入 result
            if (rowQueen[i] > Integer.MIN_VALUE && rowQueen[i] < Integer.MAX_VALUE) {
                result.add(Arrays.asList(king[0], rowQueen[i]));
            }
            // 将直线上的黑皇后的坐标放入 result
            if (columnQueen[i] > Integer.MIN_VALUE && columnQueen[i] < Integer.MAX_VALUE) {
                result.add(Arrays.asList(columnQueen[i], king[1]));
            }
        }

        // 将斜线坐标放入 result
        for (int i = 0; i < 4; i++) {
            if (slashQueen[i] > Integer.MIN_VALUE && slashQueen[i] < Integer.MAX_VALUE) {
                switch (i) {
                    case 0:
                    case 3:
                        result.add(Arrays.asList(slashQueen[i] - king[1] + king[0], slashQueen[i]));
                        break;
                    case 1:
                        result.add(Arrays.asList(king[0] - slashQueen[i] + king[1], slashQueen[i]));
                        break;
                    case 2:
                        result.add(Arrays.asList(king[1] - slashQueen[i] + king[0], slashQueen[i]));
                        break;
                    default:break;
                }
            }
        }

        return result;
    }
}
