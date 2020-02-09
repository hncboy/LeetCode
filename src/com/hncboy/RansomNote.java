package com.hncboy;

/**
 * @author hncboy
 * @date 2020/2/9 16:19
 * @description 383.赎金信
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

    public static void main(String[] args) {
        RansomNote r = new RansomNote();
        System.out.println(r.canConstruct("a", "b"));
        System.out.println(r.canConstruct("aa", "ab"));
        System.out.println(r.canConstruct("aa", "aab"));
    }

    private boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 存放 26 个字母出现的下标
        int[] letters = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            // 从上一个该字母出现的下标位置开始查找
            int index = magazine.indexOf(ch, letters[ch - 'a']);
            if (index == -1) {
                return false;
            }
            // 更新下标
            letters[ch - 'a'] = index + 1;
        }
        return true;
    }
}
