package com.hncboy;

/**
 * @author hncboy
 * @date 2022/4/9 19:56
 * 780.到达终点
 * 
 * 给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 false。
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 *
 * 示例 1:
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: true
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * 
 * 示例 2:
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2 
 * 输出: false
 * 
 * 示例 3:
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1 
 * 输出: true
 *
 * 提示:
 * 1 <= sx, sy, tx, ty <= 109
 * 通过次数 17,331 提交次数 47,888
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reaching-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReachingPoints {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }

        if (tx == sx && ty == sy) {
            return true;
        }
        if (tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        }
        if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        }
        return false;
    }
}
