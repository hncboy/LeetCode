package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/8 9:38
 * @description 45.跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 */
public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 2, 1, 1};
        System.out.println(new JumpGameII().jump(nums));
    }

    private int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 选出能跳的范围内跳的最远的位置
            maxPosition = Math.max(maxPosition, nums[i] + i);
            // 到达边界时更新边界
            if (i == end) {
                // 能跳得到的最远位置为边界
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
