package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/1/9 13:40
 * 剑指 Offer II 079.所有子集
 * 
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * 注意：本题与主站 78 题 {@link com.hncboy.Subsets} 相同： https://leetcode-cn.com/problems/subsets/
 * 通过次数 5,807 提交次数 6,795
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/TVdhkn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question079 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 长度为 n 的数组，都有 2^n 个子集
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // 从低位到高位逐个取二进制位，如果为 1，则将对应的该数放入集合
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            result.add(sub);
        }
        return result;
    }
}
