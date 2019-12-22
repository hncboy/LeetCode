package com.hncboy;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hncboy
 * @date 2019/12/22 10:10
 * @description 5292.划分数组为连续数字的集合
 *
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
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
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
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

    private boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            it = map.keySet().iterator();
            if (!it.hasNext()) {
                return true;
            }
            int key = it.next();
            for (int i = 0; i < k; i++, key++) {
                if (!map.containsKey(key)) {
                    return false;
                }
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }

        return true;
    }
}
