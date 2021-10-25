package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/10/25 9:14
 * @description 剑指 Offer II 007.数组中和为 0 的三个数
 * 
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 注意：本题与主站 15 题 {@link com.hncboy.ThreeSum} 相同：https://leetcode-cn.com/problems/3sum/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1fGaJU
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question007 {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // 开始遍历
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前的数大于 0，则后面的数肯定都大于 0，不存在相加等于 0 的情况
            if (nums[i] > 0) {
                break;
            }

            // 如果当前数和上一个数一样，则答案重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 获取当前可选区间的左右指针
            int left = i + 1;
            int right = nums.length - 1;
            // 从左往右遍历
            while (left < right) {
                // 计算三数之和
                int sum = nums[i] + nums[left] + nums[right];

                // 小于 0 的话，左指针往右移动并且去重
                if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) {
                    }
                    continue;
                }

                // 大于 0 的话，右指针往左移动并且去重
                if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]) {
                    }
                    continue;
                }

                // 此时三数之和为 0
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                // 左指针往右移动并且去重
                while (left < right && nums[left] == nums[++left]) {
                }
                // 右指针往左移动并且去重
                while (left < right && nums[right] == nums[--right]) {
                }

            }
        }
        return result;
    }
}
