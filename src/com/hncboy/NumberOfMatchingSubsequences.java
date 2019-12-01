package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/12/1 8:57
 * @description 792.匹配子序列的单词数
 *
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 *
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 *
 * 注意:
 * 所有在words和 S 里的单词都只由小写字母组成。
 * S 的长度在 [1, 50000]。
 * words 的长度在 [1, 5000]。
 * words[i]的长度在[1, 50]。
 */
public class NumberOfMatchingSubsequences {

    public static void main(String[] args) {
        NumberOfMatchingSubsequences n = new NumberOfMatchingSubsequences();
        System.out.println(n.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

    /**
     * 指向下一个字母的指针
     *
     * @param S
     * @param words
     * @return
     */
    private int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        // 26 个桶，存放单词节点，根据单词的指定索引存放在对应的位置
        List<Node>[] heads = new ArrayList[26];

        // 初始化 26 个桶
        for (int i = 0; i < 26; i++) {
            heads[i] = new ArrayList<>();
        }

        // 遍历每个单词，根据首字母存入对应的桶中
        for (String word : words) {
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));
        }

        for (char ch : S.toCharArray()) {
            // 取出当前字母对应的桶
            List<Node> bucket = heads[ch - 'a'];
            // 清空当前桶
            heads[ch - 'a'] = new ArrayList<>();

            // 遍历桶中的所有单词节点
            for (Node node : bucket) {
                // 单词索引往后移
                node.index++;
                if (node.index == node.word.length()) {
                    // 该单词完全遍历完
                    count++;
                } else {
                    // 根据单词新的索引更新到新的桶中
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
        }

        return count;
    }

    private class Node {
        String word;
        int index;

        Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}
