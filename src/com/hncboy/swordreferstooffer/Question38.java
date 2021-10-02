package com.hncboy.swordreferstooffer;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/10/2 10:14
 * @description 剑指 Offer 38.字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question38 {

    public static void main(String[] args) {
        Question38 q = new Question38();
        System.out.println(Arrays.toString(q.permutation("abc")));
        System.out.println(Arrays.toString(q.permutation("abbcb")));
    }

    public String[] permutation(String s) {
        int length = s.length();

        // 用于标记元素是否被访问过
        boolean[] visit = new boolean[length];
        char[] array = s.toCharArray();

        // 对字符数组进行排序
        Arrays.sort(array);

        // 存放所有排列组合
        List<String> result = new ArrayList<>();

        // 递归回溯
        backtrack(array, 0, length, new StringBuffer(), result, visit);

        // 将集合转为字符串数组
        return result.toArray(new String[0]);
    }

    private void backtrack(char[] array, int currentLength, int length, StringBuffer sb, List<String> result, boolean[] visit) {
        if (currentLength == length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < length; i++) {
            // 如果当前位置已经被访问 或 访问的是和上一个字符相同的字符且上一个字符未被访问
            if (visit[i] || (i > 0 && !visit[i - 1] && array[i - 1] == array[i])) {
                continue;
            }

            // 设置当前下标已经访问，增加当前下标的字符
            visit[i] = true;
            sb.append(array[i]);

            // 递归回溯
            backtrack(array, currentLength + 1, length, sb, result, visit);

            // 重置
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }
    }
}
