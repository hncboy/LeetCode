package com.hncboy;

/**
 * @author hncboy
 * @date 2022/4/16 13:17
 * 479.最大回文数乘积
 * 
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 *
 * 示例 1:
 * 输入：n = 2
 * 输出：987
 * 解释：99 x 91 = 9009, 9009 % 1337 = 987
 * 
 * 示例 2:
 * 输入： n = 1
 * 输出： 9
 *
 * 提示:
 * 1 <= n <= 8
 * 通过次数 11,273 提交次数 19,270
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-palindrome-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestPalindromeProduct {

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        for (int i = max; i >= 0; i--) {
            long num = i, t = i;
            while (t != 0) {
                num = num * 10 + (t % 10);
                t /= 10;
            }
            for (long j = max; j * j >= num; j--) {
                if (num % j == 0) {
                    return (int)(num % 1337);
                }
            }
        }
        return -1;
    }
}
