package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/15 14:22
 * 1189.“气球” 的最大数量
 *
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * 示例 1：
 * 输入：text = "nlaebolko"
 * 输出：1
 *
 * 示例 2：
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 *
 * 示例 3：
 * 输入：text = "leetcode"
 * 输出：0
 *  
 * 提示：
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumNumberOfBalloons {

    public static void main(String[] args) {
        MaximumNumberOfBalloons m = new MaximumNumberOfBalloons();
        System.out.println(m.maxNumberOfBalloons("nlaebolko"));
        System.out.println(m.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(m.maxNumberOfBalloons("leetcode"));
    }

    private int maxNumberOfBalloons(String text) {
        int[] letters = new int[26];
        for (char ch : text.toCharArray()) {
            letters[ch - 97]++;
        }
        letters['l' - 97] /= 2;
        letters['o' - 97] /= 2;

        int min = Integer.MAX_VALUE;
        for (char ch : "balon".toCharArray()) {
            if (letters[ch - 97] < min) {
                min = letters[ch - 97];
            }
        }

        return min;
    }
}
