package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/23 20:29
 * @description 565.数组嵌套
 *
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。
 * 找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]...
 * 以此类推，不断添加直到S出现重复的元素。
 *
 * 示例 1:
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * 注意:
 * N是[1, 20,000]之间的整数。
 * A中不含有重复的元素。
 * A中的元素大小在[0, N-1]之间。
 */
public class ArrayNesting {

    public static void main(String[] args) {
        ArrayNesting a = new ArrayNesting();
        System.out.println(a.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
        System.out.println(a.arrayNesting(new int[]{0, 1, 2}));
        System.out.println(a.arrayNesting(new int[]{0, 2, 1}));
    }

    private int arrayNesting(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            // 同一循环上任意一个下标得出的次数都一样
            if (nums[i] != -1) {
                int start = nums[i];
                int count = 0;
                while (nums[start] != -1) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = -1;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
