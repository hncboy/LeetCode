package com.hncboy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2019/12/28 11:06
 * @description 264.���� II
 * 
 * ��дһ�������ҳ��� n ��������
 * ��������ֻ����������2, 3, 5 ����������
 *
 * ʾ��:
 * ����: n = 10
 * ���: 12
 * ����: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 ��ǰ 10 ��������
 * 
 * ˵��:
 * 1�ǳ�����
 * n������1690��
 */
public class UglyNumberII {

    public static void main(String[] args) {
        UglyNumberII u = new UglyNumberII();
        System.out.println(u.nthUglyNumber2(10));
    }

    /**
     * ��С��
     *
     * @param n
     * @return
     */
    private int nthUglyNumber2(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        Long[] result = new Long[n];
        result[0] = 1L;

        for (int i = 0; i < n - 1; i++) {
            if (!queue.contains(result[i] * 2)) {
                queue.add(result[i] * 2);
            }

            if (!queue.contains(result[i] * 3)) {
                queue.add(result[i] * 3);
            }

            if (!queue.contains(result[i] * 5)) {
                queue.add(result[i] * 5);
            }
            result[i + 1] = queue.poll();
        }
        return Math.toIntExact(result[n - 1]);
    }

    /**
     * ��̬�滮
     * ��ָ��
     *
     * @param n
     * @return
     */
    private int nthUglyNumber1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[t2] * 2, Math.min(dp[t3] * 3, dp[t5] * 5));
            if (min == dp[t2] * 2) {
                t2++;
            }
            if (min == dp[t3] * 3) {
                t3++;
            }
            if (min == dp[t5] * 5) {
                t5++;
            }
            dp[i] = min;
        }

        return dp[n - 1];
    }
}
