package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/9/29 8:32
 * @description 49.字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        for (String str : strs) {
            // 将 str 转为字符数组
            char[] chars = str.toCharArray();
            // 对 chars 进行排序
            Arrays.sort(chars);
            // 将 chars 转为 String
            String key = Arrays.toString(chars);
            // 若存在排序后字符数组的 key
            if (hashMap.containsKey(key)) {
                // 根据 key 获取插入的下标，lists 根据下标获取插入的list，将 str 插入 list
                lists.get(hashMap.get(key)).add(str);
            } else {
                // 不存在则新建一个 list
                List<String> list = new ArrayList<>();
                // 将 str 插入 list
                list.add(str);
                // 将 list 插入 lists
                lists.add(list);
                // 将 key 和对应 lists 中的下标插入 hashMap
                hashMap.put(key, lists.size() - 1);
            }
        }
        return lists;
    }
}
