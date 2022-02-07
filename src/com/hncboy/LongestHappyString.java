package com.hncboy;

import java.util.PriorityQueue;

/**
 * @author hncboy
 * @date 2022/2/7 20:20
 * 1405.最长快乐字符串
 *
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 * 示例 1：
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 *
 * 示例 2：
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 *
 * 示例 3：
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 *
 * 提示：
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 * 通过次数 18,898 提交次数 30,790
 */
public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) {
            queue.add(new int[]{0, a});
        }
        if (b > 0) {
            queue.add(new int[]{1, b});
        }
        if (c > 0) {
            queue.add(new int[]{2, c});
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) - 'a' == curr[0] && sb.charAt(n - 2) - 'a' == curr[0]) {
                if (queue.isEmpty()) {
                    break;
                }
                int[] next = queue.poll();
                sb.append((char) (next[0] + 'a'));
                if (--next[1] != 0) {
                    queue.add(next);
                }
                queue.add(curr);
            } else {
                sb.append((char) (curr[0] + 'a'));
                if (--curr[1] != 0) {
                    queue.add(curr);

                }
            }
        }
        return sb.toString();
    }
}