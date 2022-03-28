package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/15 14:44
 * 693.交替位二进制数
 *
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 *
 * 示例 3：
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 *
 * 提示：
 * 1 <= n <= 231 - 1
 * 通过次数34,018提交次数54,864
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits b = new BinaryNumberWithAlternatingBits();
        System.out.println(b.hasAlternatingBits(5));
        System.out.println(b.hasAlternatingBits(7));
        System.out.println(b.hasAlternatingBits(11));
        System.out.println(b.hasAlternatingBits(10));
    }

    public boolean hasAlternatingBits(int n) {
        // 对 n 的二进制右移一位，得到的数字再与 n 按位异或运算；
        // 当前仅当 n 位交替位二进制数时，得到的结果的数字二进制位才都是 1
        n = n ^ (n >> 1);
        return (n & (n + 1)) == 0;
    }
}
