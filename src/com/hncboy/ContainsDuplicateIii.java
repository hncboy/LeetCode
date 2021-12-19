package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2021/12/19 14:58
 * @description 220.存在重复元素 III
 * 
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 *
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *  
 * 提示：
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 * 通过次数 68,201 提交次数 237,754
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsDuplicateIii {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();
        // 桶的大小
        long size = (long) t + 1;

        // 遍历所有数字
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], size);
            // 如果属于同一个桶，则符合条件
            if (map.containsKey(id)) {
                return true;
            }
            // 如果属于相邻的桶，则计算元素差是否小于 t
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < size) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < size) {
                return true;
            }
            map.put(id, (long) nums[i]);

            // 下标差距超过 k 了，则移除 nums[i - k] 对应的桶
            if (i >= k) {
                map.remove(getId(nums[i - k], size));
            }
        }
        return false;
    }

    public long getId(long num, long size) {
        // 当两数的差值不超过 size 时，必然属于一个桶
        if (num >= 0) {
            return num / size;
        }
        // 处理负数分桶的情况，先 +1 使得负数趋于 0
        return (num + 1) / size - 1;
    }
}
