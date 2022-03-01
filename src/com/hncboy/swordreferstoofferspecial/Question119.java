package com.hncboy.swordreferstoofferspecial;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2022/3/1 9:33
 * 剑指 Offer II 119.最长连续序列
 * 
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 提示：
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 * 注意：本题与主站 128 题 {@link com.hncboy.LongestConsecutiveSequence} 相同： https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 通过次数7,067提交次数14,354
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/WhsWhI
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question119 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : numSet) {
            // 连续的数字不用判断
            if (numSet.contains(num - 1)) {
                continue;
            }

            // 遍历从该数开始的连续序列
            int currentNum = num;
            int currentStreak = 1;
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}
