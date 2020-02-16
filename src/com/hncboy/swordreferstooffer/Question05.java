package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/2/16 15:23
 * @description 面试题05.替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * 限制：
 * 0 <= s 的长度 <= 10000
 */
public class Question05 {

    private String replaceSpace(String s) {
        // 申请最多3倍长度
        char[] result = new char[s.length() * 3];
        int size = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result[size++] = '%';
                result[size++] = '2';
                result[size++] = '0';
            } else {
                result[size++] = c;
            }
        }
        return new String(result, 0, size);
    }
}
