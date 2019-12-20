package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/20 19:53
 * @description 1053.交换一次的先前排列
 *
 * 给你一个正整数的数组 A（其中的元素不一定完全不同），
 * 请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。
 * 如果无法这么操作，就请返回原数组。
 *
 * 示例 1：
 * 输入：[3,2,1]
 * 输出：[3,1,2]
 * 解释：
 * 交换 2 和 1
 *  
 * 示例 2：
 * 输入：[1,1,5]
 * 输出：[1,1,5]
 * 解释：
 * 这已经是最小排列
 *
 * 示例 3：
 * 输入：[1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：
 * 交换 9 和 7
 *  
 * 示例 4：
 * 输入：[3,1,1,3]
 * 输出：[1,3,1,3]
 * 解释：
 * 交换 1 和 3
 *
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= A[i] <= 10000
 */
public class PreviousPermutationWithOneSwap {

    public static void main(String[] args) {
        PreviousPermutationWithOneSwap p = new PreviousPermutationWithOneSwap();
        System.out.println(Arrays.toString(p.prevPermOpt1(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(p.prevPermOpt1(new int[]{1, 1, 5})));
        System.out.println(Arrays.toString(p.prevPermOpt1(new int[]{1, 9, 4, 6, 7})));
        System.out.println(Arrays.toString(p.prevPermOpt1(new int[]{3, 1, 1, 3})));
    }

    private int[] prevPermOpt1(int[] A) {
        int currMax = -1;
        int index = -1;
        boolean isFind = false;

        // 从后往前遍历
        for (int i = A.length - 2; i >= 0; i--) {
            // 找到逆序的数
            if (A[i] > A[i + 1]) {
                // 遍历i+1后面的数
                for (int j = i + 1; j < A.length; j++) {
                    // 当找到比i更小的数
                    if (A[i] > A[j]) {
                        isFind = true;
                        // 如果该交换的数大于已经记录的当前最大数，则更新最大数，用于找到最大的排列
                        if (A[j] > currMax) {
                            currMax = A[j];
                            index = j;
                        }
                    }
                }
                // 如果找到了更小的，交换两个数
                if (isFind) {
                    int tmp = A[i];
                    A[i] = A[index];
                    A[index] = tmp;
                    return A;
                }
            }
        }
        return A;
    }
}
