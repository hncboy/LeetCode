package com.hncboy;

/**
 * @author hncboy
 * @date 2022/3/23 19:05
 * 440.字典序的第K小数字
 * 
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 *
 * 示例 1:
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 
 * 示例 2:
 * 输入: n = 1, k = 1
 * 输出: 1
 *
 * 提示:
 * 1 <= k <= n <= 109
 * 通过次数 29,847 提交次数 72,501
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KThSmallestInLexicographicalOrder {

    public static void main(String[] args) {
        KThSmallestInLexicographicalOrder k = new KThSmallestInLexicographicalOrder();
        System.out.println(k.findKthNumber(13, 2));
        System.out.println(k.findKthNumber(1, 1));
    }

    public int findKthNumber(int n, int k) {
        // 字典序从 1 开始
        int curr = 1;
        k--;
        // k = 0 结束循环
        while (k > 0) {
            // 查找 curr 下
            int steps = getSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    private int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
