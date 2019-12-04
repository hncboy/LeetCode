package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/4 11:47
 * @description 896.单调数列
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 *
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 *
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 *
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 *
 * 提示：
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
public class MonotonicArray {

    public static void main(String[] args) {
        MonotonicArray m = new MonotonicArray();
        System.out.println(m.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(m.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(m.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(m.isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(m.isMonotonic(new int[]{1, 1, 1}));
        System.out.println(m.isMonotonic(new int[]{1, 3, 2, 4}));
        System.out.println(m.isMonotonic(new int[]{5, 3, 2, 4, 1}));
    }

    private boolean isMonotonic(int[] A) {
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                flag1 = true;
            } else if (A[i] < A[i + 1]) {
                flag2 = true;
            }

            if (flag1 && flag2) {
                return false;
            }
        }
        return true;
    }
}
