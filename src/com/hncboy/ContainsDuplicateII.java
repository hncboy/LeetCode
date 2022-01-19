package com.hncboy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2019/11/19 18:07
 * 219.存在重复元素 II
 *
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 *
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 * 通过次数 127,949 提交次数 299,982
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        ContainsDuplicateII c = new ContainsDuplicateII();
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    private boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
