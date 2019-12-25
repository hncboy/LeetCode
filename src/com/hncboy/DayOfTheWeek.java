package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/24 21:00
 * @description 1185.һ���еĵڼ���
 *
 * ����һ�����ڣ��������һ���㷨���ж����Ƕ�Ӧһ���е���һ�졣
 * ����Ϊ����������day��month ��year���ֱ��ʾ�ա��¡��ꡣ
 * �����صĽ���������⼸��ֵ�е�һ��{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}��

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
 * ����������һ������1971 ��2100��֮�����Ч���ڡ�
 */
public class DayOfTheWeek {

    public static void main(String[] args) {
        DayOfTheWeek d = new DayOfTheWeek();
        System.out.println(d.dayOfTheWeek(31, 8, 2019));
        System.out.println(d.dayOfTheWeek(18, 7, 1999));
        System.out.println(d.dayOfTheWeek(15, 8, 1993));
    }

    /**
     * ��ķ����ɭ���㹫ʽ
     *
     * @param day
     * @param month
     * @param year
     * @returnl
     */
    private String dayOfTheWeek(int day, int month, int year) {
        // ��һ�ºͶ��¿���Ϊ��һ���ʮ���º�ʮ����
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return week[(day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7];
    }
}
