package com.hncboy.weeklycontest157;

/**
 * @author hncboy
 * @date 2019/10/6 10:30
 * @description 5213.玩筹码
 *
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 *
 * 示例 1：
 * 输入：chips = [1,2,3]
 * 输出：1
 * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 *
 * 示例 2：
 * 输入：chips = [2,2,2,3,3]
 * 输出：2
 * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 *
 * 提示：
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 */
public class PlayWithChips {

    public static void main(String[] args) {
        int[] chips1 = new int[]{1, 2, 3};
        int[] chips2 = new int[]{2, 2, 2, 3, 3};
        int[] chips3 = new int[]{1};
        System.out.println(new PlayWithChips().minCostToMoveChips(chips1));
        System.out.println(new PlayWithChips().minCostToMoveChips(chips2));
        System.out.println(new PlayWithChips().minCostToMoveChips(chips3));
    }

    private int minCostToMoveChips(int[] chips) {
        int min = 0;
        // 遍历所有筹码的位置，计算将筹码移动到每一个位置的代价，取最小代价
        // 移动偶数次，代价 0；移动奇数次，代价 1；
        for (int i = 0; i < chips.length; i++) {
            int cost = 0;
            for (int chip : chips) {
                if (Math.abs(chip - chips[i]) % 2 == 1) {
                    cost++;
                }
            }
            if (i == 0) {
                min = cost;
            }
            min = Math.min(cost, min);
        }
        return min;
    }
}
