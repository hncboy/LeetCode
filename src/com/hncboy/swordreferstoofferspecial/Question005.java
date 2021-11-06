package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/6 13:50
 * @description 剑指 Offer II 005.单词长度的最大乘积
 * 
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
 * 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 * 示例 1:
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16 
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 *
 * 示例 2:
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4 
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 示例 3:
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0 
 * 解释: 不存在这样的两个单词。
 *
 * 提示：
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *  
 * 注意：本题与主站 318 题 {@link com.hncboy.MaximumProductOfWordLengths}
 * 相同：https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/aseY1I
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question005 {

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
