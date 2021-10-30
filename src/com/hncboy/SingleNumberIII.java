package com.hncboy;

/**
 * @author hncboy
 * @date 2021/10/30 10:32
 * @description 260.只出现一次的数字 III
 * 
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 提示：
 *
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int sum = 0;
        // 对所有元素进行异或，最终得到的结果为两个答案的异或值
        for (int num : nums) {
            sum ^= num;
        }

        int k = -1;
        // 遍历 sum 的所有二进制位
        for (int i = 31; i >= 0; i--) {
            // 如果二进制第 k 为 1 表示两答案的 第 k 位二进制不同
            if (((sum >> i) & 1) == 1) {
                k = i;
                break;
            }
        }

        int[] result = new int[2];
        // 遍历所有数，对第 k 位为 0 和 1 的元素分别求异或和
        for (int num : nums) {
            if (((num >> k) & 1) == 1) {
                result[1] ^= num;
            } else {
                result[0] ^= num;
            }
        }
        return result;
    }
}
