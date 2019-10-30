package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/30 16:53
 * @description 58.最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord(""));
    }

    private int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        // 去掉最后的空格
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }

        // 从最后非空格的位置开始统计，直到遇到空格
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        // end-start 即为最后一个单词长度
        return end - start;
    }
}
