package com.hncboy;

/**
 * @author hncboy
 * @date 2022/12/8 12:30
 * 1812.判断国际象棋棋盘中一个格子的颜色
 */
public class DetermineColorOfAChessboardSquare {

    public static void main(String[] args) {
        DetermineColorOfAChessboardSquare d = new DetermineColorOfAChessboardSquare();
        System.out.println(d.squareIsWhite("a1"));
        System.out.println(d.squareIsWhite("h3"));
        System.out.println(d.squareIsWhite("c7"));
    }

    public boolean squareIsWhite(String coordinates) {
        // 下标统一从 1 开始，如果相加是奇数，则白色，否则黑色
        return ((coordinates.charAt(0) - 'a' + 1) + (coordinates.charAt(1) - '0')) % 2 == 1;
    }
}
