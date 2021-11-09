package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/9 11:33
 * @description 剑指 Offer II 018.有效的回文
 * 
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，将空字符串定义为有效的 回文串 。
 *
 * 示例 1:
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 示例 2:
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *  
 * 提示：
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 * 注意：本题与主站 125 题 {@link com.hncboy.ValidPalindrome}
 * 相同： https://leetcode-cn.com/problems/valid-palindrome/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/XltzEq
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question018 {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
        }
        return true;
    }
}
