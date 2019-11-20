package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/20 12:09
 * @description 229.求众数 II
 *
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: [3]
 *
 * 示例 2:
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class MajorityElementII {

    public static void main(String[] args) {
        MajorityElementII m = new MajorityElementII();
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(m.majorityElement(nums1));
        System.out.println(m.majorityElement(nums2));
    }

    /**
     * 多人投票
     *
     * @param nums
     * @return
     */
    private List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;

        for (int num : nums) {
            if (num == candidateA) {
                countA++;
                continue;
            }
            if (num == candidateB) {
                countB++;
                continue;
            }

            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }

            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }
            countA--;
            countB--;
        }

        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == candidateA) {
                countA++;
            } else if (num == candidateB) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            result.add(candidateA);
        }
        if (countB > nums.length / 3) {
            result.add(candidateB);
        }
        return result;
    }
}
