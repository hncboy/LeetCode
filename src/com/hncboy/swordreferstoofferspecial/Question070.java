package com.hncboy.swordreferstoofferspecial;

import com.hncboy.SingleElementInASortedArray;

/**
 * @author hncboy
 * @date 2022/1/1 16:19
 * 剑指 Offer II 070.排序数组中只出现一次的数字
 *
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 *
 * 示例 1:
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * 提示:
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 *
 * 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？
 * 注意：本题与主站 540 题 {@link SingleElementInASortedArray} 相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/skFtm2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question070 {

    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 确保 mid 是偶数
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int singleNonDuplicate1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 判断出现单次的数字在哪一边
            boolean halvesAreEven = (right - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
