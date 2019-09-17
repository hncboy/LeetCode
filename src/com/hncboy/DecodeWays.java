package com.hncboy;

import java.util.HashMap;

/**
 * @author hncboy
 * @date 2019/9/17 8:49
 * @description 91.解码方法
 */
public class DecodeWays {

    public static void main(String[] args) {
        assert new DecodeWays().numDecodings1("226") == 3;
        assert new DecodeWays().numDecodings2("226") == 3;
        assert new DecodeWays().numDecodings3("226") == 3;
    }

    /**
     * 递归
     *
     * @param s
     * @return
     */
    private int numDecodings1(String s) {
        return getResult(s, 0);
    }

    private int getResult(String s, int start) {
        int length = s.length();
        if (start == length) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int result1 = getResult(s, start + 1); // 判断一位的数
        int result2 = 0; // 判断两位的数
        if (start < length - 1) {
            int ten = (s.charAt(start) - '0') * 10; // 十位数
            int one = s.charAt(start + 1) - '0'; // 个位数
            if (ten + one <= 26) {
                result2 = getResult(s, start + 2);
            }
        }
        return result1 + result2;
    }

    /**
     * 递归 memoization
     *
     * @param s
     * @return
     */
    private int numDecodings2(String s) {
        return getResult(s, 0, new HashMap<>());
    }

    private int getResult(String s, int start, HashMap<Integer, Integer> map) {
        int length = s.length();
        if (start == length) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        // 判断之前是否计算过
        if (map.containsKey(start)) {
            return map.get(start);
        }

        int result1 = getResult(s, start + 1, map); // 判断一位的数
        int result2 = 0; // 判断两位的数
        if (start < length - 1) {
            int ten = (s.charAt(start) - '0') * 10; // 十位数
            int one = s.charAt(start + 1) - '0'; // 个位数
            if (ten + one <= 26) {
                result2 = getResult(s, start + 2, map);
            }
        }
        // 存入 map 中
        map.put(start, result1 + result2);
        return result1 + result2;
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    private int numDecodings3(String s) {
        int length = s.length();
        int end = 1;
        int current = 0;
        if (s.charAt(length - 1) != '0') {
            current = 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                end = current;
                current = 0;
                continue;
            }
            int result1 = current;
            int result2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                result2 = end;
            }
            end = current;
            current = result1 + result2;
        }
        return current;
    }
}
