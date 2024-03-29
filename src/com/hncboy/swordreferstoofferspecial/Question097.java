package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/12/25 15:22
 * 剑指 Offer II 097.子序列的数目
 * 
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 *
 * 示例 2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 * 提示：
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 *  
 * 注意：本题与主站 115 题 {@link com.hncboy.DistinctSubsequences} 相同： https://leetcode-cn.com/problems/distinct-subsequences/
 * 通过次数 2,004 提交次数 3,690
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/21dk04
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question097 {

    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        // dp[0]表示空字符串
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++){
            for (int j = t.length() - 1; j >= 0; j--) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }
}
