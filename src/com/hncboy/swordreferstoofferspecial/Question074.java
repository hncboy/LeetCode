package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/1/3 14:31
 * 剑指 Offer II 074.合并区间
 * 
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * 注意：本题与主站 56 题 {@link com.hncboy.MergeIntervals} 相同： https://leetcode-cn.com/problems/merge-intervals/
 * 通过次数 4,785 提交次数 8,366
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/SsGoHC
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question074 {

    public int[][] merge(int[][] intervals) {
        List<int[]> mergeList = new ArrayList<>();
        if (intervals.length == 0) {
            return intervals;
        }

        // 按区间左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        mergeList.add(new int[]{intervals[0][0], intervals[0][1]});

        // 遍历所有区间
        for (int i = 0; i < intervals.length - 1; i++) {
            int left1 = mergeList.get(mergeList.size() - 1)[0];
            int right1 = mergeList.get(mergeList.size() - 1)[1];
            // 获取当前区间
            int left2 = intervals[i + 1][0];
            int right2 = intervals[i + 1][1];

            if (right1 < left2) {
                // 情况1：两个区间互不相交，新增一个区间
                mergeList.add(new int[]{left2, right2});
            } else {
                // 情况2：两个区间有相交，在原来区间上修改
                mergeList.set(mergeList.size() - 1, new int[]{Math.min(left1, left2), Math.max(right1, right2)});
            }
        }

        return mergeList.toArray(new int[mergeList.size()][2]);
    }
}
