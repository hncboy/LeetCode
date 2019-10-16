package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/16 9:08
 * @description 179.最大数
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] nums1 = new int[]{10, 2};
        int[] nums2 = new int[]{9, 5, 34, 3, 30};
        System.out.println(ln.largestNumber(nums1));
        System.out.println(ln.largestNumber(nums2));
    }

    private String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        Arrays.stream(nums).forEach((num) -> list.add(String.valueOf(num)));
        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        if (list.get(0).equals("0")) {
            return "0";
        }
        list.forEach(sb::append);
        return sb.toString();
    }
}
