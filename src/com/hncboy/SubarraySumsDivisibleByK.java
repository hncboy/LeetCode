package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/17 9:16
 * @description 974.和可被 K 整除的子数组
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 示例：
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 * 提示：
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 */
public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        SubarraySumsDivisibleByK s = new SubarraySumsDivisibleByK();
        System.out.println(s.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

    /**
     * 前缀和
     *
     * @param A
     * @param K
     * @return
     */
    private int subarraysDivByK(int[] A, int K) {
        int[] P = new int[A.length + 1];

        // 计算前缀和
        for (int i = 0; i < A.length; i++) {
            P[i + 1] = P[i] + A[i];
        }

        int[] count = new int[K];
        // 对前缀和取余，处理为负数的情况
        for (int x : P) {
            count[(x % K + K) % K]++;
        }

        int result = 0;
        // 遍历取余后的前缀和
        // 如果存在余数相同的数，那么这两个数相减即为 K 的整数倍
        // 通过公式 v*v(v-1)/2 计算当相同的数有 v 个时，可以构成多少个连续数组
        for (int v : count) {
            result += v * (v - 1) / 2;
        }

        return result;
    }
}
