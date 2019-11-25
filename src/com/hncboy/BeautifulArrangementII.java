package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/11/25 10:03
 * @description 667.优美的排列 II
 *
 * 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 * ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|,
 * |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 * ② 如果存在多种答案，你只需实现并返回其中任意一种.
 *
 * 示例 1:
 * 输入: n = 3, k = 1
 * 输出: [1, 2, 3]
 * 解释: [1, 2, 3] 包含 3 个范围在 1-3 的不同整数， 并且 [1, 1] 中有且仅有 1 个不同整数 : 1
 *
 * 示例 2:
 * 输入: n = 3, k = 2
 * 输出: [1, 3, 2]
 * 解释: [1, 3, 2] 包含 3 个范围在 1-3 的不同整数， 并且 [2, 1] 中有且仅有 2 个不同整数: 1 和 2
 *  
 *
 * 提示:
 *  n 和 k 满足条件 1 <= k < n <= 104.
 */
public class BeautifulArrangementII {

    public static void main(String[] args) {
        BeautifulArrangementII b = new BeautifulArrangementII();
        System.out.println(Arrays.toString(b.constructArray2(3, 1)));
        System.out.println(Arrays.toString(b.constructArray2(3, 2)));
    }

    /**
     * 找规律
     *
     * @param n
     * @param k
     * @return
     */
    private int[] constructArray2(int n, int k) {
        int[] result = new int[n];

        // [0,k]区间内，偶数下标使用 [1,2,3...] 填充
        for (int i = 0, j = 1; i <= k; i += 2, j++) {
            result[i] = j;
        }

        // [0,k]区间内，奇数下标使用 [k+1,k,k-1...] 填充
        for (int i = 1, j = k + 1; i <= k; i += 2, j--) {
            result[i] = j;
        }

        // [k+1,n-1]区间内，顺序填充
        for (int i = k + 1; i < n; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    /**
     * 反转数组
     *
     * @param n
     * @param k
     * @return
     */
    private int[] constructArray1(int n, int k) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        for (int i = 1; i < k; i++) {
            reverse(result, i, n - 1);
        }
        return result;
    }

    /**
     * 反转 result[i]-result[j]
     *
     * @param result
     * @param i
     * @param j
     */
    private void reverse(int[] result, int i, int j) {
        while (i < j) {
            result[i] = result[i] ^ result[j];
            result[j] = result[i] ^ result[j];
            result[i] = result[i++] ^ result[j--];
        }
    }
}
