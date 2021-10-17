package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/10/10 10:18
 * @description 2032.至少在两个数组中出现的值
 * 
 * 你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 不同 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 *
 * 示例 1：
 * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 *
 * 示例 2：
 * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * 输出：[2,3,1]
 * 解释：至少在两个数组中出现的所有值为：
 * - 2 ，在数组 nums2 和 nums3 中出现过。
 * - 3 ，在数组 nums1 和 nums2 中出现过。
 * - 1 ，在数组 nums1 和 nums3 中出现过。
 *
 * 示例 3：
 * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * 输出：[]
 * 解释：不存在至少在两个数组中出现的值。
 * 
 * 提示：
 * 1 <= nums1.length, nums2.length, nums3.length <= 100
 * 1 <= nums1[i], nums2[j], nums3[k] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-out-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoOutOfThree {

    public static void main(String[] args) {
        TwoOutOfThree t = new TwoOutOfThree();
        System.out.println(t.twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3}));
        System.out.println(t.twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2}));
        System.out.println(t.twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5}));
    }

    private List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums1.length || i < nums2.length || i < nums3.length; i++) {
            if (i < nums1.length) {
                map.computeIfAbsent(nums1[i], t -> new HashSet<>()).add(1);
            }
            if (i < nums2.length) {
                map.computeIfAbsent(nums2[i], t -> new HashSet<>()).add(2);
            }
            if (i < nums3.length) {
                map.computeIfAbsent(nums3[i], t -> new HashSet<>()).add(3);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
