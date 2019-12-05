package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/5 10:12
 * @description 914.卡牌分组
 *
 * 给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 示例 1：
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * 示例 2：
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 3：
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 4：
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 *
 * 示例 5：
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */
public class XOfAKindInADeckOfCards {

    public static void main(String[] args) {
        XOfAKindInADeckOfCards x = new XOfAKindInADeckOfCards();
        System.out.println(x.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(x.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(x.hasGroupsSizeX(new int[]{1}));
        System.out.println(x.hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(x.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(x.hasGroupsSizeX(new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2}));
    }

    private boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            count[deck[i]]++;
        }

        int g = -1;
        // 求所有数的最大公约数，有的话则可以按最大公约数分组
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                if (g == -1) {
                    g = count[i];
                } else {
                    g = gcd(g, count[i]);
                }
            }
        }
        return g >= 2;
    }

    /**
     * 辗转相除法求最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
