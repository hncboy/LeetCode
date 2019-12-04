package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/4 14:57
 * @description 905.按奇偶排序数组
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 *  
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 * 提示：
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity s = new SortArrayByParity();
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{4, 4, 4})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{1, 1, 1})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{1, 1, 2})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{2, 1, 1})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{1, 0})));
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{0, 1})));
    }

    private int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        // 从左往右找奇数，从右往左找偶数
        while (left < right) {
            if ((A[left] & 1) > (A[right] & 1) ) {
                int temp = A[left];
                A[left++] = A[right];
                A[right--] = temp;
            }
            if ((A[left] & 1) == 0) {
                left++;
            }
            if ((A[right] & 1) == 1) {
                right--;
            }
        }
        return A;
    }
}
