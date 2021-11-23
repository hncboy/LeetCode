package com.hncboy;

/**
 * @author hncboy
 * @date 2021/11/23 8:54
 * @description 859.亲密字符串
 * 
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 * 示例 1：
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 *
 * 示例 2：
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 *
 * 示例 3：
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 *
 * 示例 4：
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * 输出：true
 *
 * 提示：
 * 1 <= s.length, goal.length <= 2 * 104
 * s 和 goal 由小写英文字母组成
 *
 * 通过次数 31,638 提交次数 101,581
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a';
            int b = goal.charAt(i) - 'a';
            // 统计各个字母的数量
            count1[a]++;
            count2[b]++;
            // 统计不相等的字符数量
            if (a != b) {
                sum++;
            }
        }

        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            // 如果字母数量不一样，则返回 false
            if (count1[i] != count2[i]) {
                return false;
            }

            if (count1[i] > 1) {
                ok = true;
            }
        }

        // 不相等的字符串数量为 2 || 两个字符串相等并且存在一个字母的数量超过 2
        return sum == 2 || (sum == 0 && ok);
    }
}
