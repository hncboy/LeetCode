package com.hncboy;

import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/11/18 9:27
 * @description 539.最小时间差
 * 
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 * 示例 1：
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 *
 * 示例 2：
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 * 提示：
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTimeDifference {

    public static void main(String[] args) {
        MinimumTimeDifference m = new MinimumTimeDifference();
        System.out.println(m.findMinDifference(Arrays.asList("23:59", "00:00")));
    }

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        // 超过 24*60，肯定会有重复的
        if (n > 1440) {
            return 0;
        }

        // // 将时间全部转化为分钟
        int[] minutes = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String hour = timePoints.get(i).substring(0, 2);
            String minute = timePoints.get(i).substring(3, 5);
            minutes[i] = Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
        }

        // 最后一位取 1440
        minutes[n] = 1440;
        Arrays.sort(minutes);
        minutes[n] = minutes[0] + 1440;
        int min = 1440;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, minutes[i + 1] - minutes[i]);
        }
        return min;
    }
}
