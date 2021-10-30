package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/18 8:26
 * @description 242.有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
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
        System.out.println(v.isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }

        int[] hash = new int [26];
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (--hash[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
