package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/11/13 14:09
 * @description 438.找到字符串中所有字母异位词
 * 
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *  
 * 提示:
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        FindAllAnagramsInAString f = new FindAllAnagramsInAString();
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));
        System.out.println(f.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] array1 = p.toCharArray();
        char[] array2 = s.toCharArray();

        // 遍历 s1 中的字符，统计每个字母的个数
        int[] needs = new int[26];
        for (char ch : array1) {
            needs[ch - 'a']++;
        }

        for (int left = 0, right = 0; right < array2.length; right++) {
            // 滑动右指针
            needs[array2[right] - 'a']--;
            // 如果需要的字母小于 0，说明此时到这个字母的字符串都不符合要求
            while (needs[array2[right] - 'a'] < 0) {
                // 将做左指针不断往右移动，补充右指针留下的坑
                needs[array2[left++] - 'a']++;
            }
            // 满足条件
            if (right - left + 1 == array1.length) {
                result.add(left);
            }
        }
        return result;
    }
}
