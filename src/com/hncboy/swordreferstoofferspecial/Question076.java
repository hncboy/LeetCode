package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2022/1/8 14:05
 * 剑指 Offer II 076.数组中的第 k 大的数字
 * 
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 提示：
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 *
 * 注意：本题与主站 215 题 {@link com.hncboy.KthLargestElementInAnArray}
 * 相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 通过次数 8,609 提交次数 12,626
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xx4gT2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question076 {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        // 说明序列已经排好序
        if (left == right) {
            return nums[k];
        }

        int i = left - 1;
        int j = right + 1;

        // 中间的数
        int midNum = nums[left + right >> 1];
        while (i < j) {
            // 找到左边第一个大于中值的元素
            while (nums[++i] < midNum) {
            }
            // 找到右边第一个小于中值的元素
            while (nums[--j] > midNum) {
            }
            // 交换逆序对
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        // 进行判断，k属于那段区间
        if (k <= j) {
            return quickSelect(nums, left, j, k);
        }

        return quickSelect(nums, j + 1, right, k);
    }
}
