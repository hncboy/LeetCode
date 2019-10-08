package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/8 8:02
 * @description 283.移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
    }

    private void moveZeroes(int[] nums) {
        // 0 的数量
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 将不为 0 的数移动前面，0 移到后面
                // 将不为 0 的数与为 0 的数交换
                int temp = nums[i - count];
                nums[i - count] = nums[i];
                nums[i] = temp;
            } else {
                count++;
            }
        }
    }
}
