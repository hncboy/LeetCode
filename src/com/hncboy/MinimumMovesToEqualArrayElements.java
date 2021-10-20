package com.hncboy;

/**
 * @author hncboy
 * @date 2021/10/20 8:11
 * @description 453.最小操作次数使数组元素相等
 *
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 * 提示：
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int sum = 0;
        // 求和并获取数组中最小数字
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        return sum - min * n;
    }
}
