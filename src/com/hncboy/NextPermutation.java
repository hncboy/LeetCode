package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/2 9:33
 * @description 31.下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 2, 5, 4, 6, 5};
        int[] nums2 = new int[]{3, 2, 1};
        int[] nums3 = new int[]{1, 1, 5};
        new NextPermutation().nextPermutation(nums1);
        new NextPermutation().nextPermutation(nums2);
        new NextPermutation().nextPermutation(nums3);
    }

    private void nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                for (int j = length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        nums[i] = nums[i] ^ nums[j];
                        nums[j] = nums[i] ^ nums[j];
                        nums[i] = nums[i] ^ nums[j];
                        break;
                    }
                }
                break;
            }
            i--;
        }

        // 将 [i, nums.length] 改为单调增序列
        for (int j = 1; j <= (length - i - 1) / 2; j++) {
            int temp = nums[j + i];
            nums[j + i] = nums[length - j];
            nums[length - j] = temp;
        }
    }
}
