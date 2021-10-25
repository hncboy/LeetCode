package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/10/25 8:54
 * @description 剑指 Offer II 002.二进制加法
 * 
 * 给定两个 01 字符串  a  和  b  ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字  1  和  0。
 *
 * 示例  1:
 * 输入: a = "11", b = "10"
 * 输出: "101"
 *
 * 示例  2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *   
 * 注意：本题与主站 67 题 {@link com.hncboy.AddBinary}
 * 相同：https://leetcode-cn.com/problems/add-binary/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/JFETK5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question002 {

    public String addBinary(String a, String b) {
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
