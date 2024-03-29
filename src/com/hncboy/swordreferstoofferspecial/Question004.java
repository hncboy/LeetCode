package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/10/27 9:06
 * @description 剑指 Offer II 004.只出现一次的数字
 * 
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 *  
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *  
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 注意：本题与主站 137 题 {@link com.hncboy.SingleNumberII} 相同：https://leetcode-cn.com/problems/single-number-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/WGki4K
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question004 {

    public static void main(String[] args) {
        Question004 q = new Question004();
        System.out.println(q.singleNumber(new int[]{2, 2, 3, 2}));
    }

    public int singleNumber(int[] nums) {
        // 用两位表示 3 种状态
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
