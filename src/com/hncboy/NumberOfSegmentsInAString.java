package com.hncboy;

/**
 * @author hncboy
 * @date 2021/10/7 9:38
 * @description 434.字符串中的单词数
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfSegmentsInAString {

    public static void main(String[] args) {
        NumberOfSegmentsInAString n = new NumberOfSegmentsInAString();
        System.out.println(n.countSegments("Hello, my name is John") == 5);
        System.out.println(n.countSegments(", , , ,        a, eaefa") == 6);
    }

    private int countSegments(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; ) {
            // 跳过空格不计数
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }

            // 对于非空格的字符，遍历完一整个单词后进行一次统计
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            result++;
        }
        return result;
    }
}
