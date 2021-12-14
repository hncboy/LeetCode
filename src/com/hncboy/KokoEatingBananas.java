package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/14 9:35
 * @description 875.爱吃香蕉的珂珂
 * 
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 *
 * 示例 2：
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 *
 * 示例 3：
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *
 * 提示：
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * 通过次数 50,445 提交次数 104,514
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        // 计算吃完香蕉的最大速度
        int maxSpeed = 1;
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxSpeed;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 如果吃完这堆香蕉的时间大于 h，则表示速度太慢了，需要提升
            if (calcTime(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 计算根据 speed 速度吃完香蕉所需的时间
     */
    private int calcTime(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 向上取整
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }
}
