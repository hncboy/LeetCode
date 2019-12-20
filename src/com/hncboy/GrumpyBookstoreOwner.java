package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/20 17:08
 * @description 1052.爱生气的书店老板
 *
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。
 * 每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *
 * 示例：
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 * 提示：
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 */
public class GrumpyBookstoreOwner {

    public static void main(String[] args) {
        GrumpyBookstoreOwner g = new GrumpyBookstoreOwner();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(g.maxSatisfied(customers, grumpy, 3));
    }

    /**
     * @param customers 每分钟顾客进入人数
     * @param grumpy    1 生气 0 不生气
     * @param X         抑制情绪 X 分钟不生气
     * @return 多少顾客满意
     */
    private int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        // 计算不使用技能顾客满意数量
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }

        int releaseSkill = 0;
        // 计算 [0,X] 这个滑动窗口中释放技能的效果
        for (int j = 0; j < X; j++) {
            if (grumpy[j] == 1) {
                releaseSkill += customers[j];
            }
        }

        int max = releaseSkill;
        // 遍历计算对应滑动窗口中释放技能的效果
        for (int i = 1; i <= customers.length - X; i++) {
            // 如果滑动窗口最左边老板是生气的，则技能效果使用范围减去这一分钟顾客进入人数
            if (grumpy[i - 1] == 1) {
                releaseSkill -= customers[i - 1];
            }
            // 如果滑动窗口最右边老板是生气的，则技能效果使用范围加上这一分钟顾客进入人数
            if (grumpy[i + X - 1] == 1) {
                releaseSkill += customers[i + X - 1];
            }
            // 更新技能最大范围
            if (releaseSkill > max) {
                max = releaseSkill;
            }
        }
        return max + sum;
    }
}
