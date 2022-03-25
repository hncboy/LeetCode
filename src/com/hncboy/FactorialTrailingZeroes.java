package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/10 11:04
 * 172.阶乘后的零
 *
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 
 * 示例 2：
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 
 * 示例 3：
 * 输入：n = 0
 * 输出：0
 *
 * 提示：
 * 0 <= n <= 104
 *
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 * 通过次数 111,957 提交次数 242,315
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        FactorialTrailingZeroes f = new FactorialTrailingZeroes();
        System.out.println(f.trailingZeroes(3));
        System.out.println(f.trailingZeroes(5));
        System.out.println(-1%5);
    }

    public int trailingZeroes(int n) {
        // 当前数乘以10就能得到一个0
        // 10 = 2*5，2出现的次数明显多余5的次数，所以统计 5 出现的次数
        // 每隔5个数，出现1个5，每个25个数出现2个5，每个125个数，出现3个5，依次类推
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
