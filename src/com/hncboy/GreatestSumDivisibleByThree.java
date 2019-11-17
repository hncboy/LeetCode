package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/17 14:11
 * @description 5265.可被三整除的最大和
 *
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 * 示例 1：
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 *
 * 示例 2：
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 *
 * 示例 3：
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *
 * 提示：
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */
public class GreatestSumDivisibleByThree {

    public static void main(String[] args) {
        GreatestSumDivisibleByThree g = new GreatestSumDivisibleByThree();
        int[] nums1 = {3, 6, 5, 1, 8};
        int[] nums2 = {4};
        int[] nums3 = {1, 2, 3, 4, 4};
        System.out.println(g.maxSumDivThree(nums1));
        System.out.println(g.maxSumDivThree(nums2));
        System.out.println(g.maxSumDivThree(nums3));
    }

    /**
     * 数学
     *
     * @param nums
     * @return
     */
    private int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        // 存放余数为 1 的两个数
        List<Integer> one = new ArrayList<>();
        // 存放余数为 2 的两个数
        List<Integer> two = new ArrayList<>();

        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1 && one.size() < 2) {
                one.add(num);
            } else if (num % 3 == 2 && two.size() < 2) {
                two.add(num);
            }
        }

        int mod = sum % 3;
        int result = 0;

        if (mod == 0) {
            return sum;
        }

        if (mod == 1) {
            // 余数为 1 时
            // 1.除去 1 个余数为 1 的数，使得满足被 3 整除
            // 2.除去 2 个余数为 2 的数，使得满足被 3 整除
            if (two.size() >= 2) {
                result = Math.max(result, sum - two.get(0) - two.get(1));
            }
            if (one.size() >= 1) {
                result = Math.max(result, sum - one.get(0));
            }
        } else if (mod == 2) {
            // 余数为 2 时
            // 1.除去 2 个余数为 1 的数，使得满足被 3 整除
            // 2.除去 1 个余数为 2 的数，使得满足被 3 整除
            if (two.size() >= 1) {
                result = Math.max(result, sum - two.get(0));
            }
            if (one.size() >= 2) {
                result = Math.max(result, sum - one.get(0) - one.get(1));
            }
        }
        return result;
    }
}
