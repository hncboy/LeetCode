package com.hncboy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hncboy
 * @date 2019/12/4 10:19
 * @description 888.公平的糖果交换
 *
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。
 * （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 *
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 */
public class FairCandySwap {

    public static void main(String[] args) {
        FairCandySwap f = new FairCandySwap();
        System.out.println(Arrays.toString(f.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(f.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(Arrays.toString(f.fairCandySwap(new int[]{2}, new int[]{1, 3})));
        System.out.println(Arrays.toString(f.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }

    private int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int x : A) {
            sumA += x;
        }
        /*
          x为A送出去的糖果，y为B送出去的糖果
          sumA-x+y=sumB-y+x
          y=x+(sumA-sumB)/2
          B中只要有满足这个公式的就符合条件
         */
        Set<Integer> setB = new HashSet<>();
        int sumB = 0;
        for (int y : B) {
            sumB += y;
            setB.add(y);
        }
        int delta = (sumB - sumA) / 2;
        for (int x : A) {
            if (setB.contains(x + delta)) {
                return new int[]{x, x + delta};
            }
        }
        return null;
    }
}
