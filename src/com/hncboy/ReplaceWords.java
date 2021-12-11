package com.hncboy;

import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/12/11 16:20
 * @description 648.单词替换
 * 
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 *
 * 示例 1：
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * 示例 2：
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 *
 * 示例 3：
 * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * 输出："a a a a a a a a bbb baba a"
 *
 * 示例 4：
 * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * 示例 5：
 * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
 * 输出："it is ab that this solution is ac"
 *
 * 提示：
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 * 通过次数 22,965 提交次数 39,013
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReplaceWords {

    public static void main(String[] args) {
        ReplaceWords r = new ReplaceWords();
        System.out.println(r.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        // 构建字典树
        TrieNode trie = buildTrieTree(dictionary);

        StringBuilder result = new StringBuilder();
        // 遍历所有单词
        for (String word: sentence.split("\\s+")) {
            if (result.length() > 0) {
                result.append(" ");
            }

            TrieNode curr = trie;
            // 遍历所有字母
            for (char letter: word.toCharArray()) {
                // 如果字母构不成前缀树或者已经构成了一个前缀树
                if (curr.children[letter - 'a'] == null || curr.word != null) {
                    break;
                }
                curr = curr.children[letter - 'a'];
            }

            result.append(curr.word != null ? curr.word : word);
        }
        return result.toString();
    }

    /**
     * 构建字典树
     *
     * @param dictionary 词根
     * @return 字典树
     */
    private TrieNode buildTrieTree(List<String> dictionary) {
        TrieNode trie = new TrieNode();

        // 遍历所有词根
        for (String root : dictionary) {
            TrieNode curr = trie;
            // 遍历词根的所有字母
            for (char letter : root.toCharArray()) {
                if (curr.children[letter - 'a'] == null) {
                    curr.children[letter - 'a'] = new TrieNode();
                }
                curr = curr.children[letter - 'a'];
            }
            // 最后一个节点存放词根
            curr.word = root;
        }

        return trie;
    }

    private static class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }
}
