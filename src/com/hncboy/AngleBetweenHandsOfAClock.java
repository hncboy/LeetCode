package com.hncboy;

/**
 * @author hncboy
 * @date 2020/2/8 23:33
 * @description 1344.时钟指针的夹角
 *
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 *
 * 示例 1：
 * 输入：hour = 12, minutes = 30
 * 输出：165
 *F
 * 示例 2：
 * 输入：hour = 3, minutes = 30
 * 输出；75
 *
 * 示例 3：
 * 输入：hour = 3, minutes = 15
 * 输出：7.5
 *
 * 示例 4：
 * 输入：hour = 4, minutes = 50
 * 输出：155
 *
 * 示例 5：
 * 输入：hour = 12, minutes = 0
 * 输出：0
 *
 * 提示：
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * 与标准答案误差在 10^-5 以内的结果都被视为正确结果。
 */
public class AngleBetweenHandsOfAClock {

    public static void main(String[] args) {
        AngleBetweenHandsOfAClock a = new AngleBetweenHandsOfAClock();
        System.out.println(a.angleClock(12, 30));
        System.out.println(a.angleClock(3, 30));
        System.out.println(a.angleClock(3, 15));
        System.out.println(a.angleClock(4, 50));
        System.out.println(a.angleClock(12, 0));
    }

    public double angleClock(int hour, int minutes) {
        // 分针：1分钟6度
        // 时针：1小时30度

        // 分针顺时针走的角度
        int minutesDegree = minutes * 6;
        // 时针顺时针走的角度
        double hourDegree = hour * 30 + minutes * 0.5;

        double minDegree = Math.abs(minutesDegree - hourDegree);
        minDegree = Math.min(minDegree, 360 - minDegree);
        return minDegree;
    }
}
