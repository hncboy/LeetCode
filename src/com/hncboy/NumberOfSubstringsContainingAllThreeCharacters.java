package com.hncboy;

/**
 * @author hncboy
 * @date 2020/2/22 22:29
 * @description 5325.包含所有三种字符的子字符串数目
 *
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 *
 * 示例 1：
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 *
 * 示例 2：
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 *
 * 示例 3：
 * 输入：s = "abc"
 * 输出：1
 *
 * 提示：
 * 3 <= s.length <= 5 x 10^4
 * s 只包含字符 a，b 和 c 。
 */
public class NumberOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {
        NumberOfSubstringsContainingAllThreeCharacters n = new NumberOfSubstringsContainingAllThreeCharacters();
        System.out.println(n.numberOfSubstrings("abcabc"));
        System.out.println(n.numberOfSubstrings("aaacb"));
        System.out.println(n.numberOfSubstrings("abc"));
        System.out.println(n.numberOfSubstrings("ababbbc"));
    }

    private int numberOfSubstrings(String s) {
        int[] map = new int[3];
        int result = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            map[s.charAt(right) - 'a']++;
            while (map[0] != 0 && map[1] != 0 && map[2] != 0) {
                result += s.length() - right;
                map[s.charAt(left++) - 'a']--;
            }
        }
        return result;
    }
}
