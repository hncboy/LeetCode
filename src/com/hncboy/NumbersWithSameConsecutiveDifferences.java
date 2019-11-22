package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/22 11:59
 * @description 967.连续差相同的数字
 *
 * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
 * 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。
 * 例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
 * 你可以按任何顺序返回答案。
 *
 * 示例 1：
 * 输入：N = 3, K = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 *
 * 示例 2：
 * 输入：N = 2, K = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *
 * 提示：
 * 1 <= N <= 9
 * 0 <= K <= 9
 *y 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumbersWithSameConsecutiveDifferences {

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences n = new NumbersWithSameConsecutiveDifferences();
        System.out.println(Arrays.toString(n.numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(n.numsSameConsecDiff(2, 1)));
        System.out.println(Arrays.toString(n.numsSameConsecDiff(2, 0)));
    }

    private int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            helper(list, i, 0, K, N, 0);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * @param list
     * @param start  开头的数字
     * @param count  数字的个数
     * @param K      连续的差值
     * @param N      需要数字的个数
     * @param target
     */
    private void helper(List<Integer> list, int start, int count, int K, int N, int target) {
        target += start;
        if (++count == N) {
            list.add(target);
            return;
        }
        if (start - K >= 0) {
            helper(list, start - K, count, K, N, target * 10);
        }
        if (start + K < 10 && K != 0) {
            helper(list, start + K, count, K, N, target * 10);
        }
    }
}
