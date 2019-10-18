package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/10/18 8:26
 * @description 242.有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram2("anagram", "nagaram"));
        System.out.println(v.isAnagram2("rat", "car"));
        System.out.println(v.isAnagram2("aa", "bb"));
    }

    /**
     * 排序
     *
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagram1(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();

        if (length1 != length2) {
            return false;
        }

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    /**
     * 哈希
     *
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagram2(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (length1 != length2) {
            return false;
        }

        int[] word = new int[26];
        for (int i = 0; i < length1; i++) {
            word[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < length2; i++) {
            if (--word[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
