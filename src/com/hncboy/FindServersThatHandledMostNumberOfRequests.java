package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2022/3/30 8:34
 * 1606.找到处理最多请求的服务器 TODO
 * 
 * 通过次数 3,041 提交次数 7,311
 */
public class FindServersThatHandledMostNumberOfRequests {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // 存放空闲服务器的序号
        PriorityQueue<Integer> available = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            available.offer(i);
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int id = busy.peek()[1];
                busy.poll();
                // 保证得到的是一个不小于 i 的且与 id 同余的数
                available.offer(i + ((id - i) % k + k) % k);
            }
            if (available.isEmpty()) {
                continue;
            }
            int server = available.poll() % k;
            requests[server]++;
            busy.offer(new int[]{arrival[i] + load[i], server});
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                result.add(i);
            }
        }
        return result;
    }
}
