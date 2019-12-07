package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/7 9:19
 * @description 67.二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("11", "1"));
        System.out.println(a.addBinary("1010", "1011"));
    }

    private String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            result.append(sum % 2);
            // 计算进位
            sum /= 2;
        }
        // 进位是1的话补1
        result.append(sum == 1 ? sum : "");
        return result.reverse().toString();
    }
}
