package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/11/16 8:59
 * @description 391.完美矩形
 * 
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 *
 *  
 * 示例 1：
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * 输出：true
 * 解释：5 个矩形一起可以精确地覆盖一个矩形区域。
 *
 * 示例 2：
 * 输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
 * 输出：false
 * 解释：两个矩形之间有间隔，无法覆盖成一个矩形。
 *
 * 示例 3：
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
 * 输出：false
 * 解释：图形顶端留有空缺，无法覆盖成一个矩形。
 *
 * 示例 4：
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * 输出：false
 * 解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 *
 * 提示：
 * 1 <= rectangles.length <= 2 * 104
 * rectangles[i].length == 4
 * -105 <= xi, yi, ai, bi <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PerfectRectangle {

    public static void main(String[] args) {
        PerfectRectangle p = new PerfectRectangle();
        System.out.println(p.isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}}));
    }

    public boolean isRectangleCover(int[][] rectangles) {
        // 存放最大的四个点
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;

        // 存放每个矩形的各个顶点
        Set<String> set = new HashSet<>();

        // 存放所有矩形的面积和
        int area = 0;
        for (int[] rectangle : rectangles) {
            // 获取左下顶点的最小值
            left = Math.min(left, rectangle[0]);
            bottom = Math.min(bottom, rectangle[1]);
            // 获取右上顶点的最大值
            right = Math.max(right, rectangle[2]);
            top = Math.max(top, rectangle[3]);

            // 计算所有矩形的面积
            area += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);

            // 记录该矩形的各个点
            record(set, rectangle[0], rectangle[3]);
            record(set, rectangle[0], rectangle[1]);
            record(set, rectangle[2], rectangle[3]);
            record(set, rectangle[2], rectangle[1]);
        }

        // 符合完美矩形条件：
        // 1.四个顶点只会出现一次，其他点成对出现，set 需要只剩下 4 条记录
        // 2.剩下的 4 个点需要是四个顶点
        // 3.四个顶点计算出来的面积=所有小矩形的面积之和
        if (set.size() == 4
                && set.contains(key(left, top))
                && set.contains(key(left, bottom))
                && set.contains(key(right, bottom))
                && set.contains(key(right, top))) {
            return area == (right - left) * (top - bottom);
        }
        return false;

    }

    /**
     * 如果这个点出现过，则移除，否则添加进集合
     * 四个顶点只会出现一次，其他点成对出现
     */
    private void record(Set<String> set, int x, int y) {
        String key = key(x, y);
        if (!set.contains(key)) {
            set.add(key);
        } else {
            set.remove(key);
        }
    }

    private String key(int x, int y) {
        return x + " " + y;
    }
}
