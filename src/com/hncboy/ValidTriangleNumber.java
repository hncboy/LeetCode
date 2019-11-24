package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/11/24 15:08
 * @description 611.有效三角形的个数
 *
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 *
 * 注意:
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 */
public class ValidTriangleNumber {

    public static void main(String[] args) {
        ValidTriangleNumber v = new ValidTriangleNumber();
        System.out.println(v.triangleNumber(new int[]{2, 2, 3, 4}));
    }

    private int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i >= 2; --i) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    // 说明 nums[left + 1] + nums[right] > nums[i]
                    // 说明 nums[left + 2] + nums[right] > nums[i]
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
