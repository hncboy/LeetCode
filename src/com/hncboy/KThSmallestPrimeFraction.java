package com.hncboy;

/**
 * @author hncboy
 * @date 2021/11/29 8:51
 * @description 786.第 K 个最小的素数分数
 * 
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 *
 * 示例 1：
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示: 
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 *
 * 示例 2：
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 *
 * 提示：
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-prime-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KThSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0;
        double right = 1;

        // 二分，从 min=0.5 开始
        while (left < right) {
            double mid = (left + right) / 2;
            int[] num = find(arr, mid);

            if (num[2] > k) {
                right = mid;
            } else if (num[2] < k) {
                left = mid;
            } else {
                // 如果 k 个素数分数小于 mid，则返回此时的分子分母
                return new int[]{num[0], num[1]};
            }
        }
        return new int[0];
    }

    private int[] find(int[] arr, double x) {
        int count = 0;
        int a = arr[0];
        int b = arr[arr.length - 1];

        // i 作为分子，j 作为分母
        for (int i = -1, j = 1; j < arr.length; j++) {
            // 分母不动，分子自增，直到找到 arr[i+1]/arr[j] 比 x 大的数
            while (i < j - 1 && arr[i + 1] < x * arr[j]) {
                i++;
            }

            // 此时 0-i 都可以作为分子，总数加上 i+1
            count += i + 1;

            // 计算 a/b 的最大值
            if (i >= 0 && arr[i] * b > arr[j] * a) {
                a = arr[i];
                b = arr[j];
            }
        }
        return new int[]{a, b, count};
    }
}
