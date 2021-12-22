package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/28 9:11
 * @description 28.实现 strStr()
 *
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 *
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * 通过次数 521,029 提交次数 1,292,521
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ImplementStrstr {

    public static void main(String[] args) {
        System.out.println(new ImplementStrstr().strStr("hello", "lo"));
        System.out.println(new ImplementStrstr().strStr("aa", "a"));
    }

    /**
     * KMP
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        // 原串的长度
        int n = haystack.length();
        // 匹配串的长度
        int m = needle.length();

        // 原串和匹配串前面都加空格，使其下标从 1 开始
        haystack = " " + haystack;
        needle = " " + needle;

        // 原串的字符数组
        char[] originalArray = haystack.toCharArray();
        // 匹配串的字符数组
        char[] matchArray = needle.toCharArray();

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
