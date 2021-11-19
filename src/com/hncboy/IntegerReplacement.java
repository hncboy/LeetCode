package com.hncboy;

/**
 * @author hncboy
 * @date 2021/11/19 9:08
 * @description 397.整数替换
 * 
 * 给定一个正整数 n ，你可以做如下操作：
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 * 示例 1：
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 *
 * 示例 3：
 * 输入：n = 4
 * 输出：2
 *
 * 提示：
 * 1 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerReplacement {

    public int integerReplacement(int n) {
        int result = 0;
        while (n != 1) {
            // 如果 n 是偶数，则直接除 2
            if (n % 2 == 0) {
                result++;
                n /= 2;
                continue;
            }

            // n 为奇数的情况，result 直接加 2，包含了 +1 或 -1 和 /2 两个步骤
            result += 2;
            n /= 2;

            // 结果为 1 直接返回
            if (n == 1) {
                return result;
            }

            // 此时把奇数变为偶数
            if (n % 2 == 1) {
                n += 1;
            }
        }
        return result;
    }
}
