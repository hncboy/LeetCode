package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/9/28 7:40
 * @description 22.括号生成
 */
public class GenerateParentheses {

    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis2(3));
    }

    /**
     * 闭合数
     *
     * @param n
     * @return
     */
    private List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis2(i)) {
                    for (String right : generateParenthesis2(n - 1 - i)) {
                        result.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 回溯法
     *
     * @param n
     * @return
     */
    private List<String> generateParenthesis1(int n) {
        generate("", 0, 0, n);
        return list;
    }

    private void generate(String result, int leftCount, int rightCount, int n) {
        if (leftCount > n || rightCount > n) {
            return;
        }
        if (leftCount == n && rightCount == n) {
            list.add(result);
        }

        if (leftCount >= rightCount) {
            generate(result + "(", leftCount + 1, rightCount, n);
            generate(result + ")", leftCount, rightCount + 1, n);
        }
    }
}
