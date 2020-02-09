package com.hncboy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2020/2/2 10:53
 * @description 1342.数组大小减半
 *
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 *
 * 示例 1：
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 *
 * 示例 2：
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 *
 * 示例 3：
 * 输入：arr = [1,9]
 * 输出：1
 *
 * 示例 4：
 * 输入：arr = [1000,1000,3,7]
 * 输出：1
 *
 * 示例 5：
 * 输入：arr = [1,2,3,4,5,6,7,8,9,10]
 * 输出：5
 *  
 * 提示：
 * 1 <= arr.length <= 10^5
 * arr.length 为偶数
 * 1 <= arr[i] <= 10^5
 */
public class ReduceArraySizeToTheHalf {

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf r = new ReduceArraySizeToTheHalf();
        int[] arr1 = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        int[] arr2 = {7, 7, 7, 7, 7, 7};
        int[] arr3 = {1, 9};
        int[] arr4 = {1000, 1000, 3, 7};
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(r.minSetSize(arr1));
        System.out.println(r.minSetSize(arr2));
        System.out.println(r.minSetSize(arr3));
        System.out.println(r.minSetSize(arr4));
        System.out.println(r.minSetSize(arr5));
    }

    private int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int[] values = new int[map.size()];
        int i = 0;
        for (int value : map.values()) {
            values[i++] = value;
        }
        Arrays.sort(values);
        i--;
        int count = 0;
        for (; i >= 0; i--) {
            count += values[i];
            if (count >= arr.length / 2) {
                return map.size() - i;
            }
        }
        return arr.length / 2;
    }
}
