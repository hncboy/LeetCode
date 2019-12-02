package com.hncboy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/12/2 8:51
 * @description 30.串联所有单词的子串
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * 示例 1：
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 *
 * 示例 2：
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 */
public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(s.findSubstring("a", new String[]{"a", "a"}));
        System.out.println(s.findSubstring("foobarfoobar", new String[]{"foo", "bar"}));
        System.out.println(s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(s.findSubstring("aaaaaaaa", new String[]{"aa", "aa", "aa"}));
        System.out.println(s.findSubstring("a", new String[]{"a"}));
    }

    private List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return result;
        }

        // 存放单词的 Map
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // 单词数量
        int count = words.length;
        // 每个单词长度
        int wordLength = words[0].length();

        // 遍历单词的长度，因为 j+wordLength 可能回导致 j+1，j+2 这些单词匹配不到
        for (int i = 0; i < wordLength; i++) {
            // 遍历字符串，每次遍历 j 的值都加上单词的长度
            for (int j = i; j <= s.length() - wordLength * count; j += wordLength) {
                Map<String, Integer> matchWordMap = new HashMap<>();
                // 根据单词的个数进行遍历，倒序遍历，可以减少不匹配时的匹配次数
                for (int k = count - 1; k >= 0; k--) {
                    // 取出当前的单词
                    String word = s.substring(j + k * wordLength, j + (k + 1) * wordLength);
                    // 取出已经匹配的该单词数量
                    int value = matchWordMap.getOrDefault(word, 0) + 1;
                    // 如果该单词的匹配数量超过实际需要匹配的次数，结束匹配
                    if (value > wordMap.getOrDefault(word, 0)) {
                        // j 需要加上当前已经匹配的字符串长度，防止重复的单词出现
                        j += k * wordLength;
                        break;
                    }
                    // 最后一个匹配成功
                    if (k == 0) {
                        result.add(j);
                    } else {
                        // 将该单词插入 map
                        matchWordMap.put(word, value);
                    }
                }
            }
        }
        return result;
    }
}
