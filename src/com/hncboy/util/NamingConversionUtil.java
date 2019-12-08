package com.hncboy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static String lineToHump(String str) {
        String[] words = str.split("-");
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1).toLowerCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(lineToHump("subtract-the-product-and-sum-of-digits-of-an-integer"));
    }
}
