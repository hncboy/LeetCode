package com.hncboy.swordreferstoofferspecial;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2022/1/6 9:55
 * 剑指 Offer II 093.最长斐波那契数列
 * 
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。
 *
 * （回想一下，子序列是从原序列  arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。
 * 例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 *
 * 示例 1：
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 *
 * 示例 2：
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 *  
 * 提示：
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 *
 * 注意：本题与主站 873 题 {@link com.hncboy.LengthOfLongestFibonacciSubsequence}
 * 相同： https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/
 * 通过次数 3,093 提交次数 5,410
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Q91FMA
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question093 {

    public int lenLongestFibSubseq(int[] arr) {
        // dp[i][j] 表示以 arr[i] 和 arr[j] 结尾的子序列的最大斐波那契数列长度
        int[][] dp = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], 2);
        }

        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            int left = 0;
            int right = i - 1;
            // 遍历能组成 arr[i] 的两个数
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == arr[i]) {
                    dp[right][i] = dp[left][right] + 1;
                    result = Math.max(dp[right][i], result);
                    left++;
                    right--;
                } else if (sum < arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
