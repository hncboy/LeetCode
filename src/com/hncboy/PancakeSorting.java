package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/12/10 11:28
 * 969.煎饼排序
 *
 * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
 * 一次煎饼翻转的执行过程如下：
 *
 * 选择一个整数 k ，1 <= k <= arr.length
 * 反转子数组 arr[0...k-1]（下标从 0 开始）
 * 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
 *
 * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
 *
 * 示例 1：
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 arr = [3, 2, 4, 1]
 * 第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
 * 第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
 * 第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
 * 第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。
 *
 * 示例 2：
 * 输入：[1,2,3]
 * 输出：[]
 * 解释：
 * 输入已经排序，因此不需要翻转任何内容。
 * 请注意，其他可能的答案，如 [3，3] ，也将被判断为正确。
 *
 * 提示：
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= arr.length
 * arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列）
 * 通过次数 26,604 提交次数 39,571
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pancake-sorting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PancakeSorting {

    public static void main(String[] args) {
        PancakeSorting p = new PancakeSorting();
        System.out.println(p.pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(p.pancakeSort(new int[]{1, 2, 3}));
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        // 将每一个数 n 翻转到其对应的下标上
        for (int n = arr.length; n > 1; n--) {
            int index = 0;
            // 找到 [1, n] 中的最大值下标
            for (int i = 1; i < n; i++) {
                if (arr[i] >= arr[index]) {
                    index = i;
                }
            }
            // 如果已经在对应位置上，不用翻转
            if (index == n - 1) {
                continue;
            }

            // 翻转 [0, index]，将 index 下标对应的值移动到第一位
            reverse(arr, index);
            // 翻转 [0, n-1]，将第一位的值移动到 n-1 位，也就是正确的位置
            reverse(arr, n - 1);
            // 将移动的长度存入结果集
            result.add(index + 1);
            result.add(n);
        }
        return result;
    }

    /**
     * 翻转数组 [0, end]
     */
    private void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
