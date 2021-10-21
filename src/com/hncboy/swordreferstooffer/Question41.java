package com.hncboy.swordreferstooffer;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/10/21 8:33
 * @description 剑指 Offer 41.数据流中的中位数
 * 
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 *
 * 示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * 限制：
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 * 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question41 {

    private static class MedianFinder {

        private final Queue<Integer> A;
        private final Queue<Integer> B;

        public MedianFinder() {
            // 小顶堆，保存较大的一半
            A = new PriorityQueue<>();
            // 大顶堆，保存较小的一半
            B = new PriorityQueue<>((x, y) -> (y - x));
        }

        public void addNum(int num) {
            if (A.size() != B.size()) {
                // 如果两个堆大小不一样，先将该数放入小顶堆，然后将小顶堆中最小的数放入大顶堆，
                A.add(num);
                B.add(A.poll());
            } else {
                // 如果两个堆大小一样，先将该数放入大顶堆，然后将大顶堆中最大的数放入小顶堆，
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            // 两个堆大小不一样，小顶堆多了一个数，取出小顶堆最小的元素，否则各自取出堆顶的元素计算中位数
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }
}
