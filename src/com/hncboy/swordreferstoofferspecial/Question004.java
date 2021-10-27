package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/10/27 9:06
 * @description 剑指 Offer II 004.只出现一次的数字
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
