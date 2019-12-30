package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/29 10:28
 * @description 1304.��Ϊ���N��Ψһ����
 *
 * ����һ������n�����㷵�� ����һ���� n�� ������ͬ��������ɵ����飬������ n ������Ӻ�Ϊ 0 ��
 *
 * ʾ�� 1��
 * ���룺n = 5
 * �����[-7,-1,1,3,4]
 * ���ͣ���Щ����Ҳ����ȷ�� [-5,-1,1,2,3]��[-3,-1,2,-2,4]��
 * 
 * ʾ�� 2��
 * ���룺n = 3
 * �����[-1,0,1]
 * 
 * ʾ�� 3��
 * ���룺n = 1
 * �����[0]
 *
 * ��ʾ��
 * 1 <= n <= 1000
 */
public class FindNUniqueIntegersSumUpToZero {

    public static void main(String[] args) {
        FindNUniqueIntegersSumUpToZero f = new FindNUniqueIntegersSumUpToZero();
        System.out.println(Arrays.toString(f.sumZero(5)));
        System.out.println(Arrays.toString(f.sumZero(3)));
        System.out.println(Arrays.toString(f.sumZero(1)));
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n / 2; i++) {
            result[i * 2] = i + 1;
            result[i * 2 + 1] = -(i + 1);
        }
        return result;
    }
}
