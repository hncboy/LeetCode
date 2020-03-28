package com.hncboy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2020/3/28 22:26
 * @description 820.单词的压缩编码
 *
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 示例：
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 * 提示：
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 */
public class ShortEncodingOfWords {

    private int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        // 遍历所有单词
        for (String word : words) {
            // 遍历每个单词的长度
            for (int i = 1; i < word.length(); i++) {
                // 删除同样后缀的单词
                set.remove(word.substring(i));
            }
        }

        int result = 0;
        for (String word : set) {
            result += word.length() + 1;
        }
        return result;
    }
}
