package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/12/17 10:21
 * @description 1002.查找常用字符
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        FindCommonCharacters f = new FindCommonCharacters();
        System.out.println(f.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(f.commonChars(new String[]{"cool", "lock", "cook"}));
    }

    public List<String> commonChars(String[] A) {
        // 存放共同出现的最少字母
        int[] nums = new int[26];
        Arrays.fill(nums, Integer.MAX_VALUE);

        for (String a : A) {
            int[] temp = new int[26];
            Arrays.fill(temp, 0);
            // 遍历当前字符串的字母
            for (char ch : a.toCharArray()) {
                temp[ch - 'a']++;
            }
            // 在已知的字母出现中取最少的
            for (int i = 0; i < 26; i++) {
                nums[i] = Math.min(nums[i], temp[i]);
            }
        }

        List<String> result = new ArrayList<>();
        // 遍历所有字母，插入 list
        for (int i = 0; i < 26; i++) {
            while (nums[i]-- > 0) {
                result.add(String.valueOf((char)(i + 'a')));
            }
        }

        return result;
    }
}
