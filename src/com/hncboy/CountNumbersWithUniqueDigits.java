package com.hncboy;

/**
 * @author hncboy
 * @date 2022/4/11 8:39
 * 357.统计各位数字都不同的数字个数
 *
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 
 * 示例 2：
 * 输入：n = 0
 * 输出：1
 *
 * 提示：
 * 0 <= n <= 8
 * 通过次数 30,970 提交次数 57,755
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 10;
        for (int i = 2, last = 9; i <= n; i++) {
            int cur = last * (10 - i + 1);
            last = cur;
            result += cur;
        }
        return result;
    }
}
