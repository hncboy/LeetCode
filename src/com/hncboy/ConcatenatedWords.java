package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/12/28 9:09
 * 472.连接词
 * 
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 *
 * 示例 1：
 * 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成; 
 *      "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成; 
 *      "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 *
 * 示例 2：
 * 输入：words = ["cat","dog","catdog"]
 * 输出：["catdog"]
 *
 * 提示：
 * 1 <= words.length <= 104
 * 0 <= words[i].length <= 1000
 * words[i] 仅由小写字母组成
 * 0 <= sum(words[i].length) <= 105
 * 通过次数 8,201 提交次数 20,010
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/concatenated-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConcatenatedWords {

    public static void main(String[] args) {
        ConcatenatedWords c = new ConcatenatedWords();
        System.out.println(c.findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"}));
    }

    private TrieNode trieNode;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        // 按字符串长度排序
        Arrays.sort(words, Comparator.comparingInt(String::length));
        trieNode = new TrieNode();
        for (String word : words) {
            // 判断当前单词是否能被组合
            if (canBeConcatenated(word, 0)) {
                result.add(word);
            } else {
                // 不能被组合的话说明可以用来构成组合字符串
                trieNode.addWord(word);
            }
        }
        return result;
    }

    private boolean canBeConcatenated(String s, int start) {
        if (start > 0 && start == s.length()) {
            return true;
        }


        TrieNode curr = trieNode;
        // 遍历所有字符串区间
        for (int i = start; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            // 判断当前节点是否有子节点
            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
            if (curr.isEnd && canBeConcatenated(s, i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static class TrieNode {

        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }

        public void addWord(String s) {
            TrieNode curr = this;
            for (char ch : s.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isEnd = true;
        }
    }
}
