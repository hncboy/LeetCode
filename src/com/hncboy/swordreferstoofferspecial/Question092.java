package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2022/1/14 9:00
 * 剑指 Offer II 092.翻转字符
 *
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是 单调递增 的。
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 s，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 * 返回使 s 单调递增 的最小翻转次数。
 *
 * 示例 1：
 * 输入：s = "00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 *
 * 示例 2：
 * 输入：s = "010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 *
 * 示例 3：
 * 输入：s = "00011000"
 * 输出：2
 * 解释：我们翻转得到 00000000。
 *
 * 提示：
 * 1 <= s.length <= 20000
 * s 中只包含字符 '0' 和 '1'
 *
 * 注意：本题与主站 926 题 {@link com.hncboy.FlipStringToMonotoneIncreasing}
 * 相同： https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/
 * 通过次数 3,820 提交次数 5,644
 */
public class Question092 {

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] count = new int[n + 1];
        // 统计对应的i位置左边有多少个1
        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i] + s.charAt(i) - '0';
        }

        int result = n;
        // 统计最终结果中i左边0各出现多少次需要翻转的次数，也就是满足[0,i]是0，[i,n]是1的情况需要翻转的次数
        for (int i = 0; i <= n; i++) {
            // count[i] 为[0,i]中1的个数，也就是需要将1翻转为0的个数
            // n-i 为区间[i,n]中所有数的个数
            // count[n] - count[i] 为[i,n]内的1的个数，也就是不需要翻转的个数
            // n-i-(count[n] - count[i]) 为区间[i,n]内0的个数，也就是需要翻转的个数
            // 将[0,i]中为1需要翻转为0的个数 + [i,n]中为0需要翻转为1的个数
            result = Math.min(result, count[i] + n - i - (count[n] - count[i]));
        }
        return result;
    }
}
