package com.hncboy;

/**
 * @author hncboy
 * @date 2021/10/29 8:15
 * @description 335.路径交叉
 *
 * 给你一个整数数组 distance 。
 * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，
 * 向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 *
 * 提示：
 * 1 <= distance.length <= 105
 * 1 <= distance[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-crossing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SelfCrossing {

    public static void main(String[] args) {
        SelfCrossing s = new SelfCrossing();
        System.out.println(s.isSelfCrossing(new int[]{2, 1, 1, 2}));
        System.out.println(s.isSelfCrossing(new int[]{1, 2, 3, 4}));
        System.out.println(s.isSelfCrossing(new int[]{1, 1, 1, 1}));
    }

    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        // 三条边永远不会相交
        if (n < 4) {
            return false;
        }

        // 从第四条边开始遍历，三种相交情况
        for (int i = 3; i < n; i++) {
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            }
            if (i >= 5 && distance[i - 1] <= distance[i - 3] && distance[i - 2] > distance[i - 4] && distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
