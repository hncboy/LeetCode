package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/12/10 11:28
 * @description 969.煎饼排序
 *
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，
 * 然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。
 * 任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 *
 * 示例 1：
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 A = [3, 2, 4, 1]
 * 第一次翻转后 (k=4): A = [1, 4, 2, 3]
 * 第二次翻转后 (k=2): A = [4, 1, 2, 3]
 * 第三次翻转后 (k=4): A = [3, 2, 1, 4]
 * 第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
 *
 * 示例 2：
 * 输入：[1,2,3]
 * 输出：[]
 * 解释：
 * 输入已经排序，因此不需要翻转任何内容。
 * 请注意，其他可能的答案，如[3，3]，也将被接受。
 *
 * 提示：
 * 1 <= A.length <= 100
 * A[i] 是 [1, 2, ..., A.length] 的排列
 */
public class PancakeSorting {

    public static void main(String[] args) {
        PancakeSorting p = new PancakeSorting();
        System.out.println(p.pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(p.pancakeSort(new int[]{1, 2, 3}));
    }

    private List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();

        // 当前需要找到的最大值
        int currentMax = A.length;
        while (currentMax > 0) {
            int i = findMaxIndex(A, currentMax);
            // 如果最大值已经在对应的位置了，不用翻转
            if (i == currentMax - 1) {
                currentMax--;
                continue;
            }
            // 将最大值翻到第一位
            if (i != 0) {
                reverse(A, i);
                result.add(i + 1);
            }
            // 将最大值翻到最后一位
            if (currentMax != 1) {
                reverse(A, currentMax - 1);
                result.add(currentMax);
            }
            currentMax--;
        }

        return result;
    }

    /**
     * 翻转数组 A 中 [0,j]
     *
     * @param A
     * @param j
     */
    private void reverse(int[] A, int j) {
        for (int i = 0; i < (j + 1) / 2; i++) {
            A[i] = A[i] ^ A[j - i];
            A[j - i] = A[i] ^ A[j - i];
            A[i] = A[i] ^ A[j - i];
        }
    }

    /**
     * 找到数组A中值为 currentMax 的下标
     *
     * @param A
     * @param currentMax
     * @return
     */
    private int findMaxIndex(int[] A, int currentMax) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == currentMax) {
                return i;
            }
        }
        return A.length - 1;
    }
}
