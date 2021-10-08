package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/8 8:21
 * @description 剑指 Offer 56-I.数组中数字出现的次数
 * 
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * 限制：
 * 2 <= nums.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question56_I {

    public int[] singleNumbers(int[] nums) {
        // 出现一次的数字 x
        int x = 0;
        // 出现一次的数字 y
        int y = 0;
        // x 和 y 异或的结果 result
        int result = 0;
        int divide = 1;

        // 1.遍历所有数字进行异或运行，则 result 为最终 x 和 y 异或的结果
        for (int num : nums) {
            result ^= num;
        }

        // 2.将异或结果不断左移，直接找到第一位不为 0 的数，也就是 x 和 y 在二进制中不相同的第一位数
        while ((result & divide) == 0) {
            divide <<= 1;
        }

        // 3.遍历所有数字进行分组，按 x 和 y 不相同的一个 bit 位进行分组，分别进行异或运算
        for (int num : nums) {
            if ((num & divide) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // 5.返回只出现一次的两个数字
        return new int[]{x, y};
    }
}
