package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/11/26 9:56
 * @description 316.去除重复字母
 *
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1:
 * 输入: "bcabc"
 * 输出: "abc"
 *
 * 示例 2:
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.println(r.removeDuplicateLetters("bcabc"));
        System.out.println(r.removeDuplicateLetters("cbacdcbc"));
    }

    private String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 出现连续一样的字母，不用进行判断
            if (stack.contains(ch)) {
                continue;
            }

            // 1.栈不为空
            // 2.当前插入的字符比栈顶部的字符小
            // 3.从 i 下标找到与栈顶部一样的字符
            // 满足这三种情况，弹出栈顶部重复的字符，不断遍历，确保重复出现的字符满足字典序
            while (!stack.isEmpty() && ch < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
