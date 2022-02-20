package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/28 16:03
 * 717.1比特与2比特字符
 *
 * 有两种特殊字符：
 * 第一种字符可以用一个比特 0 来表示
 * 第二种字符可以用两个比特(10 或 11)来表示、
 * 给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。
 *
 * 示例 1:
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 *
 * 示例 2:
 * 输入: bits = [1, 1, 1, 0]
 * 输出: false
 * 解释: 唯一的编码方式是两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 *
 * 提示:
 * 1 <= bits.length <= 1000
 * bits[i] == 0 or 1
 * 通过次数47,121提交次数87,236
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OneBitAndTwoBitCharacters {

    public static void main(String[] args) {
        OneBitAndTwoBitCharacters o = new OneBitAndTwoBitCharacters();
        System.out.println(o.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(o.isOneBitCharacter(new int[]{1, 1, 1, 0}));
        System.out.println(o.isOneBitCharacter(new int[]{1, 1, 1, 1}));
    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        // 因为只有 0，10，11 三种情况，0、10 中 0 都代表一个字符的结束位置
        // 所以从倒数第二位开始统计 1 的个数，直到统计到 0 结束位置
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        // 判断区间内1个数是偶数还是奇数
        // 如果 1 的个数为偶数，那么刚好两两组合成二比特字符，最后一位单个的肯定是一比特字符 0
        // 如果 1 的个数为奇数，那么多余出来的 1 需要后最后一位结合组成二比特字符，那么最后一位肯定不是一比特字符 0
        return (bits.length - i) % 2 == 0;
    }
}
