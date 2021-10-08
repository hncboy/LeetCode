package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/8 8:37
 * @description 剑指 Offer 56-II.数组中数字出现的次数 II
 * 
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question56_II {

    public int singleNumber(int[] nums) {
        // 定义长度为 32 的数组
        int[] counts = new int[32];

        for (int num : nums) {
            // 统计 int 整数 32 位中各个二进制位出现的次数
            for (int i = 0; i < 32; i++) {
                // 对每位进行按位与运行
                counts[i] += num & 1;
                // num 无符号右移
                num >>>= 1;
            }
        }

        int result = 0;
        // 遍历所有数字各个二进制位出现的次数
        for (int i = 0; i < 32; i++) {
            // 左移一位
            result <<= 1;
            // 将对应二进制位与 3 取余，可以得到只出现一次数字二进制中第 31-i 位的值
            // 将二进制位与 result 进行按位或运算，可得到对应的十进制数值
            result |= counts[31 - i] % 3;
        }
        return result;
    }
}
