package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/12/7 8:54
 * 47.全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * 通过次数 247,488 提交次数 385,862
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        System.out.println(p.permuteUnique(new int[]{1, 1, 2}));
    }

    private List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序方便剪枝
        Arrays.sort(nums);
        backTrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    /**
     * 回溯
     *
     * @param nums
     * @param result
     * @param sub
     * @param visited
     */
    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> sub, boolean[] visited) {
        if (sub.size() == nums.length) {
            result.add(new ArrayList<>(sub));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                // 剪枝，当前的数与上一个数相等，并且上一个数未使用，会导致重复的情况
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                sub.add(nums[i]);
                backTrack(nums, result, sub, visited);
                sub.remove(sub.size() - 1);
                visited[i] = false;
            }
        }
    }
}
