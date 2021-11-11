package com.hncboy;

/**
 * @author hncboy
 * @date 2021/11/11 8:44
 * @description 629.K个逆序对数组
 * 
 * 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
 * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
 * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
 *
 * 示例 1:
 * 输入: n = 3, k = 0
 * 输出: 1
 * 解释: 
 * 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
 *
 * 示例 2:
 * 输入: n = 3, k = 1
 * 输出: 2
 * 解释: 
 * 数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
 *
 * 说明:
 *  n 的范围是 [1, 1000] 并且 k 的范围是 [0, 1000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-inverse-pairs-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KInversePairsArray {

    public int kInversePairs(int n, int k) {
        // 如果 k 为 0，则只有一种情况，就是按 1-n 的顺序排序
        if (k == 0) {
            return 1;
        }

        // dp[i][j] 表示第 i 个数字的 j 个逆序对的数量
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        int mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                }

                if (dp[i][j] >= mod) {
                    dp[i][j] -= mod;
                } else if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                }
            }
        }
        return dp[n][k];
    }
}
