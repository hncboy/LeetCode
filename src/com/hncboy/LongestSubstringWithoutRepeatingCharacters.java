package com.hncboy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/8/30 14:36
 * @description 3.无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] seen = new int[256]; // 最多 256 个不重复字符
        Arrays.fill(seen, -1); // 每个字符赋值为 -1，表示未出现过

        int currentStart = 0; // 当前子串的起始位置
        int current = 0;    // 当前统计的字串长度
        int max = 0;        // 最大的字串长度

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当前字符如果未出现过或出现在当前子串的起始位置之前
            if (seen[c] == -1 || seen[c] < currentStart) {
                current++;
                max = Math.max(current, max); // 取最大子串的长度
            } else {
                // 当前字符出现过的话
                current = i - seen[c]; // 当前子串的长度重新计算
                currentStart = seen[c] + 1; // 当前子串的计算起始位置从最近出现过的位置 + 1 后开始计算
            }
            seen[c] = i; // 当前字符最近出现过的位置
        }
        return max;
    }
}
