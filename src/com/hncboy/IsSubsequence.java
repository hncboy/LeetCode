package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/22 13:00
 * @description 392.判断子序列
 */
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence i = new IsSubsequence();
        System.out.println(i.isSubsequence("abc", "ahbgdc"));
        System.out.println(i.isSubsequence("axc", "ahbgdc"));
    }

    private boolean isSubsequence(String s, String t) {
        int count = 0;
        for (char ch : t.toCharArray()) {
            if (count == s.length()) {
                return true;
            }
            if (s.charAt(count) == ch) {
                count++;
            }
        }
        return count == s.length();
    }
}
