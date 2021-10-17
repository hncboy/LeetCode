package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/11 8:35
 * @description 剑指 Offer 53-I.在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * 注意：本题与主站 34 题 {@link com.hncboy.FindFirstAndLastPositionOfElementInSortedArray}
 * 相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question53_I {

    public static void main(String[] args) {
        Question53_I q = new Question53_I();
        System.out.println(q.search(new int[]{1}, 1));
        System.out.println(q.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(q.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

    public int search(int[] nums, int target) {
        // 分别查找 target 和 target-1 的右边界进行相减
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
