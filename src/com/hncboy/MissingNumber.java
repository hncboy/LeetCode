package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/14 9:47
 * @description 268.缺失数字
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int[] nums1 = new int[]{3, 0, 1};
        int[] nums2 = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(m.missingNumber2(nums1));
        System.out.println(m.missingNumber2(nums2));
    }

    private int missingNumber2(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; ++i){
            result ^= nums[i];
            result ^= i;
        }
        return result;
    }

    private int missingNumber1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i - nums[i];
        }
        return result + nums.length;
    }
}
