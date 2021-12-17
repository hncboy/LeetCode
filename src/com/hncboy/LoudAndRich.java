package com.hncboy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hncboy
 * @date 2021/12/15 9:03
 * @description 851.喧闹和富有
 */
public class LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[][] w = new int[n][n];
        int[] in = new int[n];
        for (int[] r : richer) {
            int a = r[0], b = r[1];
            w[a][b] = 1; in[b]++;
        }
        Deque<Integer> d = new ArrayDeque<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
            if (in[i] == 0) d.addLast(i);
        }
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int u = 0; u < n; u++) {
                if (w[t][u] == 1) {
                    if (quiet[result[t]] < quiet[result[u]]) {
                        result[u] = result[t];
                    }
                    if (--in[u] == 0) {
                        d.addLast(u);
                    }
                }
            }
        }
        return result;
    }
}
