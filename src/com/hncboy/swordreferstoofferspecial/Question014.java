package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/12 20:30
 * @description 剑指 Offer II 014.字符串中的变位词
 * 
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * 示例 1：
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 提示：
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * 注意：本题与主站 567 题 {@link com.hncboy.PermutationInString}
 * 相同： https://leetcode-cn.com/problems/permutation-in-string/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/MPnaiL
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question014 {

    public boolean checkInclusion(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

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
                return true;
            }
        }
        return false;
    }
}
