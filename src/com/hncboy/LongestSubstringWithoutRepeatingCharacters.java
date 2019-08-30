package com.hncboy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User: hncboy
 * DateTime: 2019/8/30 14:36
 * Description:
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
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
