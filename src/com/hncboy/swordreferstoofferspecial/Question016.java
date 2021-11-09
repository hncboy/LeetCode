package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/9 11:40
 * @description 剑指 Offer II 016.不含重复字符的最长子字符串
 * 
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *  
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 注意：本题与主站 3 题 {@link com.hncboy.LongestSubstringWithoutRepeatingCharacters}
 * 相同： https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wtcaE1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question016 {

    public static int lengthOfLongestSubstring(String s) {
        // 存放字符上次出现的位置，s 由英文字母、数字、符号和空格组成
        int[] last = new int[128];

        int result = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            // 取出当前字符对应的整数值
            int index = s.charAt(right);
            // 如果出现相同的字符，则取最大的左边界
            left = Math.max(left, last[index]);
            // 重新计算区间内不重复的最大子串长度
            result = Math.max(result, right - left + 1);
            // 更新当前字符对应最大下标
            last[index] = right + 1;
        }

        return result;
    }
}
