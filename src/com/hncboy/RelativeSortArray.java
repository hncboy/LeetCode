package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/24 2:43
 * @description 1122.数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 提示：
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        RelativeSortArray r = new RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(r.relativeSortArray(arr1, arr2)));
    }

    private int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int[] result = new int[arr1.length];

        // 统计 arr1 中每个数字出现的次数
        for (int value : arr1) {
            count[value]++;
        }

        int index = 0;
        // 按相对顺序在 result 中放入 arr2 内容
        for (int value : arr2) {
            while (count[value] > 0) {
                result[index++] = value;
                count[value]--;
            }
        }

        // 将未在 arr2 中出现的元素放在 result 的最后面
        for(int i = 0; i < 1001; i++) {
            while(count[i] > 0) {
                result[index++] = i;
                count[i]--;
            }
        }
        return result;
    }
}
