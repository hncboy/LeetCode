package com.hncboy;

/**
 * @author hncboy
 * @date 2021/10/19 8:01
 * @description 211.添加与搜索单词-数据结构设计
 * 
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *  
 *
 * 示例：
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *  
 *
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DesignAddAndSearchWordsDataStructure {

    private static class WordDictionary {

        private final Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node node = root;
            // 遍历单词，存入 Node 链表
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new Node();
                }
                node = node.next[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return search(word, root, 0);
        }

        private boolean search(String word, Node node, int i) {
            // 不匹配当前字母
            if (node == null) {
                return false;
            }

            // 找到这个单词
            if (i >= word.length()) {
                return node.isEnd;
            }

            char ch = word.charAt(i);
            if (ch == '.') {
                // '.' 号的话遍历所有下一个字母进行匹配，只要有一个匹配成功就行
                for (Node next : node.next) {
                    if (search(word, next, i + 1)) {
                        return true;
                    }
                }
                return false;
            }
            return search(word, node.next[ch - 'a'], i + 1);
        }

        private static class Node {
            Node[] next = new Node[26];
            boolean isEnd = false;
        }
    }
}
