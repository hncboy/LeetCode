package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2020/1/11 22:25
 * @description 5143.解压缩编码列表
 *
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 * 考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），
 * 每一对都表示解压后有 a 个值为 b 的元素。
 * 请你返回解压后的列表。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 *
 * 提示：
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class DecompressRunLengthEncodedList {

    public static void main(String[] args) {
        DecompressRunLengthEncodedList d = new DecompressRunLengthEncodedList();
        System.out.println(Arrays.toString(d.decompressRLElist(new int[]{1, 2, 3, 4, 5})));
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i * 2 + 1 < nums.length; i++) {
            for (int j = 0; j < nums[i * 2]; j++) {
                list.add(nums[i * 2 + 1]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
