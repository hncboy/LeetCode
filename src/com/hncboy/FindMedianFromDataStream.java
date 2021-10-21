package com.hncboy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2021/10/21 9:17
 * @description 295.数据流的中位数
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianFromDataStream {

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
