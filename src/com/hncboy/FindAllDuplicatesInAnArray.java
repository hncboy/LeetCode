package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/20 15:40
 * 442.数组中重复的数据
 *
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 *
 * 示例 2：
 * 输入：nums = [1,1,2]
 * 输出：[1]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[]
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 * 通过次数72,975提交次数99,431
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray f = new FindAllDuplicatesInAnArray();
        System.out.println(f.findDuplicates2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                // 遇到负数表示第二次出现
                result.add(Math.abs(nums[i]));
            } else {
                // 第一次出现的数字用负数表示
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return result;
    }

    /**
     * 鸽巢原理，又名狄利克雷抽屉原理、鸽笼原理。
     */
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 不断遍历，将对应的数字放到的对应的索引位置 索引+1=数字
            while (nums[nums[i] - 1] != nums[i]) {
                // 使用异或交换两个数字
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            // 那些没有被放到对应索引位置的数字就是出现两次的数字
            if (nums[i] - 1 != i) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    /**
     * 异或交换
     */
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}