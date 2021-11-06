package com.hncboy;

/**
 * @author hncboy
 * @date 2021/11/6 13:57
 * @description 318.最大单词长度乘积
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例 1:
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 *
 * 示例 2:
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 示例 3:
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * 提示：
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumProductOfWordLengths {

    public static void main(String[] args) {
        MaximumProductOfWordLengths m = new MaximumProductOfWordLengths();
        System.out.println(m.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}) == 16);
        System.out.println(m.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}) == 4);
        System.out.println(m.maxProduct(new String[]{"a","aa","aaa","aaaa"}) == 0);
    }

    public int maxProduct(String[] words) {
        int length = words.length;
        // 用 int 的 32 位 bit 来存放每个单词的 26 位字母
        int[] bitWords = new int[length];
        // 遍历所有的单词
        for (int i = 0; i < length; i++) {
            // 遍历这个单词的所有字母，将这个单词的字母都赋值到对应 int 的各个 bit 位上
            for (char ch : words[i].toCharArray()) {
                bitWords[i] |= (1 << (ch - 97));
            }
        }

        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                // 如果两个单词的整数 bit 位进行按位与运算，如果有相当的字母，肯定不为 0
                if ((bitWords[i] & bitWords[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }

            }
        }
        return result;
    }
}
