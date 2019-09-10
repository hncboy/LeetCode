package com.hncboy;

import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/9/10 20:12
 * @description 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        sortColors2(nums);
    }

    private static void sortColors2(int[] nums) {
        int length = nums.length;
        int i = 0;
        int zeroIndex = 0;
        int twoIndex = length - 1;
        // 遍历所有数字，0 移动到头部，2 移动到尾部，1 不做操作
        while (i <= twoIndex) {
            // 当该数字为 0 的时候，交换 i 与 zeroIndex 下标所在的数
            if (nums[i] == 0) {
                if (nums[i] != nums[zeroIndex]) {
                    nums[i] = nums[i] ^ nums[zeroIndex];
                    nums[zeroIndex] = nums[i] ^ nums[zeroIndex];
                    nums[i] = nums[i] ^ nums[zeroIndex];
                }
                zeroIndex++;
                i++;
            } else if (nums[i] == 2) {
                // 当该数字为 2 的时候，交换 i 与 twoIndex 下标所在的数
                if (nums[i] != nums[twoIndex]) {
                    nums[i] = nums[i] ^ nums[twoIndex];
                    nums[twoIndex] = nums[i] ^ nums[twoIndex];
                    nums[i] = nums[i] ^ nums[twoIndex];
                }
                twoIndex--;
            } else {
                i++;
            }
        }
    }

    private static void sortColors1(int[] nums) {
        int[] count = new int[3];
        // 计算出每种数字出现的次数
        for (int num : nums) {
            count[num]++;
        }
        int length = nums.length;
        // 按次数重新对 nums 数组赋值
        for (int i = 0; i < length; i++) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < count[0] + count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
