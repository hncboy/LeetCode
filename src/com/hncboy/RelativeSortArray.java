package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/24 2:43
 * 1122.数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 提示：
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * 通过次数 67,913 提交次数 96,066
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        RelativeSortArray r = new RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(r.relativeSortArray(arr1, arr2)));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        // 统计 arr1 中每个数字出现的次数
        for (int num : arr1) {
            count[num]++;
        }

        int[] result = new int[arr1.length];
        int index = 0;
        // 按相对顺序在 result 中放入 arr2 内容
        for (int num : arr2) {
            // 获取该数在 arr1 中的数量存入
            while (count[num] > 0) {
                result[index++] = num;
                count[num]--;
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
