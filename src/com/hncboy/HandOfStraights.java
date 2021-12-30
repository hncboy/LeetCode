package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2021/12/30 8:57
 * 846.一手顺子
 * 
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。
 * 如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 *
 * 示例 2：
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 *  
 * 提示：
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 *
 * 注意：此题目与 1296 {@link DivideArrayInSetsOfKConsecutiveNumbers}
 * 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 * 通过次数 11,211 提交次数 21,039
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HandOfStraights {

    public static void main(String[] args) {
        HandOfStraights h = new HandOfStraights();
        System.out.println(h.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(h.isNStraightHand(new int[]{1, 2, 3, 6, 2, 4, 6, 7, 8}, 3));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        // 数量不够分组直接返回
        if (hand.length % groupSize > 0) {
            return false;
        }

        Arrays.sort(hand);
        int[] buckets = new int[groupSize];
        for (int i = 0; i < hand.length; i++) {
            // 判断是否是连续的牌
            if (i % groupSize != 0 && hand[i] - hand[i - 1] > 1) {
                return false;
            }
            // 如果最后是三组顺子的话，则每个桶中牌的数量会是一致的
            buckets[hand[i] % groupSize]++;
        }

        // 判断每个桶牌的数量是否相等
        for (int count : buckets) {
            if (count != buckets[0]) {
                return false;
            }
        }
        return true;
    }
}
