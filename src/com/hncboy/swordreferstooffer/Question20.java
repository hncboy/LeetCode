package com.hncboy.swordreferstooffer;

/**
 *
 * @author hncboy
 * @date 2021/9/30 12:29
 * @description 剑指 Offer 20.表示数值的字符串
 * 
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 *
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 *
 * 示例 1：
 * 输入：s = "0"
 * 输出：true
 * 
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 * 
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 * 
 * 示例 4：
 * 输入：s = "    .1  "
 * 输出：true
 *
 * 提示：
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question20 {

    public static void main(String[] args) {
        Question20 q = new Question20();
        System.out.println(q.isNumber("0"));
        System.out.println(q.isNumber("e"));
        System.out.println(q.isNumber("."));
        System.out.println(q.isNumber("    .1  "));
    }

    private boolean isNumber(String s) {
        int n = s.length();

        // 字符串索引
        int index = 0;

        // 判断是否有数字
        boolean hasNum = false;
        // 判断是否有 e
        boolean hasE = false;
        // 判断是否有正负符号
        boolean hasSign = false;
        // 判断是否有小数点
        boolean hasDot = false;

        // 移除开头的空格
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // 从 index 开始遍历到 n
        while (index < n) {
            // 寻找数字
            while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
                hasNum = true;
            }
            if (index == n) {
                break;
            }

            // 获取当前字符
            char ch = s.charAt(index);

            // 如果当前字符是 e 或 E
            if (ch == 'e' || ch == 'E') {
                // 如果之前已经出现过 e 或者之前没有出现过数字直接出现 e，则返回 false
                if (hasE || !hasNum) {
                    return false;
                }
                // 将 hasE 置为 true，其他置为 false
                hasE = true;
                hasNum = false;
                hasSign = false;
                hasDot = false;
            } else if (ch == '+' || ch == '-') {
                // + 或 - 符号肯定要在其他符号前出现，如果已经出现过其他符号，则返回 false
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (ch == '.') {
                // 如果当前字符是 '.'，符号 . 可以出现在数字前后，不能在 e 之后出现或重复出现
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (ch == ' ') {
                // 字符串中间或者末尾出现空格，结束循环
                break;
            } else {
                // 出现了其他情况直接返回 false
                return false;
            }
            index++;
        }

        // 移除末尾的空格
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // 如果遍历到了末尾并且是数字才返回 true
        return hasNum && index == n;
    }
}
