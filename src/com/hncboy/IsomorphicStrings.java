package com.hncboy;

/**
 * @author hncboy
 * @date 2020/2/9 16:06
 * @description 205.同构字符串
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
 * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings i = new IsomorphicStrings();
        System.out.println(i.isIsomorphic("ab", "aa"));
        System.out.println(i.isIsomorphic("egg", "add"));
        System.out.println(i.isIsomorphic("foo", "bar"));
        System.out.println(i.isIsomorphic("paper", "title"));
    }

    private boolean isIsomorphic(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            // 对比 s 和 t 中相同字符串最开始出现的位置是否相同
            if(s.indexOf(chars1[i]) != t.indexOf(chars2[i])){
                return false;
            }
        }
        return true;
    }
}
