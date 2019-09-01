package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/1 7:58
 * @description TODO
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    private static String convert(String s, int numRows) {
        if (s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int size = 2 * numRows - 2; // 每两完整列之间的距离
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < length; j += size) {
                sb.append(s.charAt(j));
                int index = (j - i) + (size - i); // 斜着字符的下标
                // 第一行和最后一行没有斜着的字符
                if (i != 0 && i != numRows - 1 && index < length) {
                    sb.append(s.charAt(index));
                }
            }
        }
        return sb.toString();
    }
}
