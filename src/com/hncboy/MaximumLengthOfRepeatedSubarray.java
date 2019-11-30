package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/30 10:54
 * @description 718.最长重复子数组
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 * 说明:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray m = new MaximumLengthOfRepeatedSubarray();
        System.out.println(m.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    /**
     * 动态规划
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(M)
     * @param A
     * @param B
     * @return
     */
    private int findLength(int[] A, int[] B) {
        int result = 0;
        int[] dp = new int[B.length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[j + 1] = dp[j] + 1;
                    result = Math.max(dp[j + 1], result);
                } else {
                    dp[j + 1] = 0;
                }
            }
        }
        return result;
    }
}
