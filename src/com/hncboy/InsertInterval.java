package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/8 13:00
 * @description 57.插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 *
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval i = new InsertInterval();
        int[][] intervals1 = new int[][]{{1, 3}, {6, 9}};
        int[][] intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval1 = new int[]{2, 5};
        int[] newInterval2 = new int[]{4, 8};
        System.out.println(Arrays.deepToString(i.insert(intervals1, newInterval1)));
        System.out.println(Arrays.deepToString(i.insert(intervals2, newInterval2)));
    }

    private int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergeList = new ArrayList<>();
        int i = 0;
        int length = intervals.length;
        // 遍历找到有重合部分的第一个区间或直接插入到末尾
        while (i < length && newInterval[0] > intervals[i][1]) {
            mergeList.add(intervals[i]);
            i++;
        }

        int left = newInterval[0];
        int right = newInterval[1];
        // 从有重合的区间开始遍历找到有重合的最后一个区间，并合并这段区间
        while (i <length && newInterval[1] >= intervals[i][0]) {
            left = Math.min(left, intervals[i][0]);
            right = Math.max(right, intervals[i][1]);
            i++;
        }

        // 插入合并后的区间
        mergeList.add(new int[]{left, right});

        // 遍历剩下的区间并插入
        while (i < length) {
            mergeList.add(intervals[i]);
            i++;
        }

        return mergeList.toArray(new int[mergeList.size()][2]);
     }
}
