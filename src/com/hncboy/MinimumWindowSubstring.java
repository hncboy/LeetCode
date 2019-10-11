package com.hncboy;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/10/11 16:09
 * @description 76.最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    private String minWindow(String s, String t) {
        int left = 0;
        int right = 0;

        // 存放需要覆盖的字符
        Map<Character, Integer> needMap = new HashMap<>();
        // 统计每个字符出现的次数
        for (Character c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        // 存放在窗口实际出现的字符
        Map<Character, Integer> windowMap = new HashMap<>();
        // 记录符合的要求的开始位置和结束位置
        int startResult = 0;
        int endResult = Integer.MAX_VALUE;
        // 计算 needMap 中有几种字符已经被覆盖了
        int match = 0;

        // 用于存放原始字符串 s 中与需要覆盖的 t 中匹配的字符及其所在下标，减少滑动次数
        List<Pair<Integer, Character>> filter = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (needMap.containsKey(s.charAt(i))) {
                filter.add(new Pair<>(i, s.charAt(i)));
            }
        }

        while (right < filter.size()) {
            char ch = filter.get(right).getValue();
            // 如果当前字符是需要的
            if (needMap.containsKey(ch)) {
                // 将该字符加入 windowMap 用于统计
                windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
                // 判断该字符出现的此处是否和需要覆盖的次数一样
                if (windowMap.get(ch).equals(needMap.get(ch))) {
                    // 当前种类字符已达到要求
                    match++;
                }
            }

            // 当所有种类的字符都达到匹配要求了
            while (match == needMap.size()) {
                // 更新最小的子串
                int start = filter.get(left).getKey();
                int end = filter.get(right).getKey();
                if ((end - start) < (endResult - startResult)) {
                    startResult = start;
                    endResult = end;
                }

                // 获取左指针
                char c = filter.get(left).getValue();
                // 当该字符是需要被覆盖的
                if (needMap.containsKey(c)) {
                    // 窗口中该字符数量 -1
                    windowMap.put(c, windowMap.get(c) - 1);
                    // 如果窗口中该字符数量小于需要的字符数量，则该种类字符就不匹配了
                    if (windowMap.get(c) < needMap.get(c)) {
                        match--;
                    }
                }
                // 移动左指针
                left++;
            }

            // 移动右指针
            right++;
        }
        return endResult == Integer.MAX_VALUE ? "" : s.substring(startResult, endResult + 1);
    }
}
