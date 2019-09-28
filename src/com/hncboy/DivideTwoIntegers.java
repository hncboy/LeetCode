package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/13 13:54
 * @description TODO
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(-2147483648, 2));
        System.out.println(divide(1, 1));
        System.out.println(divide(10, -3));
        System.out.println(divide(10, 3));
        System.out.println(divide(-10, 3));
        System.out.println(divide(-1010369383, -2147483648));
        System.out.println(divide(-1, -1));
    }

    private static int divide(int dividend, int divisor) {
        /*long result = 0;
        long x = Math.abs((long) divisor);
        long y = Math.abs((long) dividend);
        while (y >= x) {
            long k = y, car = 1;
            while (k - (x << car) > 0) car++;

            y -= (x << (car - 1));
            ans += (1 << (car - 1));
        }

        if (dividend > 0 ^ divisor > 0) ans = -ans;

        if (ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) ans;*/
        return 1;
    }
}
