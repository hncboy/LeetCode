package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/14 9:36
 * @description 287.寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        int[] nums1 = new int[]{1, 3, 4, 2, 2};
        int[] nums2 = new int[]{3, 1, 3, 4, 2};
        System.out.println(f.findDuplicate(nums1));
        System.out.println(f.findDuplicate(nums2));
    }

    private int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            // 表示形成了一个环
            if (slow == fast) {
                fast = 0;
                // 在环里寻找重复的元素
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
