package com.hncboy;

/**
 * @author hncboy
 * @date 2021/10/18 8:51
 * @description 476.数字的补数
 * 
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 示例 1：
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 * 示例 2：
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *  
 *
 * 提示：
 * 给定的整数 num 保证在 32 位带符号整数的范围内。
 * num >= 1
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/
 * {@link ComplementOfBase10Integer} 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberComplement {

    public static void main(String[] args) {
        NumberComplement n = new NumberComplement();
        System.out.println(n.findComplement(5));
        System.out.println(n.findComplement(1));
    }

    public int findComplement(int num) {
        int s = -1;
        // 从高位到低位遍历，找到最高位 1 的位置赋给 s
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                s = i;
                break;
            }
        }

        int result = 0;
        // 从低位遍历到最高位 1 所在的位置
        for (int i = 0; i < s; i++) {
            // 如果该位是 0，则执行取反操作
            if (((num >> i) & 1) == 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
