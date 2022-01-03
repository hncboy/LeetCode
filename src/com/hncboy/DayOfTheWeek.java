package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/24 21:00
 * 1185.一周中的第几天
 * 
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
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
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 * 通过次数 20,532 提交次数 32,838
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DayOfTheWeek {

    public static void main(String[] args) {
        DayOfTheWeek d = new DayOfTheWeek();
        System.out.println(d.dayOfTheWeek1(31, 8, 2019));
        System.out.println(d.dayOfTheWeek1(18, 7, 1999));
        System.out.println(d.dayOfTheWeek1(15, 8, 1993));
    }

    /**
     * 基姆拉尔森计算公式
     */
    private String dayOfTheWeek1(int day, int month, int year) {
        // 将一月和二月看作为上一年的十三月和十四月
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

        // 计算从 1971 年到 year 经过了多少天，平年 365 天，闰年 366 天
        for (int i = 1971; i < year; i++) {
            // 判断是否是闰年
            result += isLearYear(i) ? 366 : 365;
        }

        // 判断 month 在 year 中是第几天
        for (int i = 1; i < month; i++) {
            result += nums[i - 1];
            if (i == 2 && isLearYear(year)) {
                result++;
            }
        }
        result += day;
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        // 总天数%7 就是星期几
        return week[result % 7];
    }

    private boolean isLearYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
