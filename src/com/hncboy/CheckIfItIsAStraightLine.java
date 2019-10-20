package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/20 10:30
 * @description 5230.缀点成线
 */
public class CheckIfItIsAStraightLine {

    public static void main(String[] args) {
        CheckIfItIsAStraightLine c = new CheckIfItIsAStraightLine();
        int[][] coordinates1 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int[][] coordinates2 = new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        int[][] coordinates3 = new int[][]{{-3, -2}, {-1, -2}, {2, -2}, {-2, -2}, {0, -2}};
        System.out.println(c.checkStraightLine(coordinates1));
        System.out.println(c.checkStraightLine(coordinates2));
        System.out.println(c.checkStraightLine(coordinates3));
    }

    private boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[1][0] - coordinates[0][0];
        int y1 = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            int x2 = coordinates[i][0] - coordinates[0][0];
            int y2 = coordinates[i][1] - coordinates[0][1];
            if (x1 * y2 != x2 * y1) {
                return false;
            }
        }
        return true;
    }
}
