package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/9/14 13:23
 * @description 17.电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {

    private List<String> output = new ArrayList<>();
    private String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }

    private List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    private void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            // 截取第一个数字
            int digit = Integer.parseInt(nextDigits.substring(0, 1));
            // 获取该数字对应的字符
            String letters = phone[digit];
            int lettersLength = letters.length();
            for (int i = 0; i < lettersLength; i++) {
                // 获取对应的字符
                String letter = phone[digit].substring(i, i + 1);
                // 传递当前已拼接的字符和下一个数字
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }
}
