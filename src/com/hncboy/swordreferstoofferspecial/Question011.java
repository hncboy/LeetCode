package com.hncboy.swordreferstoofferspecial;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2021/11/10 10:14
 * @description 剑指 Offer II 011.0 和 1 个数相同的子数组
 * 
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 * 注意：本题与主站 525 题 {@link com.hncboy.ContiguousArray}
 * 相同： https://leetcode-cn.com/problems/contiguous-array/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/A1NYOS
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question011 {

    public int findMaxLength(int[] nums) {
        int n = nums.length;

        // 定义 sum 数组，求当前位置之前所有数字的前缀和
        // 将 0 变为 1 是为了将问题转化为求最长区间内和为 0 的子数组
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }

        int result = 0;

        // 定一个长度为 2*n+1 的 hash 数组
        // 用于统计某个前缀和出现的最小下标是多少
        int[] hash = new int[2 * n + 1];
        Arrays.fill(hash, -1);
        for (int i = 2; i <= n; i++) {
            // 如果 hash 数组中不存在该前缀和，则将该前缀和所在的位置存入 hash 数组
            if (hash[sum[i - 2] + n] == -1) {
                hash[sum[i - 2] + n] = i - 2;
            }

            if (hash[sum[i] + n] != -1) {
                result = Math.max(result, i - hash[sum[i] + n]);
            }
        }
        return result;
    }
}
