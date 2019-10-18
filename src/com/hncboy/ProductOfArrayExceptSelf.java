package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/10/18 8:47
 * @description 238.除自身以外数组的乘积
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？
 * （ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(p.productExceptSelf(nums)));
    }

    private int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        int result = 1;

        // 存储每个数对应左边数的乘积
        for (int i = 0; i < length; i++) {
            output[i] = result;
            result *= nums[i];
        }

        result = 1;
        // 在上一步基础上，存储每个数对应右边数的乘积
        for (int i = length - 1; i >= 0; i--) {
            output[i] *= result;
            result *= nums[i];
        }

        return output;
    }
}
