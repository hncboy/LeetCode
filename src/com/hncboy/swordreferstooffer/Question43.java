package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/2 16:34
 * @description 剑指 Offer 43.1～n 整数中 1 出现的次数
 * {@link com.hncboy.NumberOfDigitOne}
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 *
 * 限制：
 * 1 <= n < 2^31
 * 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 题解：
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
 */
public class Question43 {

    public static void main(String[] args) {
        Question43 q = new Question43();
        System.out.println(q.countDigitOne(12) == 5);
        System.out.println(q.countDigitOne(13) == 6);
    }

    /**
     * 将 1 ~ n 的个位、十位、百位、...的 1 出现次数相加，即为 1 出现的总次数。
     *
     * @param n n
     * @return result
     */
    private int countDigitOne(int n) {
        int result = 0;

        // 位因子
        int digit = 1;
        // 比当前位高的数字
        int high = n / 10;
        // 当前位的数字
        int current = n % 10;
        // 比当前位低的数字
        int low = 0;

        while (high != 0 || current != 0) {
            // 如果当前位的数字是 0，则 1 出现的数字只由高位 high 决定
            if (current == 0) {
                result += high * digit;
            } else if (current == 1) {
                // 如果当前位的数字是 1，此位 1 的出现次数由高位 high 和低位 low 决定
                result += high * digit + low + 1;
            } else {
                // 如果当前位的数字是 2-9，此位 1 出现的数字只由高位 high 决定
                result += (high + 1) * digit;
            }

            // 低位加上左边的一位，加上当前位的数字*位因子
            low += current * digit;
            // 当前位的数字往左移一位
            current = high % 10;
            // 高位减去右边的一位
            high /= 10;
            // 位因子扩大 10 倍
            digit *= 10;
        }
        return result;
    }
}