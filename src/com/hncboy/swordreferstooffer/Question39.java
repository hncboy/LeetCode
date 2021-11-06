package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/9/30 13:31
 * @description 剑指 Offer 39.数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 * 注意：本题与主站 169 题 {@link com.hncboy.MajorityElement}
 * 相同：https://leetcode-cn.com/problems/majority-element/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question39 {

    public int majorityElement(int[] nums) {
        int votes  = 0;
        int candidate = 0;

        // 根据众数出现的次数大于 n/2 的特性
        // 当选的数不是众数的时候，会被众数减到 0
        for (int num : nums) {
            if (votes  == 0) {
                candidate = num;
            }
            votes  += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
