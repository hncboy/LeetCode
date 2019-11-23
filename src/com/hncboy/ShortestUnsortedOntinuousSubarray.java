package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/23 21:12
 * @description 581.最短无序连续子数组
 * <p>
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * 说明 :
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class ShortestUnsortedOntinuousSubarray {

    public static void main(String[] args) {
        ShortestUnsortedOntinuousSubarray s = new ShortestUnsortedOntinuousSubarray();
        System.out.println(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(s.findUnsortedSubarray(new int[]{1}));
        System.out.println(s.findUnsortedSubarray(new int[]{1, 2, 3, 4, 5}));
    }

    private int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        int left = 0;
        int right = -1;

        // 从前往后遍历找最大值，从后往前遍历找最小值
        for (int i = 0; i < n; i++) {
            // 找到比最大值小的数，需要进行排序
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }

            // 找到比最小值大的数，需要进行排序
            if (min < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return right - left + 1;
    }
}
