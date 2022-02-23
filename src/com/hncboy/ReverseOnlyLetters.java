package com.hncboy;

/**
 * @author hncboy
 * @date 2022/2/23 9:08
 * 917.仅仅反转字母
 *
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 *
 * 示例 1：
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 *
 * 示例 2：
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 *
 * 示例 3：
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * 提示
 * 1 <= s.length <= 100
 * s 仅由 ASCII 值在范围 [33, 122] 的字符组成
 * s 不含 '\"' 或 '\\'
 * 通过次数 36,603 提交次数 62,979
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char[] array = s.toCharArray();
        for (int i = 0, j = array.length - 1; i < j; ) {
            // 从左往右找到字母
            while (i < j && !Character.isLetter(array[i])) {
                i++;
            }
            // 从右往左找到字母
            while (i < j && !Character.isLetter(array[j])) {
                j--;
            }
            // 交换两个字母
            if (i < j) {
                char ch = array[i];
                array[i++] = array[j];
                array[j--] = ch;
            }
        }
        return String.valueOf(array);
    }
}
