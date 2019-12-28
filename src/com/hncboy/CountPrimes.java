package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/28 10:13
 * @description 204.��������
 *
 * ͳ������С�ڷǸ����� n ��������������
 *
 * ʾ��:
 * ����: 10
 * ���: 4
 * ����: С�� 10 ������һ���� 4 ��, ������ 2, 3, 5, 7 ��
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes(10));
    }

    /**
     * the Sieve of Eratosthenes
     * ������ɫ��ɸѡ��
     *
     * @param n
     * @return
     */
    private int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        // �����������Ϊ����
        Arrays.fill(isPrim, true);

        for (int i = 2; i * i < n; i++) {
            // �����ǰ��Ϊ����
            if (isPrim[i]) {
                // �ӵ�ǰ����ƽ����ʼ����������ǰ�������������������Ϊ������
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }

        return count;
    }
}
