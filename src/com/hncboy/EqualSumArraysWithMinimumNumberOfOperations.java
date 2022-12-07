package com.hncboy;

/**
 * @author hncboy
 * @date 2022/12/7 12:43
 * 1775.通过最少操作次数使数组的和相等
 * 通过次数12,589提交次数23,031
 */
public class EqualSumArraysWithMinimumNumberOfOperations {

    public static void main(String[] args) {
        EqualSumArraysWithMinimumNumberOfOperations e = new EqualSumArraysWithMinimumNumberOfOperations();
        System.out.println(e.minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}) == 3);
        System.out.println(e.minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}) == -1);
        System.out.println(e.minOperations(new int[]{6, 6}, new int[]{1}) == 3);
    }

    public int minOperations(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        // 假设一边都是 1，乘以 6 得到最大数，如果还是小于一边肯定不合法
        if (length1 * 6 < length2 || length2 * 6 < length1) {
            return -1;
        }

        // 统计每个数组中对应的值有多少个
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];

        // 对两边数组和求差
        int diff = 0;
        for (int num : nums1) {
            cnt1[num]++;
            diff += num;
        }
        for (int num : nums2) {
            cnt2[num]++;
            diff -= num;
        }

        if (diff == 0) {
            return 0;
        }

        if (diff > 0) {
            return help(cnt2, cnt1, diff);
        }
        return help(cnt1, cnt2, -diff);
    }


    private int help(int[] high, int[] low, int diff) {
        int[] h = new int[7];
        for (int i = 1; i < 7; ++i) {
            h[6 - i] += high[i];
            h[i - 1] += low[i];
        }

        int result = 0;
        // 从最后一个下标往前遍历
        for (int i = 5; i > 0 && diff > 0; --i) {
            // 计算如果要用 i 削减 diff 的最大次数
            int t = Math.min((diff + i - 1) / i, h[i]);
            result += t;
            diff -= t * i;
        }
        return result;
    }
}
