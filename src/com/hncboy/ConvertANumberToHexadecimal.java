package com.hncboy;

/**
 * @author hncboy
 * @date 2021/10/2 9:45
 * @description 405.数字转换为十六进制数
 * 
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 
 * 示例 1：
 * 输入:
 * 26
 *
 * 输出:
 * "1a"
 * 
 * 示例 2：
 * 输入:
 * -1
 * 输出:
 * "ffffffff"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertANumberToHexadecimal {

    public static void main(String[] args) {
        ConvertANumberToHexadecimal c = new ConvertANumberToHexadecimal();
        System.out.println(c.toHex(26));
        System.out.println(c.toHex(-1));
    }

    private String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        // 转为正数后的数字
        long positiveNum = num;
        // 如果是负数，需要加上 2^32 的偏移量转为正数
        if(num < 0) {
            positiveNum = (long)(Math.pow(2, 32) + num);
        }

        StringBuilder sb = new StringBuilder();
        while (positiveNum != 0) {
            // 计算除以 16 的余数
            long remainder = positiveNum % 16;
            if (remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char)(remainder - 10 + 'a'));
            }
            positiveNum /= 16;
        }

        // 结果取反
        return sb.reverse().toString();
    }
}
