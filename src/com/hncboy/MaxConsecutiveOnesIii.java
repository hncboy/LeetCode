package com.hncboy;

/**
 * @author hncboy
 * @date 2022/3/29 8:57
 * 1004.最大连续1的个数 III
 * 
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 * 示例 1：
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 * 通过次数 79,751 提交次数 133,971
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxConsecutiveOnesIii {

    public static void main(String[] args) {
        MaxConsecutiveOnesIii m = new MaxConsecutiveOnesIii();
        System.out.println(m.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(m.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1,}, 3));
    }

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += 1 - nums[right];
            while (sum > k) {
                sum -= 1 - nums[left++];
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
