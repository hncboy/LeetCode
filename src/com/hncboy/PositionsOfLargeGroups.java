package com.hncboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/12/2 13:19
 * @description 830.较大分组的位置
 *
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * 最终结果按照字典顺序输出。
 *
 * 示例 1:
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 *
 * 示例 2:
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 *
 * 示例 3:
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 */
public class PositionsOfLargeGroups {

    public static void main(String[] args) {
        PositionsOfLargeGroups p = new PositionsOfLargeGroups();
        System.out.println(p.largeGroupPositions("abbxxxxzzy"));
        System.out.println(p.largeGroupPositions("abc"));
        System.out.println(p.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(p.largeGroupPositions("aaa"));
    }

    private List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1, start = 0, end = 0; i <= S.length(); i++) {
            if (i == S.length() || S.charAt(i) != S.charAt(i - 1)) {
                if (end - start >= 2) {
                    result.add(Arrays.asList(start, end));
                }
                start = i;
            }
            end = i;
        }
        return result;
    }
}
