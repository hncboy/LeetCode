package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/5 12:42
 * @description 372.超级次方
 * 
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 示例 1：
 * 输入：a = 2, b = [3]
 * 输出：8
 * 
 * 示例 2：
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 
 * 示例 3：
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 
 * 示例 4：
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 * 
 * 提示：
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 * 通过次数 22,996 提交次数 42,141
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-pow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SuperPow {

    private final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int result = 1;
        // 遍历数组的每一位，每一次扩大 10 倍
        for (int n : b) {
            result = pow(result, 10) * pow(a, n) % MOD;
        }
        return result;
    }

    /**
     * 快速幂
     */
    public int pow(int x, int n) {
        int result = 1;
        x %= MOD;
        while (n != 0) {
            // 如果是奇数，则需要多乘个 x
            if (n % 2 == 1) {
                result = result * x % MOD;
            }
            x = x * x % MOD;
            n /= 2;
        }
        return result;
    }
}
