package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/21 8:25
 * @description 448.找到所有数组中消失的数字
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray f = new FindAllNumbersDisappearedInAnArray();
        System.out.println(f.findDisappearedNumbers2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    private List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                // 第一次出现的数字用负数表示
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            // 正数表示该位置的数是第二次出现，即消失的数
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * 鸽巢原理，又名狄利克雷抽屉原理、鸽笼原理。
     *
     * @param nums
     * @return
     */
    private List<Integer> findDisappearedNumbers1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - i != 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * 异或交换
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
