package com.hncboy;

/**
 * @author hncboy
 * @date 2020/3/12 1:34
 * @description 1071.字符串的最大公因子
 *
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 * 示例 1：
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 *
 * 示例 2：
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 *
 * 示例 3：
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 * 提示：
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 */
public class GreatestCommonDivisorOfStrings {

    private String gcdOfStrings(String str1, String str2) {
        // str1=m*最大公约数，str2=n*最大公约数
        // str1+str2=(m+n)*最大公约数，所以满足拥有最大公约数的条件：str1+str2=str2+str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 在确定有有解的情况下，最优解的长度为 gcd(str1.length(), str2.length()) 的字符串
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
