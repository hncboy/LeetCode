package com.hncboy;

/**
 * @author hncboy
 * @date 2022/2/22 9:27
 * 1994.好子集的数目 TODO
 */
public class TheNumberOfGoodSubsets {

    /**
     * 1-30 中的质数
     */
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int NUM_MAX = 30;
    private static final int MOD = 1000000007;

    public int numberOfGoodSubsets(int[] nums) {
        // 统计每个数出现的次数
        int[] freq = new int[NUM_MAX + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // 用一个长度为 10 的二进制数组表示质数的使用情况
        int[] f = new int[1 << PRIMES.length];
        f[0] = 1;
        for (int i = 0; i < freq[1]; ++i) {
            f[0] = f[0] * 2 % MOD;
        }

        for (int i = 2; i <= NUM_MAX; ++i) {
            if (freq[i] == 0) {
                continue;
            }

            // 检查 i 的每个质因数是否均不超过 1 个
            int subset = 0, x = i;
            boolean check = true;
            for (int j = 0; j < PRIMES.length; ++j) {
                int prime = PRIMES[j];
                if (x % (prime * prime) == 0) {
                    check = false;
                    break;
                }
                if (x % prime == 0) {
                    subset |= (1 << j);
                }
            }
            if (!check) {
                continue;
            }

            // 动态规划
            for (int mask = (1 << PRIMES.length) - 1; mask > 0; --mask) {
                if ((mask & subset) == subset) {
                    f[mask] = (int) ((f[mask] + ((long) f[mask ^ subset]) * freq[i]) % MOD);
                }
            }
        }

        int ans = 0;
        for (int mask = 1, maskMax = (1 << PRIMES.length); mask < maskMax; ++mask) {
            ans = (ans + f[mask]) % MOD;
        }

        return ans;
    }
}
