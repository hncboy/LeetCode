package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/10 20:56
 * @description 55.跳跃游戏
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 3};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        // i = length - 2 的时候表示倒数第二个数与最后一个数的距离
        // i < length - 2 的时候，表示当前数与下一个能到达最后一个数的距离
        // distance = 1 表示当前数能到达最后一行，不能的话往前移动一位
        int distance = 1;
        int length = nums.length;
        // 从后前遍历数组
        for (int i = length - 2; i >= 0; i--) {
            // 如果当前数不能到达最后一个数，则增大distance
            // 否则截断后面的元素
            distance = nums[i] >= distance ? 1 : ++distance;
        }
        return distance <= 1;
    }
}
