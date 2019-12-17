package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/12/17 11:23
 * @description 1010.总持续时间可被 60 整除的歌曲
 *
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 * 示例 1：
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 *
 * 示例 2：
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 *
 * 提示：
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {
        PairsOfSongsWithTotalDurationsDivisibleBy60 p = new PairsOfSongsWithTotalDurationsDivisibleBy60();
        System.out.println(p.numPairsDivisibleBy60II(new int[]{30, 20, 150, 100, 40}));
        System.out.println(p.numPairsDivisibleBy60II(new int[]{60, 60, 60}));
    }

    private int numPairsDivisibleBy60II(int[] time) {
        int[] second = new int[60];
        for (int i = 0; i < time.length; i++) {
            second[time[i] % 60]++;
        }

        // 0 或 30 的话两两组合能直接被 60 整除
        int count = (second[0] * (second[0] - 1) + second[30] * (second[30] - 1)) / 2;

        // 计算能两两组合结果为 60 的数量
        for (int i = 1; i < 30; i++) {
            count += second[i] * second[60 - i];
        }

        return count;
    }


    private int numPairsDivisibleBy60I(int[] time) {
        // 将所有时间都对 60 取余
        for (int i = 0; i < time.length; i++) {
            time[i] %= 60;
        }

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : time) {
            // map 中是否有能和当前 value 组成为 60 的时间
            result += map.getOrDefault((60 - value) % 60, 0);
            // 将当前时间 put 到 map
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return result;
    }
}
