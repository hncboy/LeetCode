package com.hncboy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2019/12/2 19:43
 * @description 743.网络延迟时间
 *
 * 有 N 个网络节点，标记为 1 到 N。
 * 给定一个列表 times，表示信号经过有向边的传递时间。 
 * times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 * 现在，我们向当前的节点 K 发送了一个信号。
 * 需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 *
 * 注意:
 * N 的范围在 [1, 100] 之间。
 * K 的范围在 [1, N] 之间。
 * times 的长度在 [1, 6000] 之间。
 * 所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        NetworkDelayTime n = new NetworkDelayTime();
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int[][] times2 = {{1, 2, 1}};
        System.out.println(n.networkDelayTime3(times1, 4, 2)); // 2
        System.out.println(n.networkDelayTime3(times2, 2, 2)); // -1
    }

    /**
     * SPFA 算法（队列优化的Bellman-Ford）
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
    private int networkDelayTime4(int[][] times, int N, int K) {
        // 构建邻接表，用于存放各个点到各个点的距离
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = i == j ? 0 : -1;
            }
        }
        // 遍历times填充邻接表
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        // 存放 K 到各个点的最短路径，最大的那个最短路径即为结果
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[K] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(K);

        while (!queue.isEmpty()) {
            // 取出队首节点
            int curr = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[curr][i] != -1 && (distance[i] == -1 || distance[i] > distance[curr] + graph[curr][i])) {
                    // 当最短距离发生变化且不在队列中时，将该节点加入队列
                    distance[i] = distance[curr] + graph[curr][i];
                    if (!queue.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == -1) {
                return -1;
            }
            maxDistance = Math.max(distance[i], maxDistance);
        }

        return maxDistance;
    }

    /**
     * Bellman-Ford 算法
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
    private int networkDelayTime3(int[][] times, int N, int K) {
        // 存放 K 到各个点的最短路径，最大的那个最短路径即为结果
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[K] = 0;

        // 进行 N-1 轮的松弛，因为任意两点间的最短路径最多包含 N-1 条边
        for (int i = 1; i <= N - 1; i++) {
            for (int[] time : times) {
                // 源节点
                int u = time[0];
                // 目标节点
                int v = time[1];
                // 一个信号源从源节点到目标节点的时间
                int w = time[2];
                // 判断能否通过 u->v 缩短 distance[v]（松弛）
                if (distance[u] != -1) {
                    if (distance[v] == -1) {
                        distance[v] = distance[u] + w;
                    } else {
                        distance[v] = Math.min(distance[v], distance[u] + w);
                    }
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == -1) {
                return -1;
            }
            maxDistance = Math.max(distance[i], maxDistance);
        }

        return maxDistance;
    }


    /**
     * Floyd 算法
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
    private int networkDelayTime2(int[][] times, int N, int K) {
        // 构建邻接表，用于存放各个点到各个点的距离
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = i == j ? 0 : -1;
            }
        }
        // 遍历times填充邻接表
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        // 遍历所有节点，k 表示使用k节点进行松弛
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // 使用 k 松弛 i->j 的最短路径
                    if (graph[i][k] != -1 && graph[k][j] != -1) {
                        if (graph[i][j] != -1) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        } else {
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }
                    }
                }
            }
        }

        int maxDistance = 0;
        // 遍历 K 到所有节点的最短路径的最大值
        for (int i = 1; i <= N; i++) {
            if (graph[K][i] == -1) {
                return -1;
            }
            maxDistance = Math.max(maxDistance, graph[K][i]);
        }
        return maxDistance;
    }


    /**
     * Dijkstra 算法
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
    private int networkDelayTime1(int[][] times, int N, int K) {
        // 构建邻接表，用于存放各个点到各个点的距离
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = -1;
            }
        }
        // 遍历times填充邻接表
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        // 存放 K 到各个点的最短路径，最大的那个最短路径即为结果
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        // 初始化 distance 为 K 到各个节点的距离
        for (int i = 1; i <= N; i++) {
            distance[i] = graph[K][i];
        }
        // K到达K本身的节点初始化为 0
        distance[K] = 0;

        // 判断是否找到K到达该点最短路径
        boolean[] visited = new boolean[N + 1];
        visited[K] = true;

        // 遍历除K本身节点之外的所有N-1个节点
        for (int i = 1; i <= N - 1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = 1;
            // 遍历所有节点，找到离K最近的节点
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && distance[j] != -1 && distance[j] < minDistance) {
                    minDistance = distance[j];
                    minIndex = j;
                }
            }

            // 标记最近距离节点找到
            visited[minIndex] = true;

            // 根据刚刚找到的最短距离节点，通过该节点更新K节点与其他的节点的距离
            for (int j = 1; j <= N; j++) {
                // 如果已更新的最短节点可以到达当前节点
                if (graph[minIndex][j] != -1) {
                    if (distance[j] != -1) {
                        // 取之前路径与当前更新路径的最小值
                        distance[j] = Math.min(distance[j], distance[minIndex] + graph[minIndex][j]);
                    } else {
                        // 该节点是第一次访问，直接更新
                        distance[j] = distance[minIndex] + graph[minIndex][j];
                    }
                }
            }
        }

        int maxDistance = 0;
        // 遍历最大值，如果有节点未被访问，返回 -1，否则返回最大最短路径
        for (int i = 1; i <= N; i++) {
            if (distance[i] == -1) {
                return -1;
            }
            maxDistance = Math.max(distance[i], maxDistance);
        }

        return maxDistance;
    }
}
