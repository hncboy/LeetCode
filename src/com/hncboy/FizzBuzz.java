package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/17 8:28
 * @description 412.Fizz Buzz
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 * n = 15,
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */
public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz f = new FizzBuzz();
        System.out.println(f.fizzBuzz(15));
    }

    private List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(fizz(i));
        }
        return result;
    }

    private String fizz(int n) {
        if (n%3 == 0 && n%5 == 0) {
            return "FizzBuzz";
        }
        if (n%3 == 0) {
            return "Fizz";
        }
        if (n%5 == 0) {
            return "Buzz";
        }
        return String.valueOf(n);
    }
}
