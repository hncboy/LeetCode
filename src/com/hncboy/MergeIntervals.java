package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/6 10:13
 * @description 56.合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(new MergeIntervals().merge(intervals));
    }

    private int[][] merge(int[][] intervals) {
        List<int[]> mergeList = new ArrayList<>();
        if (intervals.length == 0) {
            return intervals;
        }
        // 将二维数组根据第一个数进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        mergeList.add(new int[]{intervals[0][0], intervals[0][1]});

        int j = 0;
        while (j < intervals.length - 1) {
            int l1 = mergeList.get(mergeList.size() - 1)[0];
            int r1 = mergeList.get(mergeList.size() - 1)[1];
            int l2 = intervals[j + 1][0];
            int r2 = intervals[j + 1][1];

            j++;
            if (r1 < l2) {
                // 情况1：两个区间互不相交，新增一个区间
                mergeList.add(new int[]{l2, r2});
            } else {
                // 情况2：两个区间有相交，在原来区间上修改
                mergeList.set(mergeList.size() - 1,
                        new int[]{Math.min(l1, l2), Math.max(r1, r2)});
            }
        }
        return mergeList.toArray(new int[mergeList.size()][2]);
    }
}
