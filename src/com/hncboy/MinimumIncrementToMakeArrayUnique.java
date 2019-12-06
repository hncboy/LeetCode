package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/6 8:45
 * @description 945.使数组唯一的最小增量
 *
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 *
 * 示例 2:
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 提示：
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 */
public class MinimumIncrementToMakeArrayUnique {

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique m = new MinimumIncrementToMakeArrayUnique();
        System.out.println(m.minIncrementForUnique2(new int[]{1, 2, 2}));
        System.out.println(m.minIncrementForUnique2(new int[]{3, 2, 1, 2, 1, 7}));
        System.out.println(m.minIncrementForUnique2(new int[]{39999, 39999, 39999, 39999}));
    }

    /**
     * 时间复杂度：O(nlongn)
     * 空间复杂度：O(1)
     *
     * @param A
     * @return
     */
    private int minIncrementForUnique1(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                count += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return count;
    }

    private int minIncrementForUnique2(int[] A) {
        // 0 <= A.length <= 40000
        int[] dp = new int[40002];
        for (int a : A) {
            dp[a]++;
        }

        int sum = 0;
        for (int i = 0; i < dp.length - 1; i++) {
            if (dp[i] > 1) {
                // 每个数的个数都为1，将多出来的部分添加后一个数
                sum += dp[i] - 1;
                dp[i + 1] += dp[i] - 1;
            }
        }
        if (dp[40001] > 1) {
            //  因为 0 <= A[i] < 40000，当有多个数取到 400001 时，依次将这些数往后排
            // 通过公式计算需要移动的次数
            sum += (dp[40001] - 1) * dp[40001] / 2;
        }
        return sum;
    }
}