package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/6 10:25
 * @description 941.有效的山脉数组
 *
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 *  
 * 示例 1：
 * 输入：[2,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：[3,5,5]
 * 输出：false
 *
 * 示例 3：
 * 输入：[0,3,2,1]
 * 输出：true
 *
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        ValidMountainArray v = new ValidMountainArray();
        System.out.println(v.validMountainArray(new int[]{2, 1}));
        System.out.println(v.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(v.validMountainArray(new int[]{0, 3, 2, 1}));
    }

    private boolean validMountainArray(int[] A) {
        if (A.length < 3 || A[1] < A[0]) {
            return false;
        }
        int up = 0;
        // 上升到山顶
        while (up < A.length - 1 && A[up] < A[up + 1]) {
            up++;
        }

        if (up ==0 || up==A.length -1) {
            return false;
        }

        // 从山顶下降
        for (int down = A.length - 1; down > up; down--) {
            if (A[down] >= A[down - 1]) {
                return false;
            }
        }
        return true;
    }
}
