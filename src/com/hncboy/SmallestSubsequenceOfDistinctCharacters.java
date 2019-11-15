package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/11/15 14:41
 * @description 1081.不同字符的最小子序列
 *
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 *
 * 示例 1：
 * 输入："cdadabcc"
 * 输出："adbc"
 *
 * 示例 2：
 * 输入："abcd"
 * 输出："abcd"
 *
 * 示例 3：
 * 输入："ecbacba"
 * 输出："eacb"
 *
 * 示例 4：
 * 输入："leetcode"
 * 输出："letcod"
 *  
 * 提示：
 * 1 <= text.length <= 1000
 * text 由小写英文字母组成
 */
public class SmallestSubsequenceOfDistinctCharacters {

    public static void main(String[] args) {
        SmallestSubsequenceOfDistinctCharacters s = new SmallestSubsequenceOfDistinctCharacters();
        System.out.println(s.smallestSubsequence("cdadabcc"));
        System.out.println(s.smallestSubsequence("abcd"));
        System.out.println(s.smallestSubsequence("ecbacba"));
        System.out.println(s.smallestSubsequence("leetcode"));
    }

    /**
     * 贪心算法+栈
     *
     * @param text
     * @return
     */
    private String smallestSubsequence(String text) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            Character ch = text.charAt(i);
            // 存在这种情况只有连续的字符相等
            if (stack.contains(ch)) {
                continue;
            }

            // 1.栈不为空
            // 2.当前要插入的字符比 stack 中顶部的字符小
            // 3.从 text 的下标 i 开始查找是否有与 stack 顶部的字符一样的字符
            // 满足上面三个条件，弹出栈顶部的字符，不断遍历，直到有重复的字符满足字典序
            while (!stack.isEmpty() && ch < stack.peek() && text.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
