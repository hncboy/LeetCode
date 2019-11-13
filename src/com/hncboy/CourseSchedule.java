package com.hncboy;

import java.util.LinkedList;

/**
 * @author hncboy
 * @date 2019/11/13 8:43
 * @description 207.课程表
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
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
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        int[][] prerequisites1 = new int[][]{{1, 0}};
        int[][] prerequisites2 = new int[][]{{1, 0}, {0, 1}};
        System.out.println(c.canFinish1(2, prerequisites1));
        System.out.println(c.canFinish1(2, prerequisites2));
    }

    /**
     * DFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        // 存放每个节点的状态
        int[] status = new int[numCourses];

        // 构造邻接矩阵
        for (int[] prerequisite : prerequisites) {
            adjacency[prerequisite[0]][prerequisite[1]] = 1;
        }

        // 对图中每个节点进行 DFS 遍历
        for (int i = 0; i < numCourses; i++) {
            // 若存在环返回false
            if (!dfs(adjacency, status, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] adjacency, int[] status, int i) {
        // 状态为 1 表示再次访问该节点，表示有环，返回 false
        if (status[i] == 1) {
            return false;
        }
        // 状态为 -1 表示其他节点访问该节点且该节点无法构成环，返回 true
        if (status[i] == -1) {
            return true;
        }
        // 该节点被当前节点启动的 DFS 访问，将该节点的状态置为 1
        status[i] = 1;
        // 遍历邻接矩阵的节点
        for (int j = 0; j < adjacency.length; j++) {
            // 从当前节点开始判断每个邻接节点是否经过，经过的话递归判断是否会再次经过重复的节点
            // 如果 dfs 返回 false，表示重复经过，有个环，返回 false
            if (adjacency[i][j] == 1 && !dfs(adjacency, status, j)) {
                return false;
            }
        }
        // 该节点状态置为 -1 表示无法构成环
        status[i] = -1;
        return true;
    }

    /**
     * 拓扑排序 BFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        // 构造图中每个节点的入度数
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

        // 遍历队列节点，直到为空
        while (!queue.isEmpty()) {
            // 将队首节点出队
            Integer prev = queue.removeFirst();
            // 减去入度数为 0 的课程数量
            numCourses--;
            // 遍历图中所有节点，将图中 prev 节点指向的节点入度数 -1
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] != prev) {
                    continue;
                }
                // 将该节点的入度数 -1，如果减到为 0，则没有其他节点指向该节点，将该节点加入队尾
                if (--degrees[prerequisite[0]] == 0) {
                    queue.addLast(prerequisite[0]);
                }
            }
        }
        return numCourses == 0;
    }
}
