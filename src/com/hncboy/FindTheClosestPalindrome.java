package com.hncboy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2022/3/2 8:55
 * 564.寻找最近的回文数
 * 
 * 给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
 * “最近的”定义为两个整数差的绝对值最小。
 *
 * 示例 1:
 * 输入: n = "123"
 * 输出: "121"
 *
 * 示例 2:
 * 输入: n = "1"
 * 输出: "0"
 * 解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
 *
 * 提示:
 * 1 <= n.length <= 18
 * n 只由数字组成
 * n 不含前导 0
 * n 代表在 [1, 1018 - 1] 范围内的整数
 * 通过次数 6,506 提交次数 30,426
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-closest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheClosestPalindrome {

    public static void main(String[] args) {
        FindTheClosestPalindrome f = new FindTheClosestPalindrome();
        System.out.println(f.nearestPalindromic("123"));
    }

    public String nearestPalindromic(String s) {
        int n = s.length();
        boolean isEven = (n % 2) == 0;

        // 存放下边界和上边界的回文数
        Set<Long> set = new HashSet<Long>() {{
            add((long) Math.pow(10, n - 1) - 1);
            add((long) Math.pow(10, n) + 1);
        }};

        // 原始数字
        long originalNum = Long.parseLong(s);

        // 截取前一半字符串的值
        long beforeHalfNum = Long.parseLong(s.substring(0, (n + 1) / 2));
        // 遍历 beforeHalfNum-1，beforeHalfNum，beforeHalfNum+1 三种情况的值
        for (long i = beforeHalfNum - 1; i <= beforeHalfNum + 1; i++) {
            // 通过 i 计算另一半得出回文数
            long palindromeNumber = getNum(i, isEven);
            // 和原数一样的话不存放
            if (palindromeNumber != originalNum) {
                set.add(palindromeNumber);
            }
        }

        long result = -1;
        // 遍历所有回文数取绝对值最小的数
        for (long num : set) {
            if (result == -1) {
                result = num;
            } else if (Math.abs(num - originalNum) < Math.abs(result - originalNum)) {
                // 取绝对值最小的
                result = num;
            } else if (Math.abs(num - originalNum) == Math.abs(result - originalNum) && num < result) {
                // 绝对值一样的情况下取数字最小的
                result = num;
            }
        }
        return String.valueOf(result);
    }

    /**
     * 补充另一半的数字得出回文数
     *
     * @param beforeHalfNum 前一半数字
     * @param isEven        总长度是否是偶数
     * @return 回文数
     */
    private long getNum(long beforeHalfNum, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(beforeHalfNum);
        int idx = isEven ? sb.length() - 1 : sb.length() - 2;
        while (idx >= 0) {
            sb.append(sb.charAt(idx--));
        }
        return Long.parseLong(sb.toString());
    }
}
