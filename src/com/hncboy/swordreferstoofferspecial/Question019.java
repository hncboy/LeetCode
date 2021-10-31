package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/10/31 11:00
 * @description 剑指 Offer II 019.最多删除一个字符得到回文
 * 
 * 给定一个非空字符串s，请判断如果最多 从字符串中删除一个字符能否得到一个回文字符串。
 *
 * 示例 1:
 * 输入: s = "aba"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 *
 * 示例 3:
 * 输入: s = "abc"
 * 输出: false
 *
 * 提示:
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 *
 * 注意：本题与主站 680题相同：https://leetcode-cn.com/problems/valid-palindrome-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/RQku0D
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question019 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        // 双指针
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValidPalindrome(s, left + 1, right) || isValidPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isValidPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
