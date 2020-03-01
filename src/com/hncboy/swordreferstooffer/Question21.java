package com.hncboy.swordreferstooffer;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2020/3/1 19:16
 * @description 面试题21.调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Question21 {

    public static void main(String[] args) {
        Question21 q = new Question21();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(q.exchange(nums)));
    }

    private int[] exchange(int[] nums) {
        int odd = 0;
        int even = nums.length - 1;
        while (odd < even) {
            // 如果发现了偶数
            if (nums[odd] % 2 == 0) {
                // 从最后的偶数位往前遍历找到奇数位
                while (even > odd && nums[even] % 2 == 0) {
                    even--;
                }
                // 交换奇数位和偶数位
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
            }
            odd++;
        }
        return nums;
    }
}
