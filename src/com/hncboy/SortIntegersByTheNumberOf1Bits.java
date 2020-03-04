package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2020/2/22 22:29
 * @description 1356.根据数字二进制下 1 的数目排序
 *
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 *
 * 示例 1：
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 *
 * 示例 2：
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 *
 * 示例 3：
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 *
 * 示例 4：
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 *
 * 示例 5：
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *
 * 提示：
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 */
public class SortIntegersByTheNumberOf1Bits {

    public static void main(String[] args) {
        SortIntegersByTheNumberOf1Bits s = new SortIntegersByTheNumberOf1Bits();
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        int[] arr3 = {10000, 10000};
        int[] arr4 = {2, 3, 5, 7, 11, 13, 17, 19};
        System.out.println(Arrays.toString(s.sortByBits(arr1)));
        System.out.println(Arrays.toString(s.sortByBits(arr2)));
        System.out.println(Arrays.toString(s.sortByBits(arr3)));
        System.out.println(Arrays.toString(s.sortByBits(arr4)));
    }

    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        // key：二进制中1出现的次数 value：对应的数
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int value : arr) {
            int count = 0;
            int num = value;
            // 计算二进制中1的个数
            while (num > 0) {
                if ((num & 1) == 1) {
                    count++;
                }
                num >>= 1;
            }
            List<Integer> list = map.containsKey(count) ? map.get(count) : new ArrayList<>();
            list.add(value);
            map.put(count, list);
        }

        int[] result = new int[arr.length];
        int i = 0;
        // 遍历 map，因为 TreeMap 是按顺序存放二进制1出现次数的
        // 而 value 的 list 也是排好序后按顺序存入的，所以依次取出即可
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int num : list) {
                result[i++] = num;
            }
        }

        return result;
    }
}
