package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/18 21:03
 * @description 1014.最佳观光组合
 *
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *  
 * 示例：
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * 提示：
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class BestSightseeingPair {

    public static void main(String[] args) {
        BestSightseeingPair b = new BestSightseeingPair();
        System.out.println(b.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    private int maxScoreSightseeingPair(int[] A) {
        // A[i] + A[j] + i - j （i < j）
        // A[i]+i + A[j]-j
        // A[j]-j 固定，求 A[i]+i 最大值
        int result = 0;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            result = Math.max(result, max + A[i] - i);
            max = Math.max(max, A[i] + i);
        }
        return result;
    }
}
