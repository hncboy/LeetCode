package com.hncboy;

/**
 * @author hncboy
 * @date 2022/3/7 8:17
 * 504.七进制数
 * 
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 *
 * 示例 2:
 * 输入: num = -7
 * 输出: "-10"
 *
 * 提示：
 * -107 <= num <= 107
 * 通过次数38,659提交次数76,067
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Base7 {

    public static void main(String[] args) {
        Base7 b = new Base7();
        System.out.println(b.convertToBase7(100));
        System.out.println(b.convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        // 是否是负数
        boolean negative = num < 0;
        if (negative) {
            num = -num;
        }
        StringBuilder digits = new StringBuilder();
        do {
            digits.append(num % 7);
            num /= 7;
        } while (num > 0);

        if (negative) {
            digits.append('-');
        }
        return digits.reverse().toString();
    }
}
