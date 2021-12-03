package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/3 8:52
 * @description 1005.K 次取反后最大化的数组和
 * 
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 *
 * 示例 2：
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 *
 * 示例 3：
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 *
 * 通过次数 32,348 提交次数 61,027
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximizeSumOfArrayAfterKNegations {

    public static void main(String[] args) {
        MaximizeSumOfArrayAfterKNegations m = new MaximizeSumOfArrayAfterKNegations();
        System.out.println(m.largestSumAfterKNegations(new int[]{2, 3, 1, -5, -4}, 3) == 13);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] counts = new int[210];
        // 统计所有数字的数量
        for (int num : nums) {
            counts[num + 100]++;
        }

        // 遍历下标 [0,100]，也就是负数的数字
        for (int i = -100; i < 0 && k > 0; i++) {
            // 如果对应下标对应的数字数量不为零，则取反
            while (counts[i + 100] != 0 && k-- > 0) {
                counts[i + 100]--;
                counts[-i + 100]++;
            }
        }

        // k>0 表示 k 大于负数的个数，且 k 是奇数
        if (counts[100] == 0 && k > 0 && k % 2 != 0) {
            int val = 1;
            while (counts[val + 100] == 0) {
                val++;
            }
            counts[val + 100]--;
            counts[-val + 100]++;
        }

        // 求和
        int result = 0;
        for (int i = -100; i <= 100; i++) {
            result += i * counts[i + 100];
        }
        return result;
    }
}
