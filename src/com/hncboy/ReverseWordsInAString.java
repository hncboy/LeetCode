package com.hncboy;

/**
 * @author hncboy
 * @date 2020/4/10 22:06
 * @description 151.翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 进阶：
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        ReverseWordsInAString r = new ReverseWordsInAString();
        System.out.println(r.reverseWords("the sky is blue"));
        System.out.println(r.reverseWords("  hello world  "));
        System.out.println(r.reverseWords("a good   example"));
        System.out.println(r.reverseWords("  Bob    Loves  Alice   "));
        System.out.println(r.reverseWords("Alice does not even like bob"));
    }

    private String reverseWords(String s) {
        // 去除字符串空格
        s = s.trim();
        // 单词的左右边界
        int right = s.length() - 1;
        int left = right;

        StringBuilder result = new StringBuilder();
        while (left >= 0) {
            // 从第一个不为空格的字符往前遍历，直到找到为空格的字符
            while (left >= 0 && s.charAt(left) != ' ') {
                left--; // 搜索首个空格
            }

            // 添加一个单词
            result.append(s, left + 1, right + 1).append(" ");

            // 跳过单词间的空格
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }

            // right 指向下个单词的尾字符
            right = left;
        }
        return result.toString().trim();
    }
}
