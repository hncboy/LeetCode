package com.hncboy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/11/16 9:25
 * @description 947.移除最多的同行或同列石头
 *
 * 在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 现在，move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。
 * 我们最多能执行多少次 move 操作？
 *  
 *
 * 示例 1：
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 *
 * 示例 2：
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 *
 * 示例 3：
 * 输入：stones = [[0,0]]
 * 输出：0
 *
 * 提示：
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 */
public class MostStonesRemovedWithSameRowOrColumn {

    private int[] parent = new int[20000];

    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn m = new MostStonesRemovedWithSameRowOrColumn();
        int[][] stones1 = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int[][] stones2 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        int[][] stones3 = {{0, 0}};
        System.out.println(m.removeStones2(stones1));
        System.out.println(m.removeStones2(stones2));
        System.out.println(m.removeStones2(stones3));
    }

    /**
     * 并查集
     *
     * @param stones
     * @return
     */
    private int removeStones2(int[][] stones) {
        int n = stones.length;

        // 初始化并查集
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // 连接行和列
        for (int[] stone : stones) {
            union(stone[0], stone[1] + 10000);
        }

        Set<Integer> set = new HashSet<>();
        // 寻找同一行或同一列连接的节点数量
        for (int[] stone : stones) {
            set.add(find(stone[0]));
        }

        return n - set.size();
    }

    /**
     * 找到 x 的根节点
     *
     * @param x
     * @return
     */
    private int find(int x) {
        int y = x;
        // 找到 x 的根节点
        while (x != parent[x]) {
            x = parent[x];
        }

        // 路径压缩
        while (y != parent[y]) {
            // 记录临时变量
            int z = y;
            y = parent[y];
            // 将 parent[z] 上级节点指向根节点
            parent[z] = x;
        }
        return x;
    }

    /**
     * 连通行和列节点
     *
     * @param c1
     * @param c2
     */
    private void union(int c1, int c2) {
        // 找到两个节点的根节点
        int p1 = find(c1);
        int p2 = find(c2);
        // 如果根节点不是连通的，就连通它们的根节点
        if (p1 != p2) {
            parent[p1] = p2;
        }
    }

    /**
     * dfs
     *
     * @param stones
     * @return
     */
    private int removeStones1(int[][] stones) {
        int n = stones.length;
        // 存放对应石头同一行和同一列石头的连通图
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 将处于同一行和同一列的石头两两相连
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    // graph[i][0] 和 graph[j][0] 存放该石头总共的连通数
                    // 剩下的 1~n-1 依次按顺序存放对应的连通节点
                    graph[i][++graph[i][0]] = j;
                    graph[j][++graph[j][0]] = i;
                }
            }
        }

        int result = 0;
        // 记录该石头是否被访问过
        boolean[] seen = new boolean[n];
        // 遍历所有石头
        for (int i = 0; i < n; ++i) {
            if (!seen[i]) {
                // 石头进栈
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                seen[i] = true;
                // 除去进栈的石头本身
                result--;
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    result++;
                    // 遍历该石头的所有连通石头
                    for (int k = 1; k <= graph[node][0]; k++) {
                        int stone = graph[node][k];
                        // 该连通石头没有被访问过就进栈
                        if (!seen[stone]) {
                            stack.push(stone);
                            seen[stone] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
}
