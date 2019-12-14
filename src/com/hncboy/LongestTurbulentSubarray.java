package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/14 18:38
 * @description 978.最长湍流子数组
 *
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 返回 A 的最大湍流子数组的长度。
 *
 * 示例 1：
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 *
 * 示例 2：
 * 输入：[4,8,12,16]
 * 输出：2
 *
 * 示例 3：
 * 输入：[100]
 * 输出：1
 *  
 * 提示：
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */
public class LongestTurbulentSubarray {

    public static void main(String[] args) {
        LongestTurbulentSubarray l = new LongestTurbulentSubarray();
        System.out.println(l.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(l.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        System.out.println(l.maxTurbulenceSize(new int[]{100}));
        System.out.println(l.maxTurbulenceSize(new int[]{0, 8, 45, 88, 48, 68, 28, 55, 17, 24}));
    }

    private int maxTurbulenceSize(int[] A) {
        int result = 1;
        int count1 = 1;
        int count2 = 1;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                count1 = count2 = 1;
                continue;
            }

            if (i % 2 == 0) {
                if (A[i] < A[i + 1]) {
                    count1++;
                    count2 = 1;
                } else {
                    count2++;
                    count1 = 1;
                }
            } else {
                if (A[i] > A[i + 1]) {
                    count1++;
                    count2 = 1;
                } else {
                    count2++;
                    count1 = 1;
                }
            }
            result = Math.max(result, Math.max(count1, count2));
        }

        return result;
    }
}
