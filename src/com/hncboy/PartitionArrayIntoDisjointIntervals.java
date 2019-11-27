package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/27 12:30
 * @description 915.分割数组
 *
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 *
 * 示例 1：
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 *
 * 输入：[1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 *  
 * 提示：
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的
 */
public class PartitionArrayIntoDisjointIntervals {

    public static void main(String[] args) {
        PartitionArrayIntoDisjointIntervals p = new PartitionArrayIntoDisjointIntervals();
        System.out.println(p.partitionDisjoint2(new int[]{5, 0, 3, 8, 6}));
        System.out.println(p.partitionDisjoint2(new int[]{1, 1, 1, 0, 6, 12}));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param A
     * @return
     */
    private int partitionDisjoint2(int[] A) {
        // 记录左边最大值
        int leftMax = A[0];
        // 记录当前最大值
        int currentMax = A[0];
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            // 如果当前的数小于左边最大值
            if (A[i] < leftMax) {
                // 更新左边最大值和左半部分长度
                // 当前最大值肯定在 A[i] 前面，既然 A[i]已经统计进去了，那么 leftMax 也用 currentMax 更新
                leftMax = currentMax;
                count = i + 1;
            } else {
                // 更新当前最大值
                currentMax = Math.max(currentMax, A[i]);
            }
        }
        return count;
    }


    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param A
     * @return
     */
    private int partitionDisjoint1(int[] A) {
        int n = A.length;
        // 从0往后统计区间的最大值
        int[] leftMax = new int[n];
        // 从n-1往前统计区间内的最小值
        int[] rightMin = new int[n];
        leftMax[0] = A[0];
        rightMin[0] = A[n - 1];

        // 更新区间内的最大值和最小值
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(A[i], leftMax[i - 1]);
            rightMin[i] = Math.min(A[n - i - 1], rightMin[i - 1]);
        }

        for (int i = 0; i < n - 1; i++) {
            // 当左半部分的最大值小于右半部分的最小值时结束
            if (leftMax[i] <= rightMin[n - i - 2]) {
                return i + 1;
            }
        }
        return n;
    }
}
