package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/20 15:40
 * @description 442.数组中重复的数据
 * <p>
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [2,3]
 */
public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray f = new FindAllDuplicatesInAnArray();
        System.out.println(f.findDuplicates2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    private List<Integer> findDuplicates2(int[] nums) {
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

    private List<Integer> findDuplicates1(int[] nums) {
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

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
