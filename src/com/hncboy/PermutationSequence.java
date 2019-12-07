package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/7 10:10
 * @description 60.第k个排列
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 *
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class PermutationSequence {

    public static void main(String[] args) {
        PermutationSequence p = new PermutationSequence();
        System.out.println(p.getPermutation(3, 3));
        System.out.println(p.getPermutation(4, 9));
        System.out.println(p.getPermutation(5, 35));
    }

    private String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 将所有数字连接
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        // 1<=n<=9，factor[1]-factor[9] 存放9种阶乘的值
        int[] factor = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        StringBuilder result = new StringBuilder();

        // 遍历逐个确定各个位置的数字
        for (int i = n - 1; i >= 0; i--) {
            // 根据 第k-1个排列/上一个排列总次数 来确定当前用到了第几个数字
            int interval = (k - 1) / factor[i];
            result.append(sb.charAt(interval));
            sb.deleteCharAt(interval);
            k -= interval * factor[i];
        }
        return result.toString();
    }
}
