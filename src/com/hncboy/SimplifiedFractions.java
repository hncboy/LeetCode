package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/2/10 8:49
 * 1447.最简分数
 *
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 *
 * 示例 3：
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 *
 * 示例 4：
 * 输入：n = 1
 * 输出：[]
 *
 * 提示：
 * 1 <= n <= 100
 * 通过次数 10,140 提交次数 15,519
 */
public class SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        // 遍历分母，分母从 2 开始
        for (int denominator = 2; denominator <= n; denominator++) {
            // 遍历分子，分子从 1 开始，分子小于分母
            for (int numerator = 1; numerator < denominator; numerator++) {
                // 判断分子和分母的最大公约数是否为最简
                if (gcd(numerator, denominator) == 1) {
                    result.add(numerator + "/" + denominator);
                }
            }
        }
        return result;
    }

    /**
     * 欧几里得算法求最大公约数
     */
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
