package com.hncboy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hncboy
 * @date 2019/12/6 12:09
 * @description 962.最大宽度坡
 *
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 * 示例 1：
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 *
 * 示例 2：
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *
 * 提示：
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 */
public class MaximumWidthRamp {

    public static void main(String[] args) {
        MaximumWidthRamp m = new MaximumWidthRamp();
        System.out.println(m.maxWidthRamp2(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(m.maxWidthRamp2(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    public int maxWidthRamp2(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = i;
        }

        // 根据 A[i] 进行排序，B[i] 存储的是对应排第 i 的数的下标
        Arrays.sort(B, Comparator.comparingInt(i -> A[i]));

        int result = 0;
        int min = B.length;
        // 遍历所有下标
        for (int i : B) {
            // i-min 为当前的下标-之前最小的下标
            // 因为 B[i] 值也就是下标已经根据 A[i] 排序好了，所有只要取两段下标差的最大值
            result = Math.max(result, i - min);
            min = Math.min(min, i);
        }

        return result;
    }

    /**
     * 暴力
     *
     * @param A
     * @return
     */
    private int maxWidthRamp1(int[] A) {
        for (int i = A.length - 1; i > 0; i--) {
            int left = 0;
            int right = i;
            // 固定长度为 i 的窗口，往右滑动
            while (right < A.length) {
                if (A[left++] <= A[right++]) {
                    return i;
                }
            }
        }
        return 0;
    }
}
