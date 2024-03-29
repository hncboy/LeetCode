package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/9/28 7:40
 * 22.括号生成
 * 
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
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
 * 通过次数 403,621 提交次数 522,136
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(3));
    }

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
