package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/14 14:34
 * @description 977.有序数组的平方
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        SquaresOfASortedArray s = new SquaresOfASortedArray();
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    private int[] sortedSquares(int[] A) {
        // 非递减排序，双指针，最大的肯定在头或尾
        int[] result = new int[A.length];
        int count = result.length;
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int a = A[left] * A[left];
            int b = A[right] * A[right];

            if (a < b) {
                result[--count] = b;
                right--;
            } else if (a > b) {
                result[--count] = a;
                left++;
            } else {
                result[--count] = a;
                result[--count] = b;
                left++;
                right--;
            }
        }

        if (left == right) {
            result[--count] = A[left] * A[left];
        }

        return result;
    }
}
