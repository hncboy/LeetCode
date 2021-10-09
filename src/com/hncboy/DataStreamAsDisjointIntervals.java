package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/10/9 7:57
 * @description 352.将数据流变为多个不相交区间
 * 
 * 给你一个由非负整数a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 * 实现 SummaryRanges 类：
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间[starti, endi] 的列表形式返回对数据流中整数的总结。
 * 
 *
 * 示例：
 * 输入：
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * 输出：
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 * 解释：
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // 返回 [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 *
 * 提示：
 * 0 <= val <= 104
 * 最多调用addNum 和 getIntervals 方法 3 * 104 次
 * 
 * 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DataStreamAsDisjointIntervals {

    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        s.addNum(1);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(3);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(7);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(2);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(6);
        System.out.println(Arrays.deepToString(s.getIntervals()));
    }

    private static class SummaryRanges {

        /**
         * 定义升序排序的 TreeSet
         */
        private final TreeSet<int[]> treeSet = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        private final int[] head = new int[]{-10, -10};

        public SummaryRanges() {
            // 初始化 head 和 tail 分别代表正无穷和负无穷，确保调用 floor/ceiling 时不会返回空
            treeSet.add(head);
            treeSet.add(new int[]{10010, 10010});
        }

        public void addNum(int val) {
            int[] curr = new int[]{val, val};
            // 返回 TreeSet 中集合第一个元素小于或等于 val 的集合
            int[] prev = treeSet.floor(curr);
            // 返回 TreeSet 中集合第一个元素大于或等于 val 的集合
            int[] next = treeSet.ceiling(curr);

            // 如果当前插入的 val 在 [prev[0], prev[1]] 区间或 [next[0], next[1]] 区间，则不用更新区间
            if ((prev[0] <= val && val <= prev[1]) || (next[0] <= val && val <= next[1])) {
                return;
            }

            // 如果当前插入的值正好比前一个区间的 prev[1] 大 1，比后一个区间的 next[0] 小 1，则合并 prev 和 next 两个区间
            if (prev[1] + 1 == val && next[0] - 1 == val) {
                prev[1] = next[1];
                treeSet.remove(next);
                return;
            }

            // 如果当前插入的值正好比前一个区间的 prev[1] 大 1，则 prev[1]+1，也就是 prev[1]=val
            if (prev[1] + 1 == val) {
                prev[1] = val;
                return;
            }

            // 如果当前插入的值正好比后一个区间的 next[0] 小 1，则 next[0]-1，也就是 next[0]=val
            if (next[0] - 1 == val) {
                next[0] = val;
                return;
            }

            // 啥都不是，则直接插入对应的区间
            treeSet.add(curr);
        }

        public int[][] getIntervals() {
            int n = treeSet.size();
            int[][] result = new int[n - 2][2];
            // 获取 head 作为 curr，从比 head 大的区间开始取
            int[] curr = head;
            for (int i = 0; i < n - 2; i++) {
                result[i] = treeSet.ceiling(new int[]{curr[0] + 1, curr[1] + 1});
                curr = result[i];
            }
            return result;
        }
    }
}
