package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/28 16:03
 * @description 717.1比特与2比特字符
 *
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 示例 1:
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 *
 * 示例 2:
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 *
 * 注意:
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 */
public class OneBitAndTwoBitCharacters {

    public static void main(String[] args) {
        OneBitAndTwoBitCharacters o = new OneBitAndTwoBitCharacters();
        System.out.println(o.isOneBitCharacter2(new int[]{1, 0, 0}));
        System.out.println(o.isOneBitCharacter2(new int[]{1, 1, 1, 0}));
        System.out.println(o.isOneBitCharacter2(new int[]{1, 1, 1, 1}));
    }

    /**
     * 贪心算法
     *
     * @param bits
     * @return
     */
    private boolean isOneBitCharacter2(int[] bits) {
        int i = bits.length - 2;
        // 因为只有 0，10，11 三种情况，0，10 中 0 都代表一个字符的结束位置
        // 所以从倒数第二位开始统计 1 的个数，直到统计到 0 结束位置
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        // 判断区间内1个数是偶数还是奇数
        // 如果 1 的个数为偶数，那么刚好两两组合成二比特字符，最后一位单个的肯定是一比特字符 0
        // 如果 1 的个数为奇数，那么多余出来的 1 需要后最后一位结合组成二比特字符，那么最后一位肯定不是一比特字符 0
        return (bits.length - i) % 2 == 0;
    }

    /**
     * 线性扫描
     *
     * @param bits
     * @return
     */
    private boolean isOneBitCharacter1(int[] bits) {
        int i = 0;
        // 如果 bits[i]=1，那么说明这是一个两比特字符，将 i 的值增加 2。
        // 如果 bits[i]=0，那么说明这是一个一比特字符，将 i 的值增加 1。
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        // 如果最后一位是一比特字符，那么 i==bit.length-1
        return i == bits.length - 1;
    }
}
