package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/1/12 9:25
 * 剑指 Offer II 085.生成匹配的括号
 * 
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 * 1 <= n <= 8
 *
 * 注意：本题与主站 22 题 {@link com.hncboy.GenerateParentheses} 相同： https://leetcode-cn.com/problems/generate-parentheses/
 * 通过次数 6,290 提交次数 7,406
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/IDBivT
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question085 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, 0, 0, n, new StringBuffer());
        return result;
    }

    private void dfs(List<String> result, int left, int right, int n, StringBuffer sb) {
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            dfs(result, left + 1, right, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < n && left > right) {
            sb.append(')');
            dfs(result, left, right + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
