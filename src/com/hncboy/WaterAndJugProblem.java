package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/14 9:35
 * @description 365.水壶问题
 *
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。
 * 请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 *
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class WaterAndJugProblem {

    public static void main(String[] args) {
        WaterAndJugProblem w = new WaterAndJugProblem();
        System.out.println(w.canMeasureWater(3, 5, 4));
        System.out.println(w.canMeasureWater(2, 6, 5));
    }

    private boolean canMeasureWater(int x, int y, int z) {
        // z = a*x + b*y
        // x 和 y 的最大公约数为 g
        // z % g = 0
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);

    }

    /**
     * 辗转相除法求最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
