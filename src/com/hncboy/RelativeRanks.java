package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2021/12/2 8:45
 * @description 506.相对名次
 * 
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 * 示例 1：
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 *
 * 示例 2：
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 *
 * 提示：
 * n == score.length
 * 1 <= n <= 104
 * 0 <= score[i] <= 106
 * score 中的所有值 互不相同
 * 
 * 通过次数 26,100 提交次数 45,187
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        // 记录原来分数的值和顺序
        int[][] array = new int[n][2];
        for (int i = 0; i < n; ++i) {
            array[i][0] = score[i];
            array[i][1] = i;
        }
        // 按分数对 array 排序
        Arrays.sort(array, (a, b) -> b[0] - a[0]);

        String[] result = new String[n];

        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < n; ++i) {
            // 将原始的位置赋值排名
            if (i >= 3) {
                result[array[i][1]] = Integer.toString(i + 1);
            } else {
                result[array[i][1]] = desc[i];
            }
        }
        return result;
    }
}
