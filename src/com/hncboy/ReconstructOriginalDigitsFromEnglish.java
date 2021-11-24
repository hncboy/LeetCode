package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2021/11/24 8:56
 * @description 423.从英文中重建数字
 * 
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 * 示例 1：
 * 输入：s = "owoztneoer"
 * 输出："012"
 *
 * 示例 2：
 * 输入：s = "fviefuro"
 * 输出："45"
 *
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 *
 * 通过次数 11,233 提交次数 19,118
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReconstructOriginalDigitsFromEnglish {

    public static void main(String[] args) {
        ReconstructOriginalDigitsFromEnglish r = new ReconstructOriginalDigitsFromEnglish();
        System.out.println(r.originalDigits("owoztneoer").equals("012"));
        System.out.println(r.originalDigits("fviefuro").equals("45"));
    }

    public String originalDigits(String s) {
        Map<Character, Integer> characterMap = new HashMap<>();
        // 统计各个字母出现的数量
        for (char ch : s.toCharArray()) {
            characterMap.put(ch, characterMap.getOrDefault(ch, 0) + 1);
        }

        int[] count = new int[10];
        // 先统计在各个数字英文单词中出现一次的字母
        count[0] = characterMap.getOrDefault('z', 0);
        count[2] = characterMap.getOrDefault('w', 0);
        count[4] = characterMap.getOrDefault('u', 0);
        count[6] = characterMap.getOrDefault('x', 0);
        count[8] = characterMap.getOrDefault('g', 0);

        // 再统计出现两次的字母
        count[3] = characterMap.getOrDefault('h', 0) - count[8];
        count[5] = characterMap.getOrDefault('f', 0) - count[4];
        count[7] = characterMap.getOrDefault('s', 0) - count[6];

        // 根据其他字母的数量进行统计
        count[1] = characterMap.getOrDefault('o', 0) - count[0] - count[2] - count[4];
        count[9] = characterMap.getOrDefault('i', 0) - count[5] - count[6] - count[8];

        StringBuilder result = new StringBuilder();
        // 遍历所有数字
        for (int i = 0; i < 10; i++) {
            // 统计各个数字的数量
            for (int j = 0; j < count[i]; j++) {
                result.append(i);
            }
        }
        return result.toString();
    }
}