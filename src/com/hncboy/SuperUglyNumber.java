package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/28 12:14
 * @description 313.��������
 *
 * ��дһ�γ��������ҵ� n ������������
 * ����������ָ���������������ǳ���Ϊk�������б�primes�е���������
 *
 * ʾ��:
 * ����: n = 12, primes = [2,7,13,19]
 * ���: 32
 * ����: ��������Ϊ 4 �������б� primes = [2,7,13,19]��ǰ 12 ��������������Ϊ��[1,2,4,7,8,13,14,16,19,26,28,32] ��
 *
 * ˵��:
 * 1���κθ���primes�ĳ���������
 * ����primes�е��������������С�
 * 0 < k �� 100, 0 < n �� 106, 0 < primes[i] < 1000 ��
 * ��n����������ȷ���� 32 λ�з�������Χ�ڡ�
 */
public class SuperUglyNumber {

    public static void main(String[] args) {
        SuperUglyNumber s = new SuperUglyNumber();
        System.out.println(s.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

    private int nthSuperUglyNumber(int n, int[] primes) {
        // ͳ��ÿ����ʹ�õĴ���
        int[] count = new int[primes.length];
        // ͳ��ÿ��λ�ö�Ӧ�ĳ���
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            // �������㵱ǰ��С�ĳ���
            for (int j = 0; j < primes.length; j++) {
                // ���㵱ǰ������Ӧ����С����
                min = Math.min(min, primes[j] * dp[count[j]]);
            }

            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                // �����ǰ���������*�����ܵõ���Сֵ��������������+1
                if (min == primes[j] * dp[count[j]]) {
                    count[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}
