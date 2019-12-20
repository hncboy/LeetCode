package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/21 1:01
 * @description 1089.复写零
 *
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 * 示例 1：
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 *
 * 示例 2：
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 * 提示：
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class DuplicateZeros {

    public static void main(String[] args) {
        DuplicateZeros d = new DuplicateZeros();
        d.duplicateZeros2(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        d.duplicateZeros2(new int[]{1, 2, 3});
    }

    private void duplicateZeros2(int[] arr) {
        // 拷贝一个一样的数组
        int[] nums = Arrays.copyOf(arr, arr.length);

        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (nums[j] == 0 && i < arr.length - 1) {
                arr[i] = nums[j];
                // 复写 0
                arr[++i] = 0;
            } else {
                // 原来数字后移
                arr[i] = nums[j];
            }
        }
    }

    private void duplicateZeros1(int[] arr) {
        int i = 0;
        int j = 0;
        // 扫描 0 的个数，j-i 为需要移动的个数
        while (j < arr.length) {
            if (arr[i++] == 0) {
                j++;
            }
            j++;
        }

        i--;
        j--;
        // 遍历要移动的个数
        while (i >= 0) {
            if (j < arr.length) {
                // 直接将 i 移动到 j
                arr[j] = arr[i];
            }
            // 如果 arr[i]==0，则在 j 前面增加一个 0
            if (arr[i] == 0) {
                arr[--j] = arr[i];
            }
            i--;
            j--;
        }
    }
}
