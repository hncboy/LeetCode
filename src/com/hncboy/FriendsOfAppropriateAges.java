package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/2 11:46
 * @description 825.适龄的朋友
 *
 * 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。
 *
 * 当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * 否则，A 可以给 B 发送好友请求。
 *
 * 注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 
 * 求总共会发出多少份好友请求?
 *  
 *
 * 示例 1:
 * 输入: [16,16]
 * 输出: 2
 * 解释: 二人可以互发好友申请。
 *
 * 示例 2:
 * 输入: [16,17,18]
 * 输出: 2
 * 解释: 好友请求可产生于 17 -> 16, 18 -> 17.
 *
 * 示例 3:
 * 输入: [20,30,100,110,120]
 * 输出: 3
 * 解释: 好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
 *
 * 说明:
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 */
public class FriendsOfAppropriateAges {

    public static void main(String[] args) {
        FriendsOfAppropriateAges f = new FriendsOfAppropriateAges();
        System.out.println(f.numFriendRequests(new int[]{16, 16}));
        System.out.println(f.numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(f.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }

    private int numFriendRequests(int[] ages) {
        // 年龄的范围是 0-120
        int[] array = new int[121];
        for (int age : ages) {
            array[age]++;
        }

        int result = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            // 统计满足年龄的人数
            int count = 0;
            // 在满足条件的最小年龄和最大年龄间遍历
            int minAgeB = ageA / 2 + 7 + 1;
            for(int ageB = minAgeB; ageB < ageA; ageB++) {
                count += array[ageB];
            }

            count *= array[ageA];
            // 加上年龄一样大的人数
            if (array[ageA] > 1 && ageA >= minAgeB) {
                count += array[ageA] * (array[ageA] - 1);
            }
            result += count;
        }
        return result;
    }
}
