package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/12/25 19:34
 * @description 1200.��С���Բ�
 *
 * �������������arr������ÿ��Ԫ�ض� ����ͬ��
 * �����ҵ����о�����С���Բ��Ԫ�ضԣ����Ұ������˳�򷵻ء�
 *
 * ʾ�� 1��
 * ���룺arr = [4,2,1,3]
 * �����[[1,2],[2,3],[3,4]]
 *
 * ʾ�� 2��
 * ���룺arr = [1,3,6,10,15]
 * �����[[1,3]]
 *
 * ʾ�� 3��
 * ���룺arr = [3,8,-10,23,19,-4,-14,27]
 * �����[[-14,-10],[19,23],[23,27]]
 *
 * ��ʾ��
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
