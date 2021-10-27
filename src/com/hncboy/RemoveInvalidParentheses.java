package com.hncboy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hncboy
 * @date 2021/10/27 8:13
 * @description 301.删除无效的括号
 *
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 *
 * 示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 *
 * 示例 3：
 * 输入：s = ")("
 * 输出：[""]
 *
 * 提示：
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> currSet = new HashSet<>();

        currSet.add(s);
        while (true) {
            // 遍历当前的字符串集合，判断是不是有效的括号
            for (String str : currSet) {
                if (isValid(str)) {
                    result.add(str);
                }
            }

            if (result.size() > 0) {
                return result;
            }

            Set<String> nextSet = new HashSet<>();
            // 遍历字符串集合
            for (String str : currSet) {
                for (int i = 0; i < str.length(); i++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    // 每一轮都删除字符串中的一个括号
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }
    }

    private boolean isValid(String str) {
        char[] array = str.toCharArray();
        int count = 0;

        for (char ch : array) {
            if (ch == '(') {
                count++;
                continue;
            }

            if (ch == ')' && --count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
