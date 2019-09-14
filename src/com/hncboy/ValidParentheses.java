package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/9/14 14:27
 * @description 20.有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid2("{{}[][[[]]]}"));
    }

    private boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch: chars) {
            if (stack.size() == 0) {
                stack.push(ch);
            } else if (isMatch(stack.peek(), ch)) {
                // 匹配的话弹出括号
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size() == 0;
    }

    /**
     * 判断两个括号是否匹配
     * @param c1
     * @param c2
     * @return
     */
    private boolean isMatch(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }

    private boolean isValid1(String s) {

        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.length() == 0;
    }
}
