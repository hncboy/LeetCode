package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/1/7 9:12
 * 剑指 Offer II 083.没有重复元素集合的全排列
 * 
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * 注意：本题与主站 46 题 {@link com.hncboy.Permutations} 相同：https://leetcode-cn.com/problems/permutations/
 * 通过次数 6,174 提交次数 7,168
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/VvJkup
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question083 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> subList, int[] nums, int start) {
        if (start == nums.length) {
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);

            subList.add(nums[start]);
            backTrack(result, subList, nums, start + 1);
            subList.remove(subList.size() - 1);

            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
