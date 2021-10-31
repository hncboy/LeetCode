package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/10/31 10:29
 * @description 500.键盘行
 * 
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 *
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 *
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *
 * 提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KeyboardRow {

    private static final int[] CHARS = new int[26];

    static {
        // 26 个字母分成三行
        set("qwertyuiop", 1);
        set("asdfghjkl", 2);
        set("zxcvbnm", 3);
    }

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        // 遍历每个单词
        for (String word : words) {
            // 检查单词是否在同一行
            if (check(word)) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

    /**
     * 将每行的字母和位置存入数组
     */
    private static void set(String s, int row) {
        for (int i = 0; i < s.length(); i++) {
            CHARS[index(s.charAt(i))] = row;
        }
    }

    /**
     * 获取字母对应的下标，也就是超出 A 或 a 的大小
     */
    private static int index(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        }
        return ch - 'a';
    }

    private static boolean check(String s) {
        if (s.isEmpty()) {
            return true;
        }
        // 取出第一个单词对行的行数
        int row = CHARS[index(s.charAt(0))];
        for (char ch : s.toCharArray()) {
            // 如果单词不是同一行，则返回失败
            if (CHARS[index(ch)] != row) {
                return false;
            }
        }
        return true;
    }
}
