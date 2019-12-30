package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/29 10:28
 * @description 1304.和为零的N个唯一整数
 *
 * 给你一个整数n，请你返回 任意一个由 n个 各不相同的整数组成的数组，并且这 n 个数相加和为 0 。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * 
 * 示例 2：
 * 输入：n = 3
 * 输出：[-1,0,1]
 * 
 * 示例 3：
 * 输入：n = 1
 * 输出：[0]
 *
 * 提示：
 * 1 <= n <= 1000
 */
public class FindNUniqueIntegersSumUpToZero {

    public static void main(String[] args) {
        FindNUniqueIntegersSumUpToZero f = new FindNUniqueIntegersSumUpToZero();
        System.out.println(Arrays.toString(f.sumZero(5)));
        System.out.println(Arrays.toString(f.sumZero(3)));
        System.out.println(Arrays.toString(f.sumZero(1)));
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n / 2; i++) {
            result[i * 2] = i + 1;
            result[i * 2 + 1] = -(i + 1);
        }
        return result;
    }
}
