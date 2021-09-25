package com.hncboy;

/**
 * @author hncboy
 * @date 2021/9/25 12:57
 * @description 583.两个字符串的删除操作
 * <p>
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * <p>
 * 示例：
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 * <p>
 * 提示：
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        DeleteOperationForTwoStrings d = new DeleteOperationForTwoStrings();
        assert d.minDistance1("sea", "eat") == 2;
        assert d.minDistance1("park", "spake") == 3;
    }

    /**
     * 动态规划
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     *
     * @param word1
     * @param word2
     * @return
     */
    private int minDistance1(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        // dp[i][j] 表示 word1 的前 length1 个字符与 word2 的前 length2 个字符的最长公共子序列
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // 如果两个字母一样，则最长公共子序列长度+1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return length1 + length2 - 2 * dp[length1][length2];
    }

    /**
     * 动态规划
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m)
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance2(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[] dp = new int[length2 + 1];

        for (int i = 1; i <= length1; i++) {
            // 上一个 dp[j] 位置的值
            int prevIndexValue = 0;
            for (int j = 1; j <= length2; j++) {
                // 当前 dp[j] 的旧值
                int currentIndexValue = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prevIndexValue + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                // last记录的是旧值，表示上一行的dp[j]
                prevIndexValue = currentIndexValue;
            }
        }
        return length1 + length2 - 2 * dp[length2];
    }
}
