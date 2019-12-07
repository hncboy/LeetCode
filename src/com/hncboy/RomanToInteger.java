package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/9/4 15:20
 * @description 13.罗马数字转整数
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * 这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 *
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 *
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 *
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
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
