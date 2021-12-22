package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/22 8:48
 * 686.重复叠加字符串匹配
 * 
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 * 示例 1：
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 *
 * 示例 2：
 * 输入：a = "a", b = "aa"
 * 输出：2
 *
 * 示例 3：
 * 输入：a = "a", b = "a"
 * 输出：1
 *
 * 示例 4：
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *
 * 提示：
 * 1 <= a.length <= 104
 * 1 <= b.length <= 104
 * a 和 b 由小写英文字母组成
 * 通过次数 20,063 提交次数 54,597
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedStringMatch {

    public static void main(String[] args) {
        RepeatedStringMatch r = new RepeatedStringMatch();
        System.out.println(r.repeatedStringMatch("abcd", "cdabcdab"));
    }

    public int repeatedStringMatch(String a, String b) {
        int result = 0;
        // 统计字符串 a 的长度要大于字符串 b 需要重复的初始次数
        StringBuilder sb = new StringBuilder();
        while (sb.length() < b.length()) {
            result++;
            sb.append(a);
        }
        sb.append(a);
        // 判断是否有匹配的字符串
        int index = strStr(sb.toString(), b);
        if (index == -1) {
            return -1;
        }
        return index + b.length() > a.length() * result ? result + 1 : result;
    }

    /**
     * 获取匹配串在原串中出现的第一个位置
     *
     * @param originalStr 原串
     * @param matchStr    匹配串
     */
    private int strStr(String originalStr, String matchStr) {
        if (matchStr.isEmpty()) {
            return 0;
        }

        // 原串的长度
        int n = originalStr.length();
        // 匹配串的长度
        int m = matchStr.length();

        // 原串和匹配串前面都加空格，使其下标从 1 开始
        originalStr = " " + originalStr;
        matchStr = " " + matchStr;

        // 原串的字符数组
        char[] originalArray = originalStr.toCharArray();
        // 匹配串的字符数组
        char[] matchArray = matchStr.toCharArray();

        // 初始化 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];

        // 构造 next 数组
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j 指向前一位置 next 数组对应的值
            while (j > 0 && matchArray[i] != matchArray[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，说明匹配到了相同的前缀和后缀，到时候可以直接跳到该位置，指针 j 往右移
            if (matchArray[i] == matchArray[j + 1]) {
                j++;
            }
            // 更新 next[i]，结束本次循环，指针 i 往右移
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功，将指针 j 跳转到前缀的下一个位置进行匹配
            while (j > 0 && originalArray[i] != matchArray[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (originalArray[i] == matchArray[j + 1]) {
                j++;
            }
            // 整一段匹配成功，直接返回起始下标
            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }
}
