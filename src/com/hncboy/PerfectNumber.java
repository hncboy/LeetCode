package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/31 9:05
 * 507.完美数
 * 
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 *
 * 示例 1：
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 *
 * 示例 2：
 * 输入：num = 6
 * 输出：true
 *
 * 示例 3：
 * 输入：num = 496
 * 输出：true
 *
 * 示例 4：
 * 输入：num = 8128
 * 输出：true
 *
 * 示例 5：
 * 输入：num = 2
 * 输出：false
 *
 * 提示：
 * 1 <= num <= 108
 * 通过次数 36,968 提交次数 84,680
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int result = 1;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                result += i + num / i;
            }
        }
        return result == num;
    }
}
