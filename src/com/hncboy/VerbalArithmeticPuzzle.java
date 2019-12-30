package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/29 10:29
 * @description 1307.口算难题
 * 
 * 给你一个方程，左边用words表示，右边用result 表示。
 * 你需要根据以下规则检查方程是否可解：
 * 每个字符都会被解码成一位数字（0 - 9）。
 * 每对不同的字符必须映射到不同的数字。
 * 每个 words[i] 和 result都会被解码成一个没有前导零的数字。
 * 左侧数字之和（words）等于右侧数字（result）。
 * 如果方程可解，返回True，否则返回False。
 *
 * 示例 1：
 * 输入：words = ["SEND","MORE"], result = "MONEY"
 * 输出：true
 * 解释：映射 'S'-> 9, 'E'->5, 'N'->6, 'D'->7, 'M'->1, 'O'->0, 'R'->8, 'Y'->'2'
 * 所以 "SEND" + "MORE" = "MONEY" ,  9567 + 1085 = 10652
 * 
 * 示例 2：
 * 输入：words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"
 * 输出：true
 * 解释：映射 'S'-> 6, 'I'->5, 'X'->0, 'E'->8, 'V'->7, 'N'->2, 'T'->1, 'W'->'3', 'Y'->4
 * 所以 "SIX" + "SEVEN" + "SEVEN" = "TWENTY" ,  650 + 68782 + 68782 = 138214
 * 
 * 示例 3：
 * 输入：words = ["THIS","IS","TOO"], result = "FUNNY"
 * 输出：true
 * 
 * 示例 4：
 * 输入：words = ["LEET","CODE"], result = "POINT"
 * 输出：false
 *
 * 提示：
 * 2 <= words.length <= 5
 * 1 <= words[i].length,results.length<= 7
 * words[i], result只含有大写英文字母
 * 表达式中使用的不同字符数最大为10
 */
public class VerbalArithmeticPuzzle {

    public static void main(String[] args) {
        VerbalArithmeticPuzzle v = new VerbalArithmeticPuzzle();
        System.out.println(v.isSolvable(new String[]{"SEND", "MORE"}, "MONEY"));
        System.out.println(v.isSolvable(new String[]{"SIX", "SEVEN", "SEVEN"}, "TWENTY"));
        System.out.println(v.isSolvable(new String[]{"THIS", "IS", "TOO"}, "FUNNY"));
        System.out.println(v.isSolvable(new String[]{"LEET", "CODE"}, "POINT"));
    }

    /**
     * 存放所有字符的 map
     */
    private Map<Character, Integer> charMap = new HashMap<>();
    /**
     * 存放不为0的字符，即 word 和 result 的首字符
     */
    private int[] notZero = new int[26];
    /**
     * 判断是否访问该数字
     */
    private boolean[] visited = new boolean[10];
    /**
     * 存放左边所有字符的权值
     */
    private int[] left = new int[10];
    /**
     * 存放右边所有字符的权值
     */
    private int[] right = new int[10];

    public boolean isSolvable(String[] words, String result) {
        // 遍历 word 和 result 的所有字符放入 map
        // key 为字符，value 该字符从左到右出现的顺序，已存入的字符取第一次的顺序，范围为[0,9]
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                charMap.put(ch, charMap.getOrDefault(ch, charMap.size()));
            }
        }
        for (char ch : result.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, charMap.size()));
        }

        // 将 word 中的首字符的顺序放入 notZero 数组，并计算 word 各个字符的权重
        for (String word : words) {
            notZero[charMap.get(word.charAt(0))] = -1;
            setWight(word, left);
        }
        // 将 result 中的首字符的顺序放入 notZero 数组，并计算 result 各个字符的权重
        notZero[charMap.get(result.charAt(0))] = -1;
        setWight(result, right);

        return dfs(0, charMap.size(), 0, 0);
    }

    private boolean dfs(int start, int length, int l, int r) {
        if (start == length) {
            return l == r;
        }

        for (int i = 0; i <= 9; i++) {
            // 当前字符已经访问过或者首字符为 0 的话继续循环
            if (visited[i] || (i == 0 && notZero[start] == -1)) {
                continue;
            }

            visited[i] = true;
            // l + i * left[start] 和 r + i * right[start] 更新左右两边的权值
            // 当左边的权值等于右边的权值时，即两边的值相等，通过权值计算两边的值
            if (dfs(start + 1, length, l + i * left[start], r + i * right[start])) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    /**
     * 计算权重
     *
     * @param s
     * @param weight
     */
    private void setWight(String s, int[] weight) {
        int value = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            weight[charMap.get(s.charAt(i))] += value;
            value *= 10;
        }
    }
}
