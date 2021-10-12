package com.hncboy;

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
        System.out.println(u.nthUglyNumber(10));
    }

    /**
     * ��̬�滮
     * ��ָ��
     *
     * @param n
     * @return
     */
    private int nthUglyNumber(int n) {
        // ��˳���ų���
        int[] dp = new int[n];
        // ��ŵ�һ������
        dp[0] = 1;
        // ��Ŷ�Ӧ������һ�����ڼ���������±�
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 1; i < n; i++) {
            // ��a����������Ҫͨ����2���õ��¸���������b����������Ҫͨ����2���õ��¸�������ͬ���c����
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;

            // �����һ����С�ĳ�����ȡ���������ó��˻���С��һ�֣�ʹ�ó�����˳������
            dp[i] = Math.min(Math.min(n2, n3), n5);
            // �ж��õ����ĸ������ó�����С������Ȼ�����Ӧ�ĳ����±�+1�����ڼ��������ظ����������ʱ�����±궼��+1
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
