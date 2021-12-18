package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/12/18 15:13
 * @description 剑指 Offer II 017.含有所有字符的最短字符串
 * 
 * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC" 
 * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
 *
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出：""
 * 解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。
 *
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * 注意：本题与主站 76 题 {@link com.hncboy.MinimumWindowSubstring} 相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/M1oyTv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question017 {

    public String minWindow(String s, String t) {
        // 统计字符串 t 中每个字符出现的个数
        int[] need = new int[128];
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        // 滑动窗口的左右边界
        int left = 0;
        int right = 0;

        // 最短字符串的开始和结束位置
        int startResult = 0;
        int endResult = Integer.MAX_VALUE;

        // 字符串 t 中剩余需要匹配的字符数量
        int remainMatch = t.length();

        // 右边界不能超过字符串 s 的长度
        while (right < s.length()) {
            char ch = s.charAt(right);
            // 如果当前字符是字符串 t 所需的，则 remainMatch-1
            if (need[ch] > 0) {
                remainMatch--;
            }
            //无论这个字符是否包含在t中，need[]数组中对应那个字符的计数都减少1，利用正负区分这个字符是多余的还是有用的
            need[ch]--;

            // remainMatch 为 0 表示当前窗口已经包含了字符串 t 中的所有字符
            if (remainMatch == 0) {
                // 左边界对应的字符在 need 数组中是小于 0 的，说明这个字符是多余的
                while (left < right && need[s.charAt(left)] < 0) {
                    // 将 left 位置字符的数量加回去，并将左边界往右移动
                    need[s.charAt(left++)]++;
                }

                // 如果当前的窗口比之前的最短字符串更短，则更新最短字符串的起始位置
                if (right - left < endResult - startResult) {
                    startResult = left;
                    endResult = right;
                }

                // 将 left 位置字符的数量加回去，并将左边界往右移动
                need[s.charAt(left++)]++;
                // 需要匹配的字符加 1
                remainMatch++;
            }
            // 右边界往右移
            right++;
        }
        return endResult == Integer.MAX_VALUE ? "" : s.substring(startResult, endResult + 1);
    }
}
