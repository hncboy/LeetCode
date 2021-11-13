package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/11/13 14:25
 * @description 剑指 Offer II 015.字符串中的所有变位词
 */
public class Question015 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] array1 = p.toCharArray();
        char[] array2 = s.toCharArray();

        // 遍历 s1 中的字符，统计每个字母的个数
        int[] needs = new int[26];
        for (char ch : array1) {
            needs[ch - 'a']++;
        }

        for (int left = 0, right = 0; right < array2.length; right++) {
            // 滑动右指针
            needs[array2[right] - 'a']--;
            // 如果需要的字母小于 0，说明此时到这个字母的字符串都不符合要求
            while (needs[array2[right] - 'a'] < 0) {
                // 将做左指针不断往右移动，补充右指针留下的坑
                needs[array2[left++] - 'a']++;
            }
            // 满足条件
            if (right - left + 1 == array1.length) {
                result.add(left);
            }
        }
        return result;
    }
}
