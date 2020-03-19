package com.hncboy;

/**
 * @author hncboy
 * @date 2020/3/19 19:48
 * @description 409.最长回文串
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 */
public class LongestPalindrome {

    private int longestPalindrome(String s) {
        // 统计 Aa-Zz 出现的字符个数
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            count[c - 'A'] += 1;
        }

        int result = 0;
        for (int x : count) {
            // 偶数的二进制末尾为 0，奇数的二进制末尾为 1
            // 当 x 为奇数时，x&1=1，减去 1 次，因为单独的一个数构不成会问
            result += x - (x & 1);
        }

        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，
        // 那么那个字符可以放在回文串的中间，所以额外再加一。
        return result < s.length() ? result + 1 : result;
    }
}
