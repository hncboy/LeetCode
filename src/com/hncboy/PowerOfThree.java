package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/9 8:20
 * @description 326. 3的幂
 *
 *给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 * 输入: 27
 * 输出: true
 *
 * 示例 2:
 * 输入: 0
 * 输出: false
 *
 * 示例 3:
 * 输入: 9
 * 输出: true
 *
 * 示例 4:
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class PowerOfThree {

    public static void main(String[] args) {
        PowerOfThree power = new PowerOfThree();
        assert power.isPowerOfThree2(27);
        assert power.isPowerOfThree2(0);
        assert power.isPowerOfThree2(9);
        assert power.isPowerOfThree2(45);
    }

    /**
     * 迭代
     * @param n
     * @return
     */
    private boolean isPowerOfThree2(int n) {
        while (n % 3 == 0 && n > 1) {
            n /= 3;
        }
        return n == 1;
    }

    private boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
