package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2022/2/28 8:50
 * 1601.最多可达成的换楼请求数目
 */
public class MaximumNumberOfAchievableTransferRequests {

    public static void main(String[] args) {
        MaximumNumberOfAchievableTransferRequests m = new MaximumNumberOfAchievableTransferRequests();
        System.out.println(m.maximumRequests(5, new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
    }

    public int maximumRequests(int n, int[][] requests) {
        int[] delta = new int[n];
        int result = 0;
        for (int mask = 0; mask < (1 << requests.length); mask++) {
            int count = Integer.bitCount(mask);
            if (count <= result) {
                continue;
            }
            Arrays.fill(delta, 0);
            for (int i = 0; i < requests.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    delta[requests[i][0]]++;
                    delta[requests[i][1]]--;
                }
            }
            boolean flag = true;
            for (int x : delta) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = count;
            }
        }
        return result;
    }
}
