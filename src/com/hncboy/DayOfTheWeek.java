package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/24 21:00
 * @description 1185.一周中的第几天
 *
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。

 *
 * 示例 1：
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 *
 * 示例 2：
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 *
 * 示例 3：
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 * 提示：
 * 给出的日期一定是在1971 到2100年之间的有效日期。
 */
public class DayOfTheWeek {

    public static void main(String[] args) {
        DayOfTheWeek d = new DayOfTheWeek();
        System.out.println(d.dayOfTheWeek(31, 8, 2019));
        System.out.println(d.dayOfTheWeek(18, 7, 1999));
        System.out.println(d.dayOfTheWeek(15, 8, 1993));
    }

    /**
     * 基姆拉尔森计算公式
     *
     * @param day
     * @param month
     * @param year
     * @returnl
     */
    private String dayOfTheWeek(int day, int month, int year) {
        // 将一月和二月看作为上一年的十三月和十四月
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return week[(day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7];
    }
}
