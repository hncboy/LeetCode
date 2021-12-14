package com.hncboy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hncboy
 * @date 2021/12/14 8:57
 * @description 630.课程表 III
 * 
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，
 * 其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 * 返回你最多可以修读的课程数目。
 *
 * 示例 1：
 * 输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * 输出：3
 * 解释：
 * 这里一共有 4 门课程，但是你最多可以修 3 门：
 * 首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
 * 第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
 * 第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
 * 第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
 *
 * 示例 2：
 * 输入：courses = [[1,2]]
 * 输出：1
 *
 * 示例 3：
 * 输入：courses = [[3,2],[4,3]]
 * 输出：0
 *
 * 提示:
 * 1 <= courses.length <= 104
 * 1 <= durationi, lastDayi <= 104
 * 通过次数 7,847 提交次数 20,183
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CourseScheduleIii {

    public int scheduleCourse(int[][] courses) {
        // 按课程截止时间升序排序
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        // 大根堆，将学习时长更长的在堆顶
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // 记录总学习时长
        int total = 0;
        // 按截止时间从近到远遍历课程
        for (int[] course : courses) {
            // 如果总时长不会超过截止时间，那么，当前这门课程可以选择，直接入堆
            if (total + course[0] <= course[1]) {
                total += course[0];
                heap.offer(course);
                continue;
            }

            // 如果总时长超过截止时间 并且 该课程学习时间小于堆顶课程的学习时间
            if (!heap.isEmpty() && heap.peek()[0] > course[0]) {
                // 选择学习时长更短的课程，淘汰堆顶课程
                total = total - heap.poll()[0] + course[0];
                heap.offer(course);
            }
        }
        // 堆中有多少课程就是结果
        return heap.size();
    }
}
