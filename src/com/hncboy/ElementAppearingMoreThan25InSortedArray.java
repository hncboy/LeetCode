package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/21 19:33
 * @description 1287.有序数组中出现次数超过25%的元素
 *
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 *
 * 示例：
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 * 提示：
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */
public class ElementAppearingMoreThan25InSortedArray {

    public static void main(String[] args) {
        ElementAppearingMoreThan25InSortedArray e = new ElementAppearingMoreThan25InSortedArray();
        System.out.println(e.findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
    }

    private int findSpecialInteger(int[] arr) {
        for (int i = 0, n = arr.length / 4; i < arr.length - n; i++) {
            if (arr[i] == arr[i + n]) {
                return arr[i];
            }
        }
        return arr[0];
    }
}
