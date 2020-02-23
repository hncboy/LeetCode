package com.hncboy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author hncboy
 * @date 2020/2/23 10:26
 * @description 5169.日期之间隔几天
 *
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 *
 * 示例 1：
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 *
 * 示例 2：
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 *
 * 提示：
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 */
public class NumberOfDaysBetweenTwoDates {

    public static void main(String[] args) {
        NumberOfDaysBetweenTwoDates n = new NumberOfDaysBetweenTwoDates();
        System.out.println(n.daysBetweenDates1("2019-06-29", "2019-06-30"));
        System.out.println(n.daysBetweenDates1("2020-01-15", "2019-12-31"));
    }

    private int daysBetweenDates2(String date1, String date2) {
        LocalDate startDate = LocalDate.parse(date1);
        LocalDate endDate = LocalDate.parse(date2);
        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        return Math.abs((int) daysDiff);
    }

    private int daysBetweenDates1(String date1, String date2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        long duration = 0L;
        try {
            long endTime = format.parse(date2).getTime();
            long startTime = format.parse(date1).getTime();
            duration = (endTime - startTime) / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) Math.abs(duration);
    }
}
