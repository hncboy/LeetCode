package com.hncboy;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hncboy
 * @date 2019/10/9 8:46
 * @description 384.打乱数组
 *
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class ShuffleAnArray {

    private int[] normal;
    private int[] operate;
    private Random rand = new Random();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        ShuffleAnArray saa = new ShuffleAnArray(nums);
        System.out.println(Arrays.toString(saa.shuffle()));
        System.out.println(Arrays.toString(saa.reset()));
    }

    private ShuffleAnArray(int[] nums) {
        operate = nums;
        normal = nums.clone();
    }

    private int[] reset() {
        operate = normal;
        normal = normal.clone();
        return normal;
    }

    private int[] shuffle() {
        for (int i = 0; i < operate.length; i++) {
            swap(i, randRange(i, operate.length));
        }
        return operate;
    }

    /**
     * 获取两个数之间的随机数
     *
     * @param min
     * @param max
     * @return
     */
    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    /**
     * 交换数组中的两个数位置
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp = operate[i];
        operate[i] = operate[j];
        operate[j] = temp;
    }
}
