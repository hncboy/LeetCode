package com.hncboy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2021/12/29 9:09
 * 1995.统计特殊四元组
 * 
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 *
 * 示例 1：
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 *
 * 示例 2：
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 *
 * 示例 3：
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 *
 * 提示：
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 * 通过次数 10,069 提交次数 16,513
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-special-quadruplets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSpecialQuadruplets {

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int result = 0;
        Map<Integer, Integer> count = new HashMap<>();

        // 逆序枚举 b
        for (int b = n - 3; b >= 1; b--) {
            // d 从 b+2 开始遍历，c 为 b+1
            for (int d = b + 2; d < n; d++) {
                count.put(nums[d] - nums[b + 1], count.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            // a 从 0 开始遍历到 b
            for (int a = 0; a < b; a++) {
                result += count.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return result;
    }
}
