package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2021/12/20 8:51
 * @description 475.供暖器
 * 
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 示例 1:
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 *
 * 示例 2:
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 *
 * 示例 3：
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 *
 * 提示：
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109
 * 通过次数 25,923 提交次数 73,778
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Heaters {

    public static void main(String[] args) {
        Heaters h = new Heaters();
        System.out.println(h.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int n = heaters.length;
        int i = 0;
        // 遍历所有房屋
        for (int house : houses) {
            // 找打位于 house 右侧的供暖期
            while (i < n && heaters[i] < house) {
                i++;
            }

            if (i == 0) {
                // 第一个供暖期就位于房屋右侧，计算此时的满足条件的最大半径
                radius = Math.max(radius, heaters[i] - house);
            } else if (i == n) {
                // 最后一个供暖期位于房屋右侧，计算此时的满足条件的最大半径
                radius = Math.max(radius, houses[houses.length - 1] - heaters[n - 1]);
            } else {
                // 取房租左右两侧最小半径的供暖期
                radius = Math.max(radius, Math.min(heaters[i] - house, house - heaters[i - 1]));
            }
        }
        return radius;
    }
}
