package com.hncboy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author hncboy
 * @date 2019/11/13 19:39
 * @description 210.课程表 II
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 *
 * 示例 2:
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 *
 * 说明:
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 *
 * 提示:
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(c.findOrder(4, prerequisites)));
    }

    private int[] findOrder(int numCourses, int[][] prerequisites) {
        int count = 0;
        // 存放课程的学习顺序
        int[] order = new int[numCourses];
        // 存放图节点的入度数
        int[] degrees = new int[numCourses];
        // 构造图节点的入度数
        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        // 将图中入度数为 0 的节点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.addLast(i);
            }
        }

        // 遍历队列节点直到为空
        while (!queue.isEmpty()) {
            // 将队首节点出队
            Integer prev = queue.removeFirst();
            // 按出队顺序加入课程学习顺序
            order[count++] = prev;
            // 减去入度数为 0 的课程数量
            numCourses--;
            // 遍历图中所有节点，将图中 prev 节点指向的节点入度数 -1
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] != prev) {
                    continue;
                }
                // 将该节点入度数 -1，如果减到为 0，则没有其他节点指向该节点，将该节点加入队尾
                if (--degrees[prerequisite[0]] == 0) {
                    queue.addLast(prerequisite[0]);
                }
            }
        }
        return numCourses == 0 ? order : new int[0];
    }
}
