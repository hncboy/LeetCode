package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/12/4 12:09
 * @description 907.子数组的最小值之和
 *
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 *
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *
 * 提示：
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 */
public class SumOfSubarrayMinimums {

    public static void main(String[] args) {
        SumOfSubarrayMinimums s = new SumOfSubarrayMinimums();
        System.out.println(s.sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(s.sumSubarrayMins(new int[]{3, 6, 2, 5, 1, 4, 6, 8}));
    }

    private int sumSubarrayMins(int[] A) {
        // i 左边比 A[i] 大的数的个数为 left[i]
        int[] left = new int[A.length];
        // i 右边比 A[i] 大的数的个数为 right[i]
        int[] right = new int[A.length];
        // 单调递增栈
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            // 如果栈不为空，将比当前数大的数出栈
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                // 出栈的同时计算右边比当前出栈的那个数大的有多少个
                right[stack.peek()] = i - stack.pop() - 1;
            }
            // 计算比当前数大的左边数的个数，将比当前数大的数都弹出了，i-stack.peek()-1 则为结果
            left[i] = stack.isEmpty() ? i : i - stack.peek() - 1;
            stack.push(i);
        }
        // 更新剩下的单调递增的数，对于剩下的数来说，都是左边第一大的，所以只更新右边的
        while (!stack.isEmpty()) {
            right[stack.peek()] = A.length - 1 - stack.pop();
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result = (result + A[i] * (left[i] + 1) * (right[i] + 1)) % 1000000007;
        }
        return result;
    }
}