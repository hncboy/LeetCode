package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/10/9 9:47
 * @description 387.字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        System.out.println(f.firstUniqChar2("leetcode"));
        System.out.println(f.firstUniqChar2("loveleetcode"));
    }

    private int firstUniqChar3(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }

    private int firstUniqChar2(String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    private int firstUniqChar1(String s) {
        int length = s.length();
        Map<Character, Integer> noRepeatMap = new LinkedHashMap<>(length);
        Map<Character, Integer> repeatMap = new LinkedHashMap<>(length);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (noRepeatMap.containsKey(ch)) {
                repeatMap.put(ch, i);
                noRepeatMap.remove(ch);
            } else {
                if (!repeatMap.containsKey(ch)) {
                    noRepeatMap.put(ch, i);
                }
            }
        }

        for (Integer value : noRepeatMap.values()) {
            return value;
        }

        return -1;
    }
}
