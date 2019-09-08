package com.hncboy;

import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/9/8 15:37
 * @description 139.单词拆分
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet7", "code");
        System.out.println(wordBreak(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        int length = s.length();
        boolean[] isContain = new boolean[length + 1];
        isContain[0] = true;

        int maxWordLength = 0; // 最大单词长度
        for (String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        for (int i = 1; i <= length; i++) {
            // j 从最长的单词长度后开始计算
            for (int j = Math.max(i - maxWordLength, 0); j < i; j++) {
                // 判断以 j 结尾的字串是否属于 wordDict
                if (isContain[j] && wordDict.contains(s.substring(j, i))) {
                    isContain[i] = true;
                    break;
                }
            }
        }
        return isContain[length];
    }
}
