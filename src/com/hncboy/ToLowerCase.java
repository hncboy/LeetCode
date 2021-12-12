package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/12 13:18
 * @description 709.转换成小写字母
 * 
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 *
 * 示例 1：
 * 输入：s = "Hello"
 * 输出："hello"
 *
 * 示例 2：
 * 输入：s = "here"
 * 输出："here"
 *
 * 示例 3：
 * 输入：s = "LOVELY"
 * 输出："lovely"
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 由 ASCII 字符集中的可打印字符组成
 * 通过次数 84,191 提交次数 109,746
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ToLowerCase {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        int diff = 'a' - 'A';
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch |= diff;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
