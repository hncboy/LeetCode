package com.hncboy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hncboy
 * @date 2019/12/10 8:34
 * @description 149.直线上最多的点数
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 *
 * 示例 2:
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class MaxPointsOnALine {

    public static void main(String[] args) {
        MaxPointsOnALine m = new MaxPointsOnALine();
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}}; // 3
        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}; // 4
        int[][] points3 = {{0, 0}}; // 1
        int[][] points4 = {{0, 0}, {1, 1}, {0, 0}}; // 3
        int[][] points5 = {{1, 1}, {1, 1}, {2, 2}, {2, 2}}; // 4
        int[][] points6 = {{-4, -4}, {-8, -582}, {-3, 3}, {-9, -651}, {9, 591}}; // 3
        System.out.println(m.maxPoints(points1));
        System.out.println(m.maxPoints(points2));
        System.out.println(m.maxPoints(points3));
        System.out.println(m.maxPoints(points4));
        System.out.println(m.maxPoints(points5));
        System.out.println(m.maxPoints(points6));
    }

    public int maxPoints(int[][] points) {
        int result = 0;

        // 斜线的斜率
        Set<Double> slopeSet = new HashSet<>();
        // 横坐标一样的斜率
        Map<Integer, Integer> xSlopeMap = new HashMap<>();
        // 纵坐标一样的斜率
        Map<Integer, Integer> ySlopeMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            xSlopeMap.put(x1, xSlopeMap.getOrDefault(x1, 0) + 1);
            ySlopeMap.put(y1, ySlopeMap.getOrDefault(y1, 0) + 1);

            int repeat = 0;
            int currentMax = 0;
            Map<Double, Integer> subMap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                // 统计重复的点的数量
                if (x1 == x2 && y1 == y2) {
                    repeat++;
                    continue;
                }
                // 除去横坐标或纵坐标一样的点
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                // 计算斜率
                double k = (x1 - x2) * 1.0 / (y1 - y2);
                // 判断斜率是否计算过
                if (slopeSet.contains(k)) {
                    continue;
                }
                // 更新当前循环一样的点出现的次数
                subMap.put(k, subMap.getOrDefault(k, 1) + 1);
                currentMax = Math.max(currentMax, subMap.get(k));
            }
            result = Math.max(result, Math.max(xSlopeMap.get(x1), ySlopeMap.get(y1)));
            result = Math.max(result, currentMax + repeat);
            slopeSet.addAll(subMap.keySet());
        }

        return result;
    }
}
