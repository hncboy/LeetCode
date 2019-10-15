package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/10/14 18:57
 * @description 140.单词拆分 II
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * 示例 2：
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */
public class WordBreakII {

    /**
     * key：对应下标
     * value：对应下标到结尾构成的符合的子串组合
     */
    private HashMap<Integer, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "bigcatsanddog";
        List<String> wordDict = Arrays.asList("big", "cats", "dog", "sand", "and", "cat");
        System.out.println(new WordBreakII().wordBreak(s, wordDict));
    }

    private List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    private List<String> wordBreak(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        LinkedList<String> result = new LinkedList<>();
        // 当 start == s.length() 时，表示刚好可以该组合满足
        if (start == s.length()) {
            result.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            // 对每种情况的单词都进行遍历
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, wordDict, end);
                // 遍历返回的list，将每个符合的字符串插入 result
                for (String sub : list) {
                    result.add(s.substring(start, end) + (sub.equals("") ? "" : " ") + sub);
                }
            }
        }

        map.put(start, result);
        return result;
    }
}
