package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hncboy
 * @date 2019/12/15 10:40
 * @description 5124.顺次数
 *
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 *
 * 示例 1：
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 *
 * 示例 2：
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 *  
 * 提示：
 * 10 <= low <= high <= 10^9
 */
public class SequentialDigits {

    public static void main(String[] args) {
        SequentialDigits test2 = new SequentialDigits();
        System.out.println(test2.sequentialDigits1(100, 300));
        System.out.println(test2.sequentialDigits1(1000, 13000));
        // TODO
    }

    public List<Integer> sequentialDigits2(int low, int high) {
        int[] nums = {
                12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789};
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (num > high) {
                break;
            }
            if (num >= low) {
                result.add(num);
            }
        }
        return result;
    }

    /**
     * 穷举法
     *
     * @param low
     * @param high
     * @return
     */
    public List<Integer> sequentialDigits1(int low, int high) {
        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89));
        result.addAll(Arrays.asList(123, 234, 345, 456, 567, 678, 789));
        result.addAll(Arrays.asList(1234, 2345, 3456, 4567, 5678, 6789));
        result.addAll(Arrays.asList(12345, 23456, 34567, 45678, 56789));
        result.addAll(Arrays.asList(123456, 234567, 345678, 456789));
        result.addAll(Arrays.asList(1234567, 2345678, 3456789));
        result.addAll(Arrays.asList(12345678, 23456789));
        result.addAll(Collections.singletonList(123456789));
        return result.stream().filter(o -> o >= low && o <= high).collect(Collectors.toList());
    }
}
