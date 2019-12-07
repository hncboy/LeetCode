package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/1 7:58
 * @description 6.Z字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
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
