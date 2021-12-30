package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/22 10:10
 * 1296.划分数组为连续数字的集合
 * 
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 *
 * 示例 3：
 * 输入：nums = [3,3,2,2,1,1], k = 3
 * 输出：true
 *
 * 示例 4：
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 *  
 * 提示：
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 109
 *
 * 注意：此题目与 846  {@link HandOfStraights} 重复：https://leetcode-cn.com/problems/hand-of-straights/
 * 通过次数 8,285 提交次数 18,072
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

    public static void main(String[] args) {
        DivideArrayInSetsOfKConsecutiveNumbers d = new DivideArrayInSetsOfKConsecutiveNumbers();
        System.out.println(d.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
        System.out.println(d.isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        System.out.println(d.isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3));
        System.out.println(d.isPossibleDivide(new int[]{1, 2, 3, 4}, 3));
        System.out.println(d.isPossibleDivide(new int[]{1}, 3));
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        // 数量不够分组直接返回
        if (nums.length % k > 0) {
            return false;
        }

        Arrays.sort(nums);
        int[] buckets = new int[k];
        for (int i = 0; i < nums.length; i++) {
            // 判断是否是连续的牌
            if (i % k != 0 && nums[i] - nums[i - 1] > 1) {
                return false;
            }
            // 如果最后是三组顺子的话，则每个桶中牌的数量会是一致的
            buckets[nums[i] % k]++;
        }

        // 判断每个桶牌的数量是否相等
        for (int count : buckets) {
            if (count != buckets[0]) {
                return false;
            }
        }
        return true;
    }
}
