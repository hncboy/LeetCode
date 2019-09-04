package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/9/4 15:20
 * @description Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * Input: "III"
 * Output: 3
 * <p>
 * Example 2:
 * Input: "IV"
 * Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * <p>
 * Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * <p>
 * Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

    private static Map<String, Integer> romanOneMap;
    private static Map<String, Integer> romanTwoMap;

    public static void main(String[] args) {
//        System.out.println(romanToInt1("D"));
        System.out.println(romanToInt("D"));
    }

    private static int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if (i + 1 < length && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        result--;
                    } else {
                        result++;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (i + 1 < length && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i + 1 < length && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    private static int romanToInt1(String s) {
        initRomanMap();

        int length = s.length();
        if (length == 1) {
            return romanOneMap.get(s.substring(0, 1));
        }

        int result = 0;
        int startIndex = 0;
        int endIndex = 2;
        while (endIndex <= length) {
            String key = s.substring(startIndex, endIndex);
            // 首先判断是否符合两个字符
            if (romanTwoMap.containsKey(key)) {
                result += romanTwoMap.get(key);
                // 都往后移两位
                startIndex += 2;
            } else {
                // 不满足两个字符，则取第一个字符判断
                result += romanOneMap.get(key.substring(0, 1));
                startIndex += 1;
            }
            endIndex = startIndex + 2;

            // 如果还剩最后一位字符
            if (s.substring(startIndex).length() == 1) {
                result += romanOneMap.get(s.substring(startIndex));
            }
        }

        return result;
    }

    private static void initRomanMap() {
        romanTwoMap = new HashMap<>();
        romanTwoMap.put("IV", 4);
        romanTwoMap.put("IX", 9);
        romanTwoMap.put("XL", 40);
        romanTwoMap.put("XC", 90);
        romanTwoMap.put("CD", 400);
        romanTwoMap.put("CM", 900);
        romanOneMap = new HashMap<>();
        romanOneMap.put("I", 1);
        romanOneMap.put("V", 5);
        romanOneMap.put("X", 10);
        romanOneMap.put("L", 50);
        romanOneMap.put("C", 100);
        romanOneMap.put("D", 500);
        romanOneMap.put("M", 1000);
    }
}
