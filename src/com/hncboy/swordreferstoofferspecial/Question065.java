package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/12/27 9:18
 * 剑指 Offer II 065.最短的单词编码
 * 
 * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 *
 * 示例 1：
 * 输入：words = ["time", "me", "bell"]
 * 输出：10
 * 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
 * words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 *
 * 示例 2：
 * 输入：words = ["t"]
 * 输出：2
 * 解释：一组有效编码为 s = "t#" 和 indices = [0] 。
 *
 * 提示：
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * words[i] 仅由小写字母组成
 *
 * 注意：本题与主站 820 题 {@link com.hncboy.ShortEncodingOfWords} 相同： https://leetcode-cn.com/problems/short-encoding-of-words/
 * 通过次数 2,260 提交次数 3,495
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/iSwD2y
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question065 {

    public int minimumLengthEncoding(String[] words) {
        int count = 0;
        TrieTree tree = new TrieTree();
        for (String word : words) {
            count += tree.insertNode(word);
        }
        return count;
    }

    private static class TrieNode {

        TrieNode[] children = new TrieNode[26];

        boolean hasChildren = false;
    }

    private static class TrieTree {

        private final TrieNode root = new TrieNode();

        public int insertNode(String word) {
            // 共同后缀的长度
            int prevLen = 0;
            TrieNode curr = root;

            // 从后缀开始遍历
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                // 如果不存在相同的后缀字符
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                    // 如果已经存在其他的子节点，则此时共同后缀唯一
                    if (curr.hasChildren) {
                        prevLen = 0;
                    } else {
                        curr.hasChildren = true;
                    }
                } else {
                    prevLen++;
                }
                curr = curr.children[index];
            }

            // 没有共同后缀长度
            if (prevLen == 0) {
                prevLen = -1;
            }
            return word.length() - prevLen;
        }
    }
}