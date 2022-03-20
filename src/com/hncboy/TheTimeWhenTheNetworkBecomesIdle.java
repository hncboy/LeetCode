package com.hncboy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2022/3/20 12:33
 * 2039.网络空闲的时刻
 *
 * 通过次数 7,281 提交次数 13,923
 */
public class TheTimeWhenTheNetworkBecomesIdle {

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[n];
        for (int[] v : edges) {
            adj[v[0]].add(v[1]);
            adj[v[1]].add(v[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visit[0] = true;
        int dist = 1;
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int v : adj[curr]) {
                    if (visit[v]) {
                        continue;
                    }
                    queue.offer(v);
                    int time = patience[v] * ((2 * dist - 1) / patience[v]) + 2 * dist + 1;
                    result = Math.max(result, time);
                    visit[v] = true;
                }
            }
            dist++;
        }
        return result;
    }
}
