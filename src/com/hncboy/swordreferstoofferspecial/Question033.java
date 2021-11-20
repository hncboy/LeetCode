package com.hncboy.swordreferstoofferspecial;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/11/20 17:13
 * @description 剑指 Offer II 033.变位词组
 * 
 * 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 *
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *  
 * 注意：本题与主站 49 题 {@link com.hncboy.GroupAnagrams} 相同： https://leetcode-cn.com/problems/group-anagrams/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sfvd7V
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question033 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // 遍历所有字符串
        for (String str : strs) {
            // 对字符串的所有字符进行排序
            char[] array = str.toCharArray();
            Arrays.sort(array);

            // 将排序后的字符数组转为字符串存入 map
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
