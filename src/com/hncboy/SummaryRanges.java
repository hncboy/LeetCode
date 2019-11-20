package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/20 12:39
 * @description 228.汇总区间
 *
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 *
 * 示例 2:
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 */
public class SummaryRanges {

    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(s.summaryRanges(nums1));
        System.out.println(s.summaryRanges(nums2));
    }

    private List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0, last = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
                continue;
            }
            if (i == last) {
                result.add(nums[last] + "");
            } else {
                result.add(nums[last] + "->" + nums[i]);
            }
            last = i + 1;
        }
        return result;
    }
}
