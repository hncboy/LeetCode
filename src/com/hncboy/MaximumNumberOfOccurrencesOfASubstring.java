package com.hncboy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hncboy
 * @date 2019/12/23 1:18
 * @description 5293.子串的最大出现次数
 *
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 *
 * 示例 1：
 * 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * 输出：2
 * 解释：子串 "aab" 在原字符串中出现了 2 次。
 * 它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
 *
 * 示例 2：
 * 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * 输出：2
 * 解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
 *
 * 示例 3：
 * 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * 输出：3
 *
 * 示例 4：
 * 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * 输出：0
 *
 * 提示：
 * 1 <= s.length <= 10^5
 * 1 <= maxLetters <= 26
 * 1 <= minSize <= maxSize <= min(26, s.length)
 * s 只包含小写英文字母。
 */
public class MaximumNumberOfOccurrencesOfASubstring {

    public static void main(String[] args) {
        MaximumNumberOfOccurrencesOfASubstring m = new MaximumNumberOfOccurrencesOfASubstring();
        System.out.println(m.maxFreq("aababcaab", 2, 3, 4));
        System.out.println(m.maxFreq("aaaa", 1, 3, 3));
        System.out.println(m.maxFreq("aabcabcab", 2, 2, 3));
        System.out.println(m.maxFreq("abcde", 2, 3, 3));
    }

    private int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int result = 0;
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (i + minSize > s.length()) {
                break;
            }

            String sub = s.substring(i, i + minSize);
            if (isMatch(sub, maxLetters)) {
                // 将符合长度的子串加入 map
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
                result = Math.max(result, countMap.get(sub));
            }
        }

        return result;
    }

    /**
     * 判断 sub 中字符数量是否小于 maxLetters
     *
     * @param sub
     * @param maxLetters
     * @return
     */
    private boolean isMatch(String sub, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char ch : sub.toCharArray()) {
            set.add(ch);
            if (set.size() > maxLetters) {
                return false;
            }
        }
        return set.size() <= maxLetters;
    }
}
