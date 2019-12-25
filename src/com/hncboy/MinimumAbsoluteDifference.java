package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/12/25 19:34
 * @description 1200.最小绝对差
 *
 * 给你个整数数组arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 *
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 *
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */
public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        MinimumAbsoluteDifference m = new MinimumAbsoluteDifference();
        int[] arr1 = {4, 2, 1, 3};
        int[] arr2 = {1, 3, 6, 10, 15};
        int[] arr3 = {3, 8, -10, 23, 19, -4, -14, 27};
        int[] arr4 = {40, 11, 26, 27, -20};
        System.out.println(m.minimumAbsDifference(arr1));
        System.out.println(m.minimumAbsDifference(arr2));
        System.out.println(m.minimumAbsDifference(arr3));
        System.out.println(m.minimumAbsDifference(arr4));
    }

    private List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(arr[0], arr[1]));

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == min) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (arr[i] - arr[i - 1] < min) {
                min = arr[i] - arr[i - 1];
                result.clear();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
