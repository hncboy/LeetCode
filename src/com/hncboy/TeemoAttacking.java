package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/23 20:19
 * @description 495.提莫攻击
 *
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
 * 现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 *
 * 示例1:
 * 输入: [1,4], 2
 * 输出: 4
 * 原因: 在第 1 秒开始时，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒钟结束。
 * 在第 4 秒开始时，提莫再次攻击艾希，使得艾希获得另外 2 秒的中毒时间。
 * 所以最终输出 4 秒。
 *
 * 示例2:
 * 输入: [1,2], 2
 * 输出: 3
 * 原因: 在第 1 秒开始时，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒钟结束。
 * 但是在第 2 秒开始时，提莫再次攻击了已经处于中毒状态的艾希。
 * 由于中毒状态不可叠加，提莫在第 2 秒开始时的这次攻击会在第 3 秒钟结束。
 * 所以最终输出 3。
 *
 * 注意：
 * 你可以假定时间序列数组的总长度不超过 10000。
 * 你可以假定提莫攻击时间序列中的数字和提莫攻击的中毒持续时间都是非负整数，并且不超过 10,000,000。
 */
public class TeemoAttacking {

    public static void main(String[] args) {
        TeemoAttacking t = new TeemoAttacking();
        System.out.println(t.findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(t.findPoisonedDuration(new int[]{1, 2}, 2));
    }

    private int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int difference = timeSeries[i + 1] - timeSeries[i];
            total = difference > duration ? total + duration : total + difference;
        }
        return timeSeries.length == 0 ? 0 : total + duration;
    }
}
