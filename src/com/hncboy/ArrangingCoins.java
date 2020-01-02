package com.hncboy;

/**
 * @author hncboy
 * @date 2020/1/2 19:52
 * @description 441.排列硬币
 *
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 *
 * 示例 2:
 * n = 8
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 因为第四行不完整，所以返回3.
 */
public class ArrangingCoins {

    public static void main(String[] args) {
        ArrangingCoins a = new ArrangingCoins();
        System.out.println(a.arrangeCoins(5));
        System.out.println(a.arrangeCoins(8));
    }

    private int arrangeCoins(int n) {
        long left = 0;
        long right = n;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            long t = (1 + mid) * mid / 2;
            if (t > n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}
