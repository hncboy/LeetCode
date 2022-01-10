package com.hncboy;

/**
 * @author hncboy
 * @date 2022/1/10 8:43
 * 306.累加数
 * 
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1：
 * 输入："112358"
 * 输出：true 
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * 示例 2：
 * 输入："199100199"
 * 输出：true 
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 * 提示：
 * 1 <= num.length <= 35
 * num 仅由数字（0 - 9）组成
 * 进阶：你计划如何处理由过大的整数输入导致的溢出?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AdditiveNumber {

    public static void main(String[] args) {
        AdditiveNumber a = new AdditiveNumber();
        System.out.println(a.isAdditiveNumber("199100199"));
    }

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        // 穷举第一个数字和第二个数字的所有可能
        for (int secondStart = 1; secondStart < n - 1; secondStart++) {
            // 如果第 0 个数是 0，则第二个数的下标只能从 1 开始
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }

            // 遍历第二个数末尾的数字
            for (int secondEnd = secondStart; secondEnd < n - 1; secondEnd++) {
                // 如果第二个数从 0 开始，则第二个数必须是 0
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                    break;
                }

                // 验证是否符合条件
                if (valid(secondStart, secondEnd, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean valid(int secondStart, int secondEnd, String num) {
        int n = num.length();
        // 得到第一个数
        int firstStart = 0;
        int firstEnd = secondStart - 1;
        while (secondEnd <= n - 1) {
            // 通过第一个数和第二个数得到第三个数
            String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            // 判断第三个数的长度是否超过限制
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            // 继续循环
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    private String stringAdd(String num, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        int carry = 0;
        int curr;
        StringBuilder third = new StringBuilder();
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            curr = carry;
            if (firstEnd >= firstStart) {
                curr += num.charAt(firstEnd) - '0';
                firstEnd--;
            }
            if (secondEnd >= secondStart) {
                curr += num.charAt(secondEnd) - '0';
                secondEnd--;
            }
            carry = curr / 10;
            curr %= 10;
            third.append((char) (curr + '0'));
        }
        third.reverse();
        return third.toString();
    }
}
