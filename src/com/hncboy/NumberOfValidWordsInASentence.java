package com.hncboy;

/**
 * @author hncboy
 * @date 2022/1/27 9:46
 * 2047.句子中的有效单词数
 *
 * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。
 * 每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
 *
 * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
 * 仅由小写字母、连字符和/或标点（不含数字）。
 * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
 * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
 * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
 *
 * 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。
 *
 * 示例 1：
 * 输入：sentence = "cat and  dog"
 * 输出：3
 * 解释：句子中的有效单词是 "cat"、"and" 和 "dog"
 *
 * 示例 2：
 * 输入：sentence = "!this  1-s b8d!"
 * 输出：0
 * 解释：句子中没有有效单词
 * "!this" 不是有效单词，因为它以一个标点开头
 * "1-s" 和 "b8d" 也不是有效单词，因为它们都包含数字
 *
 * 示例 3：
 * 输入：sentence = "alice and  bob are playing stone-game10"
 * 输出：5
 * 解释：句子中的有效单词是 "alice"、"and"、"bob"、"are" 和 "playing"
 * "stone-game10" 不是有效单词，因为它含有数字
 *
 * 示例 4：
 * 输入：sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."
 * 输出：6
 * 解释：句子中的有效单词是 "he"、"bought"、"pencils,"、"erasers,"、"and" 和 "pencil-sharpener."
 *
 * 提示：
 * 1 <= sentence.length <= 1000
 * sentence 由小写英文字母、数字（0-9）、以及字符（' '、'-'、'!'、'.' 和 ','）组成
 * 句子中至少有 1 个 token
 * 通过次数 8,252 提交次数 24,386
 */
public class NumberOfValidWordsInASentence {

    public int countValidWords(String sentence) {
        int n = sentence.length();
        int result = 0;
        for (int start = 0; start < n; ) {
            // 寻找不为空的字符
            if (sentence.charAt(start) == ' ') {
                start++;
                continue;
            }

            // 寻找该串字符串的末尾字符
            int end = start;
            while (end < n && sentence.charAt(end) != ' ') {
                end++;
            }

            // 检查该字符串是否符合条件
            if (check(sentence.substring(start, end))) {
                result++;
            }
            start = end + 1;
        }
        return result;
    }

    private boolean check(String s) {
        int n = s.length();
        if (n == 0) {
            return false;
        }

        // c1 表示连字符的数量，c2 表示标点符号的数量
        for (int i = 0, c1 = 0, c2 = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 不能是数字
            if (Character.isDigit(ch)) {
                return false;
            }

            // 不能是空字符
            if (ch == ' ') {
                return false;
            }

            // 判断连字符
            if (ch == '-') {
                c1++;

                // '-' 在每个单词中最多存在一个，且不能是第一个和最后一个
                if (c1 > 1 || (i == 0 || i == n - 1)) {
                    return false;
                }

                // '-' 的上一个字符和下一个字符只能是单词
                if (!Character.isLetter(s.charAt(i - 1)) || !Character.isLetter(s.charAt(i + 1))) {
                    return false;
                }
            }

            // 判断标点符号
            if (ch == '!' || ch == '.' || ch == ',') {
                c2++;
                // 标点符号只能最在一个，而且必须是最后一个
                if (c2 > 1 || (i != n - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
