package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/1/9 13:51
 * 剑指 Offer II 080.含有 k 个元素的组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例 1:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 示例 2:
 * 输入: n = 1, k = 1
 * 输出: [[1]]
 *  
 * 提示:
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * 注意：本题与主站 77 题 {@link com.hncboy.Combinations} 相同： https://leetcode-cn.com/problems/combinations/
 * 通过次数 4,906 提交次数 6,010
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uUsW3B
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question080 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(n, k, 1, result, new ArrayList<>());
        return result;
    }

    private void backTrack(int n, int k, int start, List<List<Integer>> result, List<Integer> sub) {
        if (sub.size() == k) {
            result.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i <= n - (k - sub.size()) + 1; i++) {
            sub.add(i);
            backTrack(n, k, i + 1, result, sub);
            sub.remove(sub.size() - 1);
        }
    }
}
