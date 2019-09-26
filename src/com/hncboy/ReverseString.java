package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/26 8:23
 * @description 344.反转字符串
 *
 * 写一个函数，其作用是将输入的字符串反转过来。
 * 输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] s2 = new char[]{'H','a','n','n','a','h'};
        new ReverseString().reverseString(s2);
    }

    private void reverseString(char[] s) {
        int length = s.length;
        char t;
        for (int i = 0; i < length / 2; i++) {
            t = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = t;
        }
    }
}
