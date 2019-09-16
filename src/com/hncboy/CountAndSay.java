package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/16 12:53
 * @description 38.报数
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 *
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }

    private String countAndSay(int n) {
        String[] strings = new String[n];
        strings[0] = "1";
        for (int i = 1; i < n; i++) {
            strings[i] = countAndSay(strings[i - 1]);
        }
        return strings[n - 1];
    }

    private String countAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int sameCount = 1;
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            // 计算数字出现的次数
            if (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                sameCount++;
            } else {
                // 计算完毕添加
                sb.append(sameCount).append(s.charAt(i));
                sameCount = 1;
            }
        }
        return sb.toString();
    }
}
