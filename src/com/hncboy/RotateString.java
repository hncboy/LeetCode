package com.hncboy;

/**
 * @author hncboy
 * @date 2022/4/7 12:44
 * 796.旋转字符串
 * 
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 *  
 * 示例 1:
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 *
 * 提示:
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 * 通过次数 46,356 提交次数 76,721
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateString {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
