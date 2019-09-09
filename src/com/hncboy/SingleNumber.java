package com.hncboy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hncboy
 * @date 2019/9/9 17:09
 * @description 136.只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber2(nums));
    }

    private static int singleNumber2(int[] nums) {
        /*
        1.交换律：a ^ b ^ c <=> a ^ c ^ b
        2.任何数于0异或为任何数 0 ^ n => n
        3.相同的数异或为0: n ^ n => 0
         */
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    private static int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
}
