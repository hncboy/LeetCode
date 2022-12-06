package com.hncboy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2022/12/6 12:28
 * 1805.字符串中不同整数的数目
 * <p>
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123 34 8 34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * <p>
 * 示例 1：
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * <p>
 * 示例 2：
 * 输入：word = "leet1234code234"
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * <p>
 * 提示：
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 * 通过次数24,371提交次数55,368
 */
public class NumberOfDifferentIntegersInAString {

    public static void main(String[] args) {
        NumberOfDifferentIntegersInAString n = new NumberOfDifferentIntegersInAString();
        System.out.println(n.numDifferentIntegers("a123bc34d8ef34") == 3);
        System.out.println(n.numDifferentIntegers("leet1234code234") == 2);
        System.out.println(n.numDifferentIntegers("a1b01c001") == 1);
    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int n = word.length();
        int left = 0;
        int right;
        while (true) {
            // 如果不是数字则往右移动
            while (left < n && !Character.isDigit(word.charAt(left))) {
                left++;
            }
            // 移动到末尾
            if (left == n) {
                break;
            }
            // 找到不为数字的字符
            right = left;
            while (right < n && Character.isDigit(word.charAt(right))) {
                right++;
            }
            // 如果长度大于 1 则移除前置 0
            while (right - left > 1 && word.charAt(left) == '0') {
                left++;
            }
            set.add(word.substring(left, right));
            left = right;
        }
        return set.size();
    }
}
