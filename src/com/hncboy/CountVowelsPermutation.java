package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/10/6 11:12
 * 1220.统计元音字母序列的数目
 *
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 *
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 *
 * 示例 3：
 * 输入：n = 5
 * 输出：68
 *
 * 提示：
 * 1 <= n <= 2 * 10^4
 */
public class CountVowelsPermutation {

    public static void main(String[] args) {
        CountVowelsPermutation cvp = new CountVowelsPermutation();
        System.out.println(cvp.countVowelPermutation(1));
        System.out.println(cvp.countVowelPermutation(2));
        System.out.println(cvp.countVowelPermutation(5));
        System.out.println(cvp.countVowelPermutation(144));
    }

    public int countVowelPermutation1(int n) {
        // 对应 a e i o u 结尾的数量
        double[] vowelCount = new double[]{1, 1, 1, 1, 1};
        double[] vowelTempCount = new double[5];
        double mod = 1e9 + 7;
        for (int j = 1; j < n; j++) {
            vowelTempCount[0] = (vowelCount[1] + vowelCount[2] + vowelCount[4]) % mod;
            vowelTempCount[1] = (vowelCount[0] + vowelCount[2]) % mod;
            vowelTempCount[2] = (vowelCount[1] + vowelCount[3]) % mod;
            vowelTempCount[3] = vowelCount[2] % mod;
            vowelTempCount[4] = (vowelCount[2] + vowelCount[3]) % mod;
            System.arraycopy(vowelTempCount, 0, vowelCount, 0, 5);
        }
        return (int) ((Arrays.stream(vowelCount).sum()) % mod);
    }

    /**
     * 矩阵快速幂 TODO 忘记了
     */
    public int countVowelPermutation(int n) {
        long mod = 1_000_000_007;
        long[][] factor =
                {
                        {0, 1, 0, 0, 0},
                        {1, 0, 1, 0, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0}
                };

        long[][] res = fastPow(factor, n - 1, mod);
        long ans = 0;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                ans = (ans + res[i][j]) % mod;
            }
        }
        return (int)ans;
    }

    private long[][] fastPow(long[][] matrix, int n, long mod) {
        int m = matrix.length;
        long[][] res = new long[m][m];
        long[][] curr = matrix;

        for (int i = 0; i < m; ++i) {
            res[i][i] = 1;
        }
        for (int i = n; i != 0; i >>= 1) {
            if ((i % 2) == 1) {
                res = multiply(curr, res, mod);
            }
            curr = multiply(curr, curr, mod);
        }
        return res;
    }

    private long[][] multiply(long[][] matrixA, long[][] matrixB, long mod) {
        int m = matrixA.length;
        int n = matrixB[0].length;
        long[][] res = new long[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[i][j] = 0;
                for (int k = 0; k < matrixA[i].length; ++k) {
                    res[i][j] = (res[i][j] + matrixA[i][k] * matrixB[k][j]) % mod;
                }
            }
        }
        return res;
    }
}
