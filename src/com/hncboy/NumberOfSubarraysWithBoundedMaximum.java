package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/1 9:36
 * @description 795.区间子数组个数
 *
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 *
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 *
 * 注意:
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 */
public class NumberOfSubarraysWithBoundedMaximum {

    public static void main(String[] args) {
        NumberOfSubarraysWithBoundedMaximum n = new NumberOfSubarraysWithBoundedMaximum();
        System.out.println(n.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }

    private int numSubarrayBoundedMax(int[] A, int L, int R) {
        // 连续子数组中最大值小于 R 的数量 - 连续子数组中最大值小于 L-1 的数量
        // = 连续子数组中至少包含一个最大值在 [L,R] 的数量
        return count(A, R) - count(A, L - 1);
    }

    /**
     * 计算数组中元素小于 bound 的子数组数量
     *
     * @param A
     * @param bound
     * @return
     */
    public int count(int[] A, int bound) {
        int result = 0;
        // 有效子数组数量
        int curr = 0;
        for (int x : A) {
            // 当前元素小于 bound 时，有效子数组数量就是在上一次有效子数组的数量上+1
            curr = x <= bound ? curr + 1 : 0;
            result += curr;
        }
        return result;
    }
}
