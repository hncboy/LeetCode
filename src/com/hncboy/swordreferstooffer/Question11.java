package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/2/16 17:10
 * @description 面试题11.旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Question11 {

    private int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        // 原来是升序的数组，旋转之后，其中任意一个位置
        // 要么左边的数组有序，要不右边的数组有序。
        // 当该位置左边的数组有序并且右边的数组有序时，该位置存在最小的元素。
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                // 左边有序，最小的数字一定在 mid 右边
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                // 右边有序，最小的数字一定在 mid 左边，包括 mid 位置
                right = mid;
            } else {
                // 相等时，判断不了最小的数字在左边还是在右边，一个一个试，先排除 right 位置
                right = right - 1;
            }
        }

        return numbers[left];
    }
}
