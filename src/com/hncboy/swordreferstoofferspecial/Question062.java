package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/12/19 16:10
 * @description 剑指 Offer II 062.实现前缀树
 * 
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入
 * inputs = ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * inputs = [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 * 提示：
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 *
 * 注意：本题与主站 208 题 {@link com.hncboy.ImplementTriePrefixTree} 相同：https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 通过次数 3,435 提交次数 4,459
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/QC3q1f
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question062 {

    private static class Trie {

        private final TrieNode trieNode;

        public Trie() {
            trieNode = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currNode = trieNode;
            // 遍历单词的所有字母
            for (char letter : word.toCharArray()) {
                int index = letter - 'a';
                if (currNode.children[index] == null) {
                    currNode.children[index] = new TrieNode();
                }
                currNode = currNode.children[index];
            }
            currNode.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode currNode = trieNode;
            // 遍历所有字母
            for (char letter: word.toCharArray()) {
                if (currNode.children[letter - 'a'] == null) {
                    return false;
                }
                currNode = currNode.children[letter - 'a'];
            }

            return currNode.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode currNode = trieNode;
            // 遍历前缀的所有字母
            for (char letter : prefix.toCharArray()) {
                // 如果字母不构成前缀树，则返回 false
                if (currNode.children[letter - 'a'] == null) {
                    return false;
                }
                currNode = currNode.children[letter - 'a'];
            }
            return true;
        }

        private static class TrieNode {
            boolean isEnd;
            TrieNode[] children = new TrieNode[26];
        }
    }
}
