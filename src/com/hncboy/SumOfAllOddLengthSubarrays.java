package com.hncboy;

/**
 * @author hncboy
 * @date 2020/10/30 14:17
 * @description 1588.所有奇数长度子数组的和
 *
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr中 所有奇数长度子数组的和 。
 *
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 *
 * 示例 3：
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 * 提示：
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfAllOddLengthSubarrays {

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays s = new SumOfAllOddLengthSubarrays();
        int[] arr1 = {1, 4, 2, 3, 5};
        int[] arr2 = {1, 2};
        int[] arr3 = {10, 11, 12};
        System.out.println(s.sumOddLengthSubarrays(arr1));
        System.out.println(s.sumOddLengthSubarrays(arr2));
        System.out.println(s.sumOddLengthSubarrays(arr3));
    }

    /**
     * 计算每个数出现的次数然后乘以其值
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int length = arr.length;
        int sum = 0;

        // 统计当前数在数组中出现的次数
        // 包含当前 arr[i] 的奇数长度连续子序列只会有两种情况
        // 1.左边奇数长度 + arr[i] + 右边奇数长度
        // 2.左边偶数长度 + arr[i] + 右边偶数长度
        for (int i = 0; i < arr.length; i++) {
            // 左边长度为奇数出现的次数
            int leftOdd = (i + 1) / 2;
            // 右边长度为奇数出现的次数
            int rightOdd = (length - i) / 2;

            // 左边长度为偶数出现的次数
            int leftEven = i / 2 + 1;
            // 右边长度为偶数出现的次数
            int rightEven = (length - 1 - i) / 2 + 1;

            // 情况1 + 情况2 出现的次数乘以当前的值
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }
}
