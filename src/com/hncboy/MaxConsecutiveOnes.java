package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/21 10:48
 * @description 485.最大连续1的个数
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 *
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        MaxConsecutiveOnes m = new MaxConsecutiveOnes();
        System.out.println(m.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    private int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                result = Math.max(result, count);
                continue;
            }
            count = 0;
        }
        return result;
    }
}
