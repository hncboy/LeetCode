package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/24 21:00
 * 1185.һ���еĵڼ���
 * 
 * ����һ�����ڣ��������һ���㷨���ж����Ƕ�Ӧһ���е���һ�졣
 * ����Ϊ����������day��month �� year���ֱ��ʾ�ա��¡��ꡣ
 * �����صĽ���������⼸��ֵ�е�һ�� {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}��
 *
 * ʾ�� 1��
 * ���룺day = 31, month = 8, year = 2019
 * �����"Saturday"
 *
 * ʾ�� 2��
 * ���룺day = 18, month = 7, year = 1999
 * �����"Sunday"
 *
 * ʾ�� 3��
 * ���룺day = 15, month = 8, year = 1993
 * �����"Sunday"
 *
 * ��ʾ��
 * ����������һ������ 1971 �� 2100 ��֮�����Ч���ڡ�
 * ͨ������ 20,532 �ύ���� 32,838
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/day-of-the-week
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class DayOfTheWeek {

    public static void main(String[] args) {
        DayOfTheWeek d = new DayOfTheWeek();
        System.out.println(d.dayOfTheWeek1(31, 8, 2019));
        System.out.println(d.dayOfTheWeek1(18, 7, 1999));
        System.out.println(d.dayOfTheWeek1(15, 8, 1993));
    }

    /**
     * ��ķ����ɭ���㹫ʽ
     */
    private String dayOfTheWeek1(int day, int month, int year) {
        // ��һ�ºͶ��¿���Ϊ��һ���ʮ���º�ʮ����
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return week[(day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7];
    }

    public String dayOfTheWeek2(int day, int month, int year) {
        int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int result = 4;

        // ����� 1971 �굽 year �����˶����죬ƽ�� 365 �죬���� 366 ��
        for (int i = 1971; i < year; i++) {
            // �ж��Ƿ�������
            result += isLearYear(i) ? 366 : 365;
        }

        // �ж� month �� year ���ǵڼ���
        for (int i = 1; i < month; i++) {
            result += nums[i - 1];
            if (i == 2 && isLearYear(year)) {
                result++;
            }
        }
        result += day;
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        // ������%7 �������ڼ�
        return week[result % 7];
    }

    private boolean isLearYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
