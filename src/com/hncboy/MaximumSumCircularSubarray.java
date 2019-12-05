package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/5 10:53
 * @description 918.环形子数组的最大和
 *
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。
 * （形式上，当0 <= i < A.length 时 C[i] = A[i]，而当 i >= 0 时 C[i+A.length] = C[i]）
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（
 * 形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 *
 *
 * 示例 1：
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 *
 * 示例 2：
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 *
 * 示例 3：
 * 输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 *
 * 示例 4：
 * 输入：[3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 *
 * 示例 5：
 * 输入：[-2,-3,-1]
 * 输出：-1
 * 解释：从子数组 [-1] 得到最大和 -1
 *  
 * 提示：
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 */
public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        MaximumSumCircularSubarray m = new MaximumSumCircularSubarray();
        System.out.println(m.maxSubarraySumCircular(new int[]{-1, -2, -3, -4, -5}));
        System.out.println(m.maxSubarraySumCircular(new int[]{2, 3, -10, -9, 5, 6}));
        System.out.println(m.maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(m.maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(m.maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    public int maxSubarraySumCircular(int[] A) {
        // 连续子串的最大值
        int max;
        // 连续子串的最小值
        int min;

        int sum;
        int currMax;
        int currMin;
        sum = max = min = currMin = currMax = A[0];

        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            currMax = A[i] + Math.max(currMax, 0);
            max = Math.max(max, currMax);
            currMin = A[i] + Math.min(currMin, 0);
            min = Math.min(min, currMin);
        }
        return max < 0 ? max : Math.max(max, sum - min);
    }
}
