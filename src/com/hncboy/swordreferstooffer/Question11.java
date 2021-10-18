package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/2/16 17:10
 * @description 剑指 Offer 11.旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题 {@link com.hncboy.FindMinimumInRotatedSortedArrayII}
 * 相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question11 {

    public int minArray(int[] numbers) {
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
                // 当出现 numbers[mid] 和 numbers[right] 相等时，直接遍历 left+1 和 right 之间的数字获得最小值
                int result = left;
                for (int i = left + 1; i < right; i++) {
                    if (numbers[i] < numbers[result]) {
                        result = i;
                    }
                }
                return numbers[result];
            }
        }

        return numbers[left];
    }
}
