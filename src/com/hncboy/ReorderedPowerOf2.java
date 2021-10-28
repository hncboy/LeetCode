package com.hncboy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2021/10/28 8:26
 * @description 869.重新排序得到 2 的幂
 *
 * 给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入：1
 * 输出：true
 * 
 * 示例 2：
 * 输入：10
 * 输出：false
 *
 * 示例 3：
 * 输入：16
 * 输出：true
 *
 * 示例 4：
 * 输入：24
 * 输出：false
 *
 * 示例 5：
 * 输入：46
 * 输出：true
 *
 * 提示：
 * 1 <= N <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int n) {
        Set<String> powerOf2Digits = new HashSet<>();
        // 遍历所有 2 的幂的整数
        for (int i = 1; i <= 1e9; i *= 2) {
            powerOf2Digits.add(countDigits(i));
        }
        return powerOf2Digits.contains(countDigits(n));
    }

    /**
     * 将整数 n 的每位计数统计
     *
     * @param n 2 的幂的整数
     * @return 计数后的字符串
     */
    private String countDigits(int n) {
        char[] count = new char[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        return new String(count);
    }
}
