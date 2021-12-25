package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/25 13:31
 * 115.不同的子序列
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
 * 通过次数 68,201 提交次数 130,942
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        // dp[i][j] 表示 t 字符串前 i 个字符可以由 s 字符串前 j 个字符串组成多少数
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        // 初始化第一行，空字符串
        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    // 如果字符串 t 的第 i-1 个字符和字符串 s 的第 j-1 个字符一样，此时考虑两种情况
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public int numDistinct2(String s, String t) {
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
