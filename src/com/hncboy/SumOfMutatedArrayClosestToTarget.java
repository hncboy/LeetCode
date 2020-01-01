package com.hncboy;

/**
 * @author hncboy
 * @date 2020/1/1 15:32
 * @description 1300.转变数组后最接近目标值的数组和
 *
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
 * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 *
 * 示例 1：
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 *
 * 示例 2：
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 *
 * 示例 3：
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 *
 * 提示：
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 */
public class SumOfMutatedArrayClosestToTarget {

    public static void main(String[] args) {
        SumOfMutatedArrayClosestToTarget s = new SumOfMutatedArrayClosestToTarget();
        System.out.println(s.findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(s.findBestValue(new int[]{2, 3, 5}, 10));
        System.out.println(s.findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }

    private int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = target;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = calcSum(arr, mid);
            // 如果 sum 小于 target，则需要增大 mid 的值
            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left 和 left-1 所在 sum 值刚好处于 target 的上下方，计算哪个离 target 最近
        int sum1 = calcSum(arr, left);
        int sum2 = calcSum(arr, left - 1);
        if (target - sum2 <= sum1 - target) {
            return left - 1;
        }
        return left;
    }

    private int calcSum(int[] arr, int mid) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, mid);
        }
        return sum;
    }
}
