package com.hncboy;

/**
 * @author hncboy
 * @date 2022/1/1 16:22
 * 540.有序数组中的单一元素
 *
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
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
 * 通过次数 43,509 提交次数 74,516
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleElementInASortedArray {

    public static void main(String[] args) {
        SingleElementInASortedArray s = new SingleElementInASortedArray();
        System.out.println(s.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}) == 2);
        System.out.println(s.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}) == 10);
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;

            // 如果 mid 是偶数，比较 nums[mid] 和 nums[mid+1] 是否相等，此时 mid^1 = mid+1
            // 如果 mid 是奇数，比较 nums[mid] 和 nums[mid-1] 是否相等，此时 mid^1 = mid-1
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
