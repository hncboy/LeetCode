package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/6 9:35
 * @description 961.重复 N 次的元素
 *
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
 *
 * 示例 1：
 * 输入：[1,2,3,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 *
 * 示例 3：
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *
 * 提示：
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 */
public class NRepeatedElementInSize2nArray {

    public static void main(String[] args) {
        NRepeatedElementInSize2nArray n = new NRepeatedElementInSize2nArray();
        System.out.println(n.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(n.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(n.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    public int repeatedNTimes(int[] A) {
        // 一定会满足这三种情况
        for (int k = 1; k <= 3; k++) {
            for (int i = 0; i < A.length - k; i++) {
                if (A[i] == A[i + k]) {
                    return A[i];
                }
            }
        }
        return -1;
    }
}
