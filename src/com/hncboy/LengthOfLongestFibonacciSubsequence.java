package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/3 17:10
 * @description 873.最长的斐波那契子序列的长度
 *
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 *
 * （回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），
 * 而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 *  
 *
 * 示例 1：
 * 输入: [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释:
 * 最长的斐波那契式子序列为：[1,2,3,5,8] 。
 *
 * 示例 2：
 * 输入: [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释:
 * 最长的斐波那契式子序列有：
 * [1,11,12]，[3,11,14] 以及 [7,11,18] 。
 *  
 * 提示：
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * （对于以 Java，C，C++，以及 C# 的提交，时间限制被减少了 50%）
 */
public class LengthOfLongestFibonacciSubsequence {

    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence l = new LengthOfLongestFibonacciSubsequence();
        System.out.println(l.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(l.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
    }

    private int lenLongestFibSubseq(int[] A) {
        // dp[i][j]表示以A[i]和A[j]结尾的子序列的最大斐波那契数列长度
        int[][] dp = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], 2);
        }

        int result = 0;
        for (int i = 1; i < A.length; i++) {
            int left = 0;
            int right = i - 1;
            // 遍历能组成 A[i] 的两个数
            while (left < right) {
                int sum = A[left] + A[right];
                if (sum == A[i]) {
                    // A[left]+A[right]=A[i]，计算以 A[right]和A[i]结尾的斐波那契数列长度
                    dp[right][i] = dp[left][right] + 1;
                    result = Math.max(dp[right][i], result);
                    left++;
                    right--;
                } else if (sum < A[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
