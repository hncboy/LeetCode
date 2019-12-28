package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/28 10:52
 * @description 263.����
 * 
 * ��дһ�������жϸ��������Ƿ�Ϊ������
 * ��������ֻ����������2, 3, 5����������
 *
 * ʾ�� 1:
 * ����: 6
 * ���: true
 * ����: 6 = 2 ��3
 * 
 * ʾ�� 2:
 * ����: 8
 * ���: true
 * ����: 8 = 2 �� 2 ��2
 * 
 * ʾ��3:
 * ����: 14
 * ���: false 
 * ����: 14 ���ǳ�������Ϊ������������һ��������7��
 * ˵����
 * 1�ǳ�����
 * ���벻�ᳬ�� 32 λ�з��������ķ�Χ:[-231, 231- 1]��
 */
public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        System.out.println(u.isUgly(6));
        System.out.println(u.isUgly(8));
        System.out.println(u.isUgly(14));
    }

    private boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
