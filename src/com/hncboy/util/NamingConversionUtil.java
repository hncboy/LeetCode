package com.hncboy.util;

/**
 * @author hncboy
 * @date 2019/12/8 12:16
 * @description 命名转换
 * <p>
 * 类的命名时根据题目的英文名字来取的
 * 因为题目都是通过横杠连接，用一个工具类将题目转为驼峰命名
 */
public class NamingConversionUtil {

    /**
     * 横杠转大驼峰
     *
     * @param str
     * @return
     */
    private static String lineToHump(String str) {
        String[] words = str.split("-");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1).toLowerCase());
        }
        return sb.toString();
    }

    /**
     * 通过url获取题目的横杠命名
     *
     * @param str
     * @return
     */
    private static String getUrlLine(String str) {
        String[] words = str.split("/");
        return words[4];
    }

    public static void main(String[] args) {
        System.out.println(lineToHump(getUrlLine("https://leetcode-cn.com/problems/binary-number-with-alternating-bits/")));
    }
}
