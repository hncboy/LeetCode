package com.hncboy;

/**
 * @author hncboy
 * @date 2021/9/27 8:25
 * @description 639.解码方法 II
 * 
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 *
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
 *
 * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。
 * 例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。
 * 对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
 *
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
 * 由于答案数目可能非常大，返回对 109 + 7 取余 的结果。
 *
 * 示例 1：
 * 输入：s = "*"
 * 输出：9
 * 解释：这一条编码消息可以表示 "1"、"2"、"3"、"4"、"5"、"6"、"7"、"8" 或 "9" 中的任意一条。
 * 可以分别解码成字符串 "A"、"B"、"C"、"D"、"E"、"F"、"G"、"H" 和 "I" 。
 * 因此，"*" 总共有 9 种解码方法。
 *
 * 示例 2：
 * 输入：s = "1*"
 * 输出：18
 * 解释：这一条编码消息可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条。
 * 每种消息都可以由 2 种方法解码（例如，"11" 可以解码成 "AA" 或 "K"）。
 * 因此，"1*" 共有 9 * 2 = 18 种解码方法。
 *
 * 示例 3：
 * 输入：s = "2*"
 * 输出：15
 * 解释：这一条编码消息可以表示 "21"、"22"、"23"、"24"、"25"、"26"、"27"、"28" 或 "29" 中的任意一条。
 * "21"、"22"、"23"、"24"、"25" 和 "26" 由 2 种解码方法，但 "27"、"28" 和 "29" 仅有 1 种解码方法。
 * 因此，"2*" 共有 (6 * 2) + (3 * 1) = 12 + 3 = 15 种解码方法。
 *
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 是 0 - 9 中的一位数字或字符 '*'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeWaysIi {

    private static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        long lastLast = 0;
        long last = 1;
        long currentMax = 0;
        for (int i = 1; i <= n; ++i) {
            char ch2 = s.charAt(i - 1);
            // 上一个字符的最大组合次数*当前一个字符时的最大组合次数
            currentMax = last * check1digit(ch2) % MOD;
            if (i > 1) {
                char ch1 = s.charAt(i - 2);
                // 上一个字符的最大组合次数 + 上上一个字符的最大组合次数*当前两个字符时的最大组合次数
                currentMax = (currentMax + lastLast * check2digits(ch1, ch2)) % MOD;
            }
            lastLast = last;
            last = currentMax;
        }
        return (int) currentMax;
    }

    /**
     * 检验一个字符的情况下的最大组合次数
     * @param ch ch
     * @return
     */
    public int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    /**
     * 检验两个字符的情况下的最大组合次数
     * @param ch1 ch1 只能是 1 或 2
     * @param ch2 ch2 ch1=1时，ch2[0, 9]，ch1=2时，ch2[0, 6]
     * @return
     */
    public int check2digits(char ch1, char ch2) {
        // [11,19] 和 [21, 26] 15次
        if (ch1 == '*' && ch2 == '*') {
            return 15;
        }

        // ch2∈[0, 6] 时，ch1∈[1,2]，ch2∈[7, 9] 时，ch1=1
        if (ch1 == '*') {
            return ch2 <= '6' ? 2 : 1;
        }

        if (ch2 == '*') {
            if (ch1 == '1') {
                return 9;
            }
            if (ch1 == '2') {
                return 6;
            }
            return 0;
        }

        // 此时 ch1 和 ch2 都为数字，当 ch1+ch2 的组合数字小于 26 时算一种情况，否则 0 种
        return (ch1 != '0' && (ch1 - '0') * 10 + (ch2 - '0') <= 26) ? 1 : 0;
    }
}
